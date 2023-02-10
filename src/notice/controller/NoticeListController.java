package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.service.NoticeServiceImpl;
import notice.model.vo.Notice;
import notice.model.vo.PageData;
import notice.model.vo.Pagenation;

/**
 * Servlet implementation class NoticeListController
 */
@WebServlet("/notice/list.do")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeService nService = new NoticeServiceImpl();
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		Pagenation pagenation = new Pagenation(page, 10);
		PageData pd = nService.printAllNotice(pagenation);
		List<Notice> nList = pd.getNoticeList();
		String pageNavi = pd.getPageNavigator();
		if (!nList.isEmpty()) {
			//성공
			request.setAttribute("nList", nList);
			request.setAttribute("pageNavi", pageNavi); //이거 안적어주면 납작하게 안나옴....
			request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(request, response);
		} else {
			request.setAttribute("title", "서비스 실패");
			request.setAttribute("msg", "공지사항 목록 조회가 되지 않습니다");
			request.setAttribute("url", "/notice/list.do"); //잘못하면 무한반복한대. 첫페이지에서부터 오류났을때ㅇㅇ
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

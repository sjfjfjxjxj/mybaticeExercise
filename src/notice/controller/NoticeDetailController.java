package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.service.NoticeServiceImpl;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeDetailController
 */
@WebServlet("/notice/detail.do")
public class NoticeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeDetailController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String noticeNum = request.getParameter("notice-no") != null ? request.getParameter("notice-no") : "0";
		int noticeNo = Integer.parseInt(noticeNum);
		//jsp에서 넘어오는 notice-no라는 애가 있니?(널체크) 있으면 얠 넘겨보낼거고 없으면 0을 반환할거야.
		//넘버포멧익셉션 예외처리. /notice/detail.do 요청하면 request.getParameter("notice-no")는 ""이 됨
		NoticeService nService = new NoticeServiceImpl();
		Notice notice = nService.printOneByNo(noticeNo); //여기까지 서비스->스토어->매퍼까지 다 준비해준다음
		
		if(notice != null) {
			request.setAttribute("notice",  notice);
			request.getRequestDispatcher("/WEB-INF/views/notice/detail.jsp").forward(request, response);
		}else {
			request.setAttribute("title", "서비스 실패");
			request.setAttribute("msg", "데이터 조회 실패했어요");
			request.setAttribute("url", "/notice/list.do");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
			
		}
		
				
//		request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(request, response);
//		request.setCharacterEncoding("UTF-8");
		
//		int noticeNo = Integer.parseInt(request.getParameter("noticeNo???"));
//		NoticeService nService = new NoticeServiceImpl();
//		Notice noticeOne = nService.showOneNotice(noticeNo);
//		if (noticeOne != null) {
//			request.getRequestDispatcher("/WEB-INF/views/notice/detail.jsp?noticeNo=").forward(request, response);
//		} else {
//			System.out.println("실패");
//		}
	}

}

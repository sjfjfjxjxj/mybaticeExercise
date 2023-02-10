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
 * Servlet implementation class NoticeModifyController
 */
@WebServlet("/notice/modify.do")
public class NoticeModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeNum = request.getParameter("notice-no")!= null ? request.getParameter("notice-no") : "0";
		int noticeNo = Integer.parseInt(noticeNum);
		NoticeService nService = new NoticeServiceImpl();
		Notice notice = nService.printOneByNo(noticeNo);
		request.setAttribute("notice", notice); //노티스를 리퀘스트스코프에 저장함
		request.getRequestDispatcher("/WEB-INF/views/notice/modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String noticeNum = request.getParameter("notice-no")!=null? request.getParameter("notice-no") : "0";
		int noticeNo = Integer.parseInt(noticeNum);
		Notice notice = new Notice(noticeNo, subject, content, "admin");
		NoticeService nService = new NoticeServiceImpl();
		int result = nService.modifyNotice(notice);
		String goDetail = "/notice/detail.do?notice-no="+noticeNo;
		if(result>0) {
			response.sendRedirect(goDetail);
			
		}else {
			request.setAttribute("title", "서비스실패");
			request.setAttribute("msg", "수정 미완료!!!!");
			request.setAttribute("url", goDetail);
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
			
	}

}

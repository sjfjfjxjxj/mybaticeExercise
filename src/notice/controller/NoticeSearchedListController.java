package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeSearchedListController
 */
@WebServlet("/notice/list.do")
public class NoticeSearchedListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSearchedListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchSubject= request.getParameter("search-subject");
		String searchContent= request.getParameter("search-content");
		String searchWriter= request.getParameter("search-writer");
		
		if(searchSubject != null) {
			
		}else if(searchContent != null) {
			
		}else {
			
		}
		request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(request, response);
	}

}

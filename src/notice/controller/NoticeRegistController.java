package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import notice.model.service.NoticeService;
import notice.model.service.NoticeServiceImpl;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeRegistController
 */
@WebServlet("/notice/regist.do")
public class NoticeRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NoticeRegistController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		SqlSession session = SqlSessionTemplate.getSqlSession(); 연결만드는 얘네는 서비스로 가고
//		int result = session.insert("NoticeMapper.insertNotice"); 얘는 스토어로 가고
//		System.out.println("0실패 1 성공: " + result); 인제 얘들은 필요없다. 
		
		 request.getRequestDispatcher("/WEB-INF/views/notice/write.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글이 넘어오니깐!
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		Notice notice = new Notice(subject, content, "admin");
		NoticeService nService = new NoticeServiceImpl();
		int result = nService.insertNotice(notice);
		if(result>0) {
			//성공페이지로 이동
			System.out.println("성공");
		}else {
			//실패페이지 이동
			System.out.println("실패");
		}
	}

}

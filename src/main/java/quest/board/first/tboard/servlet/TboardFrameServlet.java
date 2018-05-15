package quest.board.first.tboard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TboardFrameServlet.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 15.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 15. "K.S.J" 최초 생성
 *
 * </pre>
 */
@WebServlet("/tboardFrame")
public class TboardFrameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TboardFrameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String choosePage = "";
		String nextPage = "";
		
		if (request.getParameter("choosePage") != null) {
			choosePage = (String)request.getParameter("choosePage");
			
			if(choosePage.equals("tboardInsert")) {
				request.setAttribute("choosePage", "tboardInsert");
				nextPage = "/board/boardNav.jsp";
			}
			
			
			
			request.getRequestDispatcher(nextPage).forward(request, response);
			
		} else {
			choosePage = (String) request.getAttribute("choosePage");
			nextPage = "/" + choosePage;
			request.getRequestDispatcher(nextPage).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

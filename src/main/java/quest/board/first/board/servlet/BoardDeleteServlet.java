package quest.board.first.board.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.board.first.board.service.BoardService;
import quest.board.first.board.service.BoardServiceInf;

/**
 * BoardDeleteServlet.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 16.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 16. "K.S.J" 최초 생성
 *
 * </pre>
 */
@WebServlet("/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_seq = request.getParameter("board_seq");
		String board_tboard_seq = request.getParameter("board_tboard_seq");
		
		BoardServiceInf service = BoardService.getInstance();
		service.updateBoard_del_yn(board_seq);
		
		request.getSession().setAttribute("board_tboard_seq", board_tboard_seq);
		response.sendRedirect(request.getContextPath() + "/boardList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

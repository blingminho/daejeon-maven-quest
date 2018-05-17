package quest.board.first.board.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.board.first.board.service.BoardService;
import quest.board.first.board.service.BoardServiceInf;
import quest.board.first.fileadd.service.FileAddService;
import quest.board.first.fileadd.service.FileAddServiceInf;
import quest.board.first.vo.BoardVO;
import quest.board.first.vo.FileAddVO;

/**
 * BoardUpdateServlet.java
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
@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_seq = request.getParameter("board_seq");
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		
		BoardServiceInf boardService = BoardService.getInstance();
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_seq(board_seq);
		boardVO.setBoard_title(board_title);
		boardVO.setBoard_content(board_content);
		boardService.updateBoard(boardVO);
		
		FileAddServiceInf fileAddService = FileAddService.getInstance();
		
		List<FileAddVO> fileAddVOList = new ArrayList<FileAddVO>();
		fileAddService.updateFileAdd(fileAddVOList);
		
		
		//해당 게시판 상세화면으로 이동
//		request.getSession().setAttribute("board_tboard_seq", board_tboard_seq);
//		response.sendRedirect(request.getContextPath() + "/boardList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

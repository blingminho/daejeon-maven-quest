package quest.board.first.board.servlet;

import java.io.IOException;
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

@WebServlet("/boardInfo")
public class BoardInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public BoardInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String board_seq = request.getParameter("board_seq");
		
		BoardServiceInf boardService = BoardService.getInstance();
		FileAddServiceInf fileAddService = FileAddService.getInstance();

		BoardVO boardVO = boardService.getBoardInfo(board_seq);
		List<FileAddVO> fileAddVOList = fileAddService.getFileAdd(board_seq);
		//댓글도 추가 필요~~~
		
		request.setAttribute("boardVO", boardVO);
		request.setAttribute("fileAddVOList", fileAddVOList);
		//댓글도 추가 필요~~~
		
		request.getRequestDispatcher("/board/boardInfo.jsp").forward(request, response);
		
	}

}

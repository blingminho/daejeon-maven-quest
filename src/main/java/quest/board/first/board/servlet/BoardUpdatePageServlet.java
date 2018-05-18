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
import quest.board.first.tboard.service.TboardService;
import quest.board.first.tboard.service.TboardServiceInf;
import quest.board.first.vo.BoardVO;
import quest.board.first.vo.FileAddVO;
import quest.board.first.vo.TboardVO;

@WebServlet("/boardUpdatePage")
public class BoardUpdatePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardUpdatePageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//update jsp로 전송
		String board_seq = request.getParameter("board_seq");
		BoardServiceInf boardService = BoardService.getInstance();
		FileAddServiceInf fileAddService = FileAddService.getInstance();
		TboardServiceInf tboardService = TboardService.getInstance();
		
		BoardVO boardVO = boardService.getBoardInfo(board_seq);
		List<FileAddVO> fileAddVOList = fileAddService.getFileAdd(board_seq);
		TboardVO tboardVO = new TboardVO();
		tboardVO.setTboard_seq(boardVO.getBoard_tboard_seq());
		String tboard_title = tboardService.getTboard(tboardVO).getTboard_title();
		
		System.out.println("fileAddVOList.size() : " + fileAddVOList.size());
		
		request.setAttribute("boardVO", boardVO);
		request.setAttribute("fileAddVOList", fileAddVOList);
		request.setAttribute("tboard_title", tboard_title);
		
		request.getRequestDispatcher("/board/boardUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

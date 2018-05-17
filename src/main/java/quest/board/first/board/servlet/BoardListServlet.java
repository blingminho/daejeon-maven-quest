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
import quest.board.first.tboard.service.TboardService;
import quest.board.first.tboard.service.TboardServiceInf;
import quest.board.first.vo.BoardVO;
import quest.board.first.vo.TboardVO;

@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_tboard_seq = request.getParameter("board_tboard_seq");
		if (board_tboard_seq == null) {
			board_tboard_seq = (String)request.getSession().getAttribute("board_tboard_seq");
		}
		
		String pageNum = request.getParameter("pageNum");
		
		TboardServiceInf tboardService = TboardService.getInstance();
		List<TboardVO> tboardListTmp = tboardService.getTboardList();
		
		List<TboardVO> tboardList = new ArrayList<TboardVO>();
		for (TboardVO tboardvo : tboardListTmp) {
			if (tboardvo.getTboard_del_yn().equals("Y")) {
				tboardList.add(tboardvo);
			}
		}
		
		
		TboardVO tboardVO = null;
		
		if (board_tboard_seq == null && tboardList.size() != 0) {
			tboardVO = tboardList.get(0);
			board_tboard_seq = tboardVO.getTboard_seq();
		} else {
			tboardVO = new TboardVO();
			tboardVO.setTboard_seq(board_tboard_seq);
			tboardVO = tboardService.getTboard(tboardVO);
		}
		
		
		pageNum = (pageNum == null ? "1" : pageNum);
		
		BoardServiceInf boardService = BoardService.getInstance();
		
		int count = boardService.getBoardListCount(board_tboard_seq);
		List<BoardVO> boardList = boardService.getBoardPagingList(board_tboard_seq, pageNum);
		
		int pageCount = 0; 
		if (count != 0) {
			pageCount = (int) Math.ceil(count/10d);
		}
		
		request.getSession().setAttribute("pageChoose", "BoardList");
		
		request.setAttribute("tboardList", tboardList);
		request.setAttribute("tboardVO", tboardVO);
		
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("boardList", boardList);
		
		request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

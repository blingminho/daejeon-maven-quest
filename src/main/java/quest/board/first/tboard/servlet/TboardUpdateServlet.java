package quest.board.first.tboard.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.board.first.tboard.service.TboardService;
import quest.board.first.tboard.service.TboardServiceInf;
import quest.board.first.vo.TboardVO;

/**
 * TboardUpdateServlet.java
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
@WebServlet("/tboardUpdate")
public class TboardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TboardUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String tboard_seq = request.getParameter("tboard_seq");
		String tboard_del_yn = request.getParameter("tboard_del_yn");
		
		TboardServiceInf tboardService = TboardService.getInstance();
		
		TboardVO tboardVO = new TboardVO();
		tboardVO.setTboard_seq(tboard_seq);
		tboardVO.setTboard_del_yn(tboard_del_yn);
		
		int result = tboardService.updateTboardYN(tboardVO);
		List<TboardVO> list = tboardService.getTboardList();
		
		if (result == 1) {
			request.setAttribute("tboardList", list);
			request.getRequestDispatcher("/board/tboardList.jsp").forward(request, response);
		} else {
			new Error("tboard updateTboardYN error").printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

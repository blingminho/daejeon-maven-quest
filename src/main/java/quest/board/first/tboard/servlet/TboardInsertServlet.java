package quest.board.first.tboard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.board.first.tboard.service.TboardService;
import quest.board.first.tboard.service.TboardServiceInf;
import quest.board.first.vo.TboardVO;

/**
 * TboardInsertServlet.java
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
@WebServlet("/tboardInsert")
public class TboardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TboardInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String tboard_title = request.getParameter("tboard_title");
		String tboard_mem_id = request.getParameter("tboard_mem_id");
		
		TboardServiceInf tboardService = TboardService.getInstance();
		
		TboardVO tboardVO = new TboardVO();
		tboardVO.setTboard_title(tboard_title);
		tboardVO.setTboard_mem_id(tboard_mem_id);
		
		int result = tboardService.insertTboard(tboardVO);
		
		response.sendRedirect(request.getContextPath() + "/tboardList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

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
 * TboardListServlet.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 14.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 14. "K.S.J" 최초 생성
 *
 * </pre>
 */
@WebServlet("/tboardList")
public class TboardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TboardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		TboardServiceInf tboardService = TboardService.getInstance();
		List<TboardVO> list = tboardService.getTboardList();
		
		request.getSession().setAttribute("pageChoose", "tboardList");
		
		request.setAttribute("tboardList", list);
		request.getRequestDispatcher("/board/tboardList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

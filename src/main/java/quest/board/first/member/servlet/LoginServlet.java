package quest.board.first.member.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.board.first.member.service.MemberService;
import quest.board.first.member.service.MemberServiceInf;
import quest.board.first.vo.MemberVO;

/**
 * LoginServlet.java
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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		
		MemberVO memberVO = new MemberVO(mem_id, mem_pass);
		
		MemberServiceInf memberService = MemberService.getInstance();
		
		MemberVO returnMemberVO = memberService.memberLogin(memberVO);
		boolean flag = memberService.loginYN(mem_id, returnMemberVO);
		
		if (flag) {
			request.getSession().setAttribute("MemberVO", returnMemberVO);
			response.sendRedirect(request.getContextPath() + "/board/boardList.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/home/login.jsp");
		}
	}

}

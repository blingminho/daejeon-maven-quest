package quest.board.first.test.member;

import static org.junit.Assert.*;

import org.junit.Test;

import quest.board.first.member.service.MemberService;
import quest.board.first.member.service.MemberServiceInf;
import quest.board.first.vo.MemberVO;

/**
 * MemberServiceTest.java
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
public class MemberServiceTest {

	/**
	 * Method : memberLoginTest
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : 로그인 테스트
	 */
	@Test
	public void memberLoginTest() {
		/***Given***/
		MemberServiceInf service = MemberService.getInstance();

		String mem_id = "test_id_1";
		String mem_pass = "test_pw_1";
		String mem_alias = "test_alias_1";
		MemberVO memberVO = new MemberVO(mem_id, mem_pass);

		/***When***/
		MemberVO returnMemberVO = service.memberLogin(memberVO);
		
		/***Then***/
		assertEquals(mem_id, returnMemberVO.getMem_id());
		assertEquals(mem_alias, returnMemberVO.getMem_alias());
		
	}
	
	@Test
	public void loginYNTest(){
		/***Given***/
		MemberServiceInf service = MemberService.getInstance();
		String mem_id = "test_id_1";
		String mem_pass = "test_pw_1";
		MemberVO memberVO = new MemberVO(mem_id, mem_pass);
		MemberVO returnMemberVO = service.memberLogin(memberVO);
		
		/***When***/
		boolean flag = service.loginYN(mem_id, returnMemberVO);
		
		/***Then***/
		assertTrue(flag);
	}
	

}

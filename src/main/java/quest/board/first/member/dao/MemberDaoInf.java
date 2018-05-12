package quest.board.first.member.dao;

import quest.board.first.vo.MemberVO;

/**
 * MemberDaoInf.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 12.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 12. "K.S.J" 최초 생성
 *
 * </pre>
 */
public interface MemberDaoInf {
	
	/**
	 * Method : memberLogin
	 * 최초작성일 : 2018. 5. 12.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param memberVO (mem_id, mem_pass를 가진 인스턴스)
	 * @return 해당 회원 반환(id와 별명을 가짐)
	 * Method 설명 : login 기능
	 */
	public MemberVO memberLogin(MemberVO memberVO);

}

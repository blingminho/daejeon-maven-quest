package quest.board.first.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import quest.board.first.util.MybatisSqlSessionFactory;
import quest.board.first.vo.MemberVO;

/**
 * MemberDao.java
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
public class MemberDao implements MemberDaoInf {
	
	private static MemberDaoInf memberDao = null;
	private SqlSessionFactory sqlSessionFactory = null;
	
	private MemberDao(){
		sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
	}
	
	/**
	 * Method : getInstance
	 * 최초작성일 : 2018. 5. 12.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return MemberDao 인스턴스
	 * Method 설명 : MemberDao 인스턴스 반환
	 */
	public static MemberDaoInf getInstance() {
		if(memberDao == null)
			memberDao = new MemberDao();
		return memberDao;
	}

	/**
	 * Method : memberLogin
	 * 최초작성일 : 2018. 5. 12.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param memberVO (mem_id, mem_pass를 가진 인스턴스)
	 * @return 해당 회원 반환(id와 별명을 가짐)
	 * Method 설명 : login 기능
	 */
	@Override
	public MemberVO memberLogin(MemberVO memberVO) {
//		MemberVO resultMemberVO = new MemberVO();
//		resultMemberVO.setMem_id("test_id_1");
//		resultMemberVO.setMem_alias("test_alias_1");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberVO resultMemberVO = sqlSession.selectOne("member.memberLogin", memberVO);
		sqlSession.close();
		
		return resultMemberVO;
	}
	
	
	
	
	
	
	
	
	
	
	
}

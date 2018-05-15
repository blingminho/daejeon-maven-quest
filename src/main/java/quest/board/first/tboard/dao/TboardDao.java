package quest.board.first.tboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import quest.board.first.util.MybatisSqlSessionFactory;
import quest.board.first.vo.TboardVO;
/**
 * TboardDao.java
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
public class TboardDao implements TboardDaoInf {
	private static TboardDaoInf tboardDao = null;
	private SqlSessionFactory sqlSessionFactory = null;
	
	private TboardDao(){
		sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
	}
	
	/**
	 * Method : getInstance
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return TboardDao 인스턴스
	 * Method 설명 : TboardDao 인스턴스 반환
	 */
	public static TboardDaoInf getInstance() {
		if(tboardDao == null)
			tboardDao = new TboardDao();
		return tboardDao;
	}
	
	/**
	 * Method : getTboardList
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 목록 가져옴
	 */
	@Override
	public List<TboardVO> getTboardList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<TboardVO> list = sqlSession.selectList("tboard.getTboardList");
		sqlSession.close();
		return list;
	}
	
	/**
	 * Method : getTboard
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param tboardVO 최소한 seq를 가진 인스턴스
	 * @return 해당 게시판의 모든 정보 가져옴
	 * Method 설명 : 해당 seq를 가진 게시판 가져옴
	 */
	@Override
	public TboardVO getTboard(TboardVO tboardVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		tboardVO = sqlSession.selectOne("tboard.getTboard", tboardVO);
		sqlSession.close();
		return tboardVO;
	}
	
	/**
	 * Method : updateTboardYN
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param tboardVO 해당 게시판 vo
	 * @return update된 튜플 수
	 * Method 설명 : 활성화여부 update
	 */
	@Override
	public int updateTboardYN(TboardVO tboardVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.update("tboard.updateTboardYN", tboardVO);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}

	/**
	 * Method : insertTboard
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param tboardVO 새로운 게시판
	 * @return insert된 튜플 수
	 * Method 설명 : 새로운 게시판을 DB에 insert한다. insert된 튜플수 반환
	 */
	@Override
	public int insertTboard(TboardVO tboardVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.update("tboard.insertTboard", tboardVO);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}

}

package quest.board.first.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import quest.board.first.util.MybatisSqlSessionFactory;
import quest.board.first.vo.BoardVO;

/**
 * BoardDao.java
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
public class BoardDao implements BoardDaoInf {
	
	private static BoardDaoInf boardDao = null;
	private SqlSessionFactory sqlSessionFactory = null;
	
	private BoardDao(){
		sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
	}
	
	/**
	 * Method : getInstance
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return BoardDao 인스턴스
	 * Method 설명 : BoardDao 인스턴스 반환
	 */
	public static BoardDaoInf getInstance() {
		if(boardDao == null)
			boardDao = new BoardDao();
		return boardDao;
	}

	@Override
	public List<BoardVO> getBoardPagingList(String board_tboard_seq, String pageNum) {
		SqlSession session = sqlSessionFactory.openSession();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("board_tboard_seq", board_tboard_seq);
		map.put("pageNum", pageNum);
		List<BoardVO> list = session.selectList("board.getBoardPagingList", map);
		session.close();
		
		return list;
	}
	
	
	@Override
	public int getBoardListCount(String board_tboard_seq) {
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println("board_tboard_seq : " + board_tboard_seq);
		int result = session.selectOne("board.getBoardListCount", board_tboard_seq);
		session.close();
				
		return result;
	}


}

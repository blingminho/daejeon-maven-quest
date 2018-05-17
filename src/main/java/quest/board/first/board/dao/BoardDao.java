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

	/**
	 * Method : getBoardPagingList
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param board_tboard_seq 해당 게시판 번호
	 * @param pageNum 해당 페이지 번호
	 * @return
	 * Method 설명 : 게시판의 페이지번호에 맞는 게시글 목록을 반환
	 */
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
	
	/**
	 * Method : getBoardListCount
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param board_tboard_seq 게시판번호
	 * @return
	 * Method 설명 : 게시판의 모든 게시글 수를 반환
	 */
	@Override
	public int getBoardListCount(String board_tboard_seq) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.selectOne("board.getBoardListCount", board_tboard_seq);
		session.close();
				
		return result;
	}

	/**
	 * Method : insertBoard
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param boardVO
	 * @return
	 * Method 설명 : 일반적인 글쓰기(부모글 없음)
	 */
	@Override
	public int insertBoard(BoardVO boardVO) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.insert("board.insertBoard", boardVO);
		session.commit();
		session.close();
		return result;
	}
	
	/**
	 * Method : insertBoardP
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param boardVO
	 * @return
	 * Method 설명 : 부모글에 계층형글쓰기
	 */
	@Override
	public int insertBoardP(BoardVO boardVO) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.insert("board.insertBoardP", boardVO);
		session.commit();
		session.close();
		return result;
	}

	/**
	 * Method : getBoardInfo
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param board_seq
	 * @return
	 * Method 설명 : 게시글의 모든정보조회(게시글번호이용) - 계층형글쓰기에도 사용함
	 */
	@Override
	public BoardVO getBoardInfo(String board_seq) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardVO result = session.selectOne("board.getBoardInfo", board_seq);
		session.close();
		return result;
	}

	/**
	 * Method : updateBoard_del_yn
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param board_seq
	 * @return
	 * Method 설명 : 해당 게시글의 사용여부를 N으로 변경
	 */
	@Override
	public int updateBoard_del_yn(String board_seq) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.update("board.updateBoard_del_yn", board_seq);
		session.commit();;
		session.close();
		
		return result;
	}

	/**
	 * Method : updateBoard
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param boardVO
	 * @return
	 * Method 설명 : 해당 게시글 수정
	 */
	@Override
	public int updateBoard(BoardVO boardVO) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.update("board.updateBoard", boardVO);
		session.commit();
		session.close();
		
		return result;
	}

	
	
	
}

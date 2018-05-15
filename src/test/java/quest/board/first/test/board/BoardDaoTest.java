package quest.board.first.test.board;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import quest.board.first.board.dao.BoardDao;
import quest.board.first.board.dao.BoardDaoInf;
import quest.board.first.vo.BoardVO;

/**
 * BoardDaoTest.java
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
public class BoardDaoTest {
	
	/**
	 * Method : getBoardPagingListTest
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : getBoardPagingList Test
	 */
	@Test
	public void getBoardPagingListTest() {
		/***Given***/
		BoardDaoInf boardDao = BoardDao.getInstance();
		String board_tboard_seq = "1";
		String pageNum = "1";

		/***When***/
		List<BoardVO> list = boardDao.getBoardPagingList(board_tboard_seq, pageNum);
		
		/***Then***/
		assertEquals(10, list.size());
	}
	
	/**
	 * Method : getBoardListCountTest
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : getBoardListCount Test
	 */
	public void getBoardListCountTest() {
		/***Given***/
		BoardDaoInf boardDao = BoardDao.getInstance();
		String board_tboard_seq = "1"; 

		/***When***/
		int result = boardDao.getBoardListCount(board_tboard_seq);
		
		/***Then***/
		assertEquals(10, result);
	}
	
	
}

package quest.board.first.test.board;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import quest.board.first.board.service.*;
import quest.board.first.vo.BoardVO;

/**
 * BoardServiceTest.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 16.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 16. "K.S.J" 최초 생성
 *
 * </pre>
 */
public class BoardServiceTest {

	/**
	 * Method : getBoardPagingListTest
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : getBoardPagingList Test
	 */
	@Test
	public void getBoardPagingListTest() {
		/***Given***/
		BoardServiceInf boardService = BoardService.getInstance();
		String board_tboard_seq = "1";
		String pageNum = "1";

		/***When***/
		List<BoardVO> list = boardService.getBoardPagingList(board_tboard_seq, pageNum);
		
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
		BoardServiceInf boardService = BoardService.getInstance();
		String board_tboard_seq = "1"; 

		/***When***/
		int result = boardService.getBoardListCount(board_tboard_seq);
		
		/***Then***/
		assertEquals(10, result);
	}
	
	/**
	 * Method : insertBoardTest
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 :
	 */
	@Test
	public void insertBoardTest() {
		/***Given***/
		BoardServiceInf boardService = BoardService.getInstance();
		String board_tboard_seq = "1";
		String board_title = "board_title";
		String board_content = "board_content";
		String board_mem_id = "test_id_1";
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_tboard_seq(board_tboard_seq);
		boardVO.setBoard_title(board_title);
		boardVO.setBoard_content(board_content);
		boardVO.setBoard_mem_id(board_mem_id);
		
		/***When***/
		int result = boardService.insertBoard(boardVO);
		
		/***Then***/
		assertEquals(1, result);
	}
	
	/**
	 * Method : insertBoardP
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 :
	 */
	@Test
	public void insertBoardPTest() {
		/***Given***/
		BoardServiceInf boardService = BoardService.getInstance();
		String board_tboard_seq = "1";
		String board_title = "board_title_p";
		String board_content = "board_content_p";
		String board_mem_id = "test_id_1";
		String board_p_seq = "9";
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_tboard_seq(board_tboard_seq);
		boardVO.setBoard_title(board_title);
		boardVO.setBoard_content(board_content);
		boardVO.setBoard_mem_id(board_mem_id);
		boardVO.setBoard_p_seq(board_p_seq);
		
		/***When***/
		BoardVO resultBoardVO = boardService.getBoardInfo(boardVO.getBoard_p_seq());
		boardVO.setBoard_group_seq(resultBoardVO.getBoard_group_seq());
		
		int result = boardService.insertBoardP(boardVO);
		
		/***Then***/
		assertEquals(1, result);
		
	}
	
	/**
	 * Method : getBoardInfoTest
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 :
	 */
	@Test
	public void getBoardInfoTest() {
		/***Given***/
		BoardServiceInf boardService = BoardService.getInstance();
		String board_seq = "1";
		
		/***When***/
		BoardVO returnBoardVO = boardService.getBoardInfo(board_seq);
		
		/***Then***/
		assertEquals(board_seq, returnBoardVO.getBoard_seq());
		assertEquals(null, returnBoardVO.getBoard_p_seq());
		assertEquals(board_seq, returnBoardVO.getBoard_group_seq());
	}
	

}

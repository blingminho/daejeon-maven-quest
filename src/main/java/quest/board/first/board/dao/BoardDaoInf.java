package quest.board.first.board.dao;

import java.util.List;

import quest.board.first.vo.BoardVO;

/**
 * BoardDaoInf.java
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
public interface BoardDaoInf {

	/**
	 * Method : getBoardPagingList
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param board_tboard_seq 게시판의 번호
	 * @param pageNum 페이지 번호
	 * @return
	 * Method 설명 : 게시판의 번호 및 페이지번호를 이용하여 해당 게시글 목록을 가져옴
	 */
	List<BoardVO> getBoardPagingList(String board_tboard_seq, String pageNum);
	
	/**
	 * Method : getBoardListCount
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 해당 게시판의 게시글수를 가져옴
	 */
	int getBoardListCount(String board_tboard_seq);
	
	/**
	 * Method : insertBoard
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param boardVO
	 * @return
	 * Method 설명 : 일반적인 글쓰기(부모글 없음)
	 */
	int insertBoard(BoardVO boardVO);
	
	/**
	 * Method : insertBoardP
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param boardVO
	 * @return
	 * Method 설명 : 부모글에 계층형글쓰기
	 */
	int insertBoardP(BoardVO boardVO);
	
	/**
	 * Method : getBoardInfo
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param board_seq
	 * @return
	 * Method 설명 : 게시글의 모든정보조회(게시글번호이용) - 계층형글쓰기에도 사용함
	 */
	BoardVO getBoardInfo(String board_seq);
	
	/**
	 * Method : updateBoard_del_yn
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param board_seq
	 * @return
	 * Method 설명 : 해당 게시글의 사용여부를 N으로 변경
	 */
	int updateBoard_del_yn(String board_seq);
	
	/**
	 * Method : updateBoard
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param boardVO
	 * @return
	 * Method 설명 : 해당 게시글 수정
	 */
	int updateBoard(BoardVO boardVO);
}

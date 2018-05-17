package quest.board.first.fileadd.service;

import java.util.List;

import quest.board.first.vo.FileAddVO;

/**
 * FileAddServiceInf.java
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
public interface FileAddServiceInf {
	/**
	 * Method : insertFileAdd
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param fileAddVO
	 * @return
	 * Method 설명 : 파일추가
	 */
	int insertFileAdd(FileAddVO fileAddVO);
	
	/**
	 * Method : getFileAdd
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param file_board_seq
	 * @return
	 * Method 설명 : 해당 게시글의 파일 목록을 반환
	 */
	List<FileAddVO> getFileAdd(String file_board_seq);
	
	/**
	 * Method : updateFileAdd
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param fileAddVOList
	 * @return
	 * Method 설명 : 해당 게시글의 모든 파일 목록을 이용하여 업데이트
	 */
	int updateFileAdd(List<FileAddVO> fileAddVOList);
	
}

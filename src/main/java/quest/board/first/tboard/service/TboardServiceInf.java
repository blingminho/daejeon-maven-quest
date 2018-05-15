package quest.board.first.tboard.service;

import java.util.List;

import quest.board.first.vo.TboardVO;

/**
 * TboardServiceInf.java
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
 * 2018. 5. 14. "K.S.J" 최초 생성
 *
 * </pre>
 */
public interface TboardServiceInf {
	
	/**
	 * Method : getTboardList
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 목록 가져옴
	 */
	public List<TboardVO> getTboardList();
	
	/**
	 * Method : getTboard
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param tboardVO 최소한 seq를 가진 인스턴스
	 * @return 해당 게시판의 모든 정보 가져옴
	 * Method 설명 : 해당 seq를 가진 게시판 가져옴
	 */
	public TboardVO getTboard(TboardVO tboardVO);
	
	/**
	 * Method : updateTboardYN
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param tboardVO 해당 게시판 vo
	 * @return update된 튜플 수
	 * Method 설명 : 활성화여부 update
	 */
	public int updateTboardYN(TboardVO tboardVO);
	
	/**
	 * Method : insertTboard
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param tboardVO 새로운 게시판
	 * @return insert된 튜플 수
	 * Method 설명 : 새로운 게시판을 DB에 insert한다. insert된 튜플수 반환
	 */
	public int insertTboard(TboardVO tboardVO);
	
}
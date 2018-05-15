package quest.board.first.tboard.service;

import java.util.List;

import quest.board.first.tboard.dao.TboardDao;
import quest.board.first.tboard.dao.TboardDaoInf;
import quest.board.first.vo.TboardVO;

/**
 * TboardService.java
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
public class TboardService implements TboardServiceInf {
	
	private static TboardServiceInf tboardService = null;
	private TboardDaoInf tboardDao = null;
	
	private TboardService(){
		tboardDao = TboardDao.getInstance();
	}
	
	/**
	 * Method : getInstance
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return TboardService 인스턴스
	 * Method 설명 : TboardService 인스턴스 반환
	 */
	public static TboardServiceInf getInstance() {
		if(tboardService == null)
			tboardService = new TboardService();
		return tboardService;
	}

	/**
	 * Method : getTboardList
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 모든 게시판의 목록을 가져옴
	 */
	@Override
	public List<TboardVO> getTboardList() {
		return tboardDao.getTboardList();
	}

	@Override
	public TboardVO getTboard(TboardVO tboardVO) {
		return tboardDao.getTboard(tboardVO);
	}

	/**
	 * Method : updateTboardYN
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param tboardVO 해당 게시판 vo
	 * @return update된 튜플 수
	 * Method 설명 : 활성화여부 update
	 */
	@Override
	public int updateTboardYN(TboardVO tboardVO) {
		return tboardDao.updateTboardYN(tboardVO);
	}

	/**
	 * Method : insertTboard
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param tboardVO 새로운 게시판
	 * @return insert된 튜플 수
	 * Method 설명 : 새로운 게시판을 DB에 insert한다. insert된 튜플수 반환
	 */
	@Override
	public int insertTboard(TboardVO tboardVO) {
		return tboardDao.insertTboard(tboardVO);
	}

}

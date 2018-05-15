package quest.board.first.test.tboard;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import quest.board.first.tboard.dao.TboardDao;
import quest.board.first.tboard.dao.TboardDaoInf;
import quest.board.first.vo.TboardVO;

/**
 * TboardDaoTest.java
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
public class TboardDaoTest {

	/**
	 * Method : getTboardListTest
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : getTboardList 테스트
	 */
	@Test
	public void getTboardListTest() {
		/***Given***/
		TboardDaoInf tboardDao = TboardDao.getInstance();
		
		/***When***/
		List<TboardVO> list = tboardDao.getTboardList();

		/***Then***/
		assertNotNull(list);
		assertEquals(9, list.size());
	}

	/**
	 * Method : getTboardTest
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : getTboard 테스트
	 */
	@Test
	public void getTboardTest(){
		/***Given***/
		TboardDaoInf tboardDao = TboardDao.getInstance();
		TboardVO tboardVO = new TboardVO();
		tboardVO.setTboard_seq("1");
		
		/***When***/
		TboardVO returnTboardVO = tboardDao.getTboard(tboardVO);

		/***Then***/
		assertNotNull(returnTboardVO);
		assertEquals("1", returnTboardVO.getTboard_seq());
		assertEquals("test_tboard_title_1", returnTboardVO.getTboard_title());
		assertEquals("Y", returnTboardVO.getTboard_del_yn());
		assertEquals("test_id_1", returnTboardVO.getTboard_mem_id());
	}
	
	/**
	 * Method : updateTboardYNTest
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : updateTboardYNTest 테스트
	 */
	@Test
	public void updateTboardYNTest(){
		/***Given***/
		TboardDaoInf tboardDao = TboardDao.getInstance();
		TboardVO tboardVO = new TboardVO("1", "test_tboard_title_1", new Date(), "N", "test_id_1");
		
		/***When***/
		int result = tboardDao.updateTboardYN(tboardVO);
		
		/***Then***/
		assertEquals(1, result);
	}
	
	/**
	 * Method : insertTboardTest
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : insertTboardTest 테스트
	 */
	@Test
	public void insertTboardTest(){
		/***Given***/
		TboardDaoInf tboardDao = TboardDao.getInstance();
		TboardVO tboardVO = new TboardVO();
		tboardVO.setTboard_title("test_tboard_title_");
		tboardVO.setTboard_del_yn("Y");
		tboardVO.setTboard_mem_id("test_id_1");
		
		/***When***/
		int result = tboardDao.insertTboard(tboardVO);
		
		/***Then***/
		assertEquals(1, result);
	}
	
	
	
	
	
}

package quest.board.first.test.tboard;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import quest.board.first.tboard.service.TboardService;
import quest.board.first.tboard.service.TboardServiceInf;
import quest.board.first.vo.TboardVO;

/**
 * TboardServiceTest.java
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
public class TboardServiceTest {

	/**
	 * Method : getTboardListTest
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : getTboardList 테스트
	 */
	@Test
	public void getTboardListTest() {
		/***Given***/
		TboardServiceInf tboardService = TboardService.getInstance();
		
		/***When***/
		List<TboardVO> list = tboardService.getTboardList();

		/***Then***/
		assertNotNull(list);
		assertEquals(10, list.size());
	}

	
	
	
	
	
}

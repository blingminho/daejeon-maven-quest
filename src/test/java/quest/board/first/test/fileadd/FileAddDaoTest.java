package quest.board.first.test.fileadd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import quest.board.first.fileadd.dao.FileAddDao;
import quest.board.first.fileadd.dao.FileAddDaoInf;
import quest.board.first.vo.FileAddVO;

/**
 * FileAddDaoTest.java
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
public class FileAddDaoTest {
	
	/**
	 * Method : insertFileAddTest
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 :
	 */
	@Test
	public void insertFileAddTest() {
		/***Given***/
		FileAddDaoInf dao = FileAddDao.getInstance();
		String file_board_seq = "2";
		String file_path = "path";
		FileAddVO fileAddVO = new FileAddVO();
		fileAddVO.setFile_board_seq(file_board_seq);
		fileAddVO.setFile_path(file_path);
		
		/***When***/
		int result = dao.insertFileAdd(fileAddVO);

		/***Then***/
		assertEquals(1, result);
	}

	/**
	 * Method : getFileAddTest
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 :
	 */
	@Test
	public void getFileAddTest() {
		/***Given***/
		FileAddDaoInf dao = FileAddDao.getInstance();
		String file_board_seq = "1";
		
		/***When***/
		List<FileAddVO> list = dao.getFileAdd(file_board_seq);

		/***Then***/
		assertEquals(7, list.size());
	}
	
	/**
	 * Method : updateFileAddTest
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 :
	 */
	@Test
	public void updateFileAddTest() {
		/***Given***/
		FileAddDaoInf dao = FileAddDao.getInstance();
		String file_seq = "1";
		String file_board_seq = "1";
		String file_path = "test";
		
		FileAddVO fileAddVO = new FileAddVO(file_seq, file_board_seq, file_path);
		
		/***When***/
		int result = dao.updateFileAdd(fileAddVO);

		/***Then***/
		assertEquals(1, result);
	}
	
	
	
}

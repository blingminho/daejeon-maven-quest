package quest.board.first.test.fileadd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import quest.board.first.fileadd.service.FileAddService;
import quest.board.first.fileadd.service.FileAddServiceInf;
import quest.board.first.vo.FileAddVO;

public class FileAddServiceTest {

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
		FileAddServiceInf service = FileAddService.getInstance();
		String file_board_seq = "2";
		String file_path = "path";
		FileAddVO fileAddVO = new FileAddVO();
		fileAddVO.setFile_board_seq(file_board_seq);
		fileAddVO.setFile_path(file_path);
		
		/***When***/
		int result = service.insertFileAdd(fileAddVO);

		/***Then***/
		assertEquals(1, result);
	}

	/**
	 * Method : getFileAddTest
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 : 파일삭제 테스트
	 */
	@Test
	public void getFileAddTest() {
		/***Given***/
		FileAddServiceInf dao = FileAddService.getInstance();
		String file_board_seq = "1";
		
		/***When***/
		List<FileAddVO> list = dao.getFileAdd(file_board_seq);

		/***Then***/
		assertEquals(7, list.size());
	}
	
	
	/**
	 * Method : deleteFileAddTest
	 * 최초작성일 : 2018. 5. 19.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * Method 설명 :
	 */
	@Test
	public void deleteFileAddTest() {
		/***Given***/
		FileAddServiceInf service = FileAddService.getInstance();
		String file_board_seq = "1";
		
		/***When***/
		int expected = service.getFileAdd(file_board_seq).size();
		int result = service.deleteFileAdd(file_board_seq);

		/***Then***/
		assertEquals(expected, result);
	}
	
}

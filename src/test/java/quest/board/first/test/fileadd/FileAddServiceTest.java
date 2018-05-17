package quest.board.first.test.fileadd;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
		FileAddServiceInf dao = FileAddService.getInstance();
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
		FileAddServiceInf dao = FileAddService.getInstance();
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
		FileAddServiceInf service = FileAddService.getInstance();
		
		List<FileAddVO> fileAddVOList = new ArrayList<FileAddVO>();
		fileAddVOList.add(new FileAddVO("1", "1", "path1"));
		fileAddVOList.add(new FileAddVO("2", "1", "path2"));
		fileAddVOList.add(new FileAddVO("3", "1", "path3"));
		fileAddVOList.add(new FileAddVO("4", "1", "path4"));
		fileAddVOList.add(new FileAddVO("5", "1", "path5"));
		
		/***When***/
		int result = service.updateFileAdd(fileAddVOList);

		/***Then***/
		assertEquals(5, result);
	}
	

}

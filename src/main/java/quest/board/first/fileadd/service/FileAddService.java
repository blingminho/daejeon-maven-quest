package quest.board.first.fileadd.service;

import java.util.List;

import quest.board.first.fileadd.dao.FileAddDao;
import quest.board.first.fileadd.dao.FileAddDaoInf;
import quest.board.first.vo.FileAddVO;

public class FileAddService implements FileAddServiceInf {
	private static FileAddServiceInf fileAddService = null;
	private FileAddDaoInf fileAddDao = null;
	
	private FileAddService(){
		fileAddDao = FileAddDao.getInstance();
	}
	/**
	 * Method : getInstance
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return FileAddService 인스턴스
	 * Method 설명 : FileAddService 인스턴스 반환
	 */
	public static FileAddServiceInf getInstance() {
		if(fileAddService == null)
			fileAddService = new FileAddService();
		return fileAddService;
	}
	
	/**
	 * Method : insertFileAdd
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param fileAddVO
	 * @return
	 * Method 설명 : 파일추가
	 */
	@Override
	public int insertFileAdd(FileAddVO fileAddVO) {
		return fileAddDao.insertFileAdd(fileAddVO);
	}

	/**
	 * Method : getFileAdd
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param file_board_seq
	 * @return
	 * Method 설명 : 해당 게시글의 파일 목록을 반환
	 */
	@Override
	public List<FileAddVO> getFileAdd(String file_board_seq) {
		return fileAddDao.getFileAdd(file_board_seq);
	}

	/**
	 * Method : deleteFileAdd
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param file_board_seq
	 * @return
	 * Method 설명 : 해당 게시글의 파일을 제거
	 */
	@Override
	public int deleteFileAdd(String file_board_seq) {
		int result = 0;
		result = fileAddDao.deleteFileAdd(file_board_seq);
		
		return result;
	}

}

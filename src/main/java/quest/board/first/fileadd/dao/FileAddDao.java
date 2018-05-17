package quest.board.first.fileadd.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import quest.board.first.util.MybatisSqlSessionFactory;
import quest.board.first.vo.FileAddVO;

/**
 * FileAddDao.java
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
public class FileAddDao implements FileAddDaoInf {
	private static FileAddDaoInf dao = null;
	private SqlSessionFactory sqlSessionFactory = null;
	
	private FileAddDao(){
		sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
	}
	
	/**
	 * Method : getInstance
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return FileAddDao 인스턴스
	 * Method 설명 : FileAddDao 인스턴스 반환
	 */
	public static FileAddDaoInf getInstance() {
		if (dao == null) {
			dao = new FileAddDao();
		}
		return dao;
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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.insert("fileAdd.insertFileAdd", fileAddVO);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<FileAddVO> result = sqlSession.selectList("fileAdd.getFileAdd", file_board_seq);
		sqlSession.close();
		
		return result;
	}

	/**
	 * Method : updateFileAdd
	 * 최초작성일 : 2018. 5. 16.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param fileAddVOList
	 * @return
	 * Method 설명 : 해당 게시글의 모든 파일 목록을 이용하여 업데이트
	 */
	@Override
	public int updateFileAdd(FileAddVO fileAddVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.update("fileAdd.updateFileAdd", fileAddVO);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}

}

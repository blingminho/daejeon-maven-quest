package quest.board.first.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * MybatisSqlSessionFactory.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 12.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 12. "K.S.J" 최초 생성
 *
 * </pre>
 */
public class MybatisSqlSessionFactory {
	
	/**
	 * Method : getSqlSessionFactory
	 * 최초작성일 : 2018. 5. 12.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return SqlSessionFactory 인스턴스 반환
	 * Method 설명 : SqlSessionFactory 인스턴스 반환(static 메서드)
	 */
	public static SqlSessionFactory getSqlSessionFactory(){
		SqlSessionFactory sqlSessionFactory = null;
		
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
}

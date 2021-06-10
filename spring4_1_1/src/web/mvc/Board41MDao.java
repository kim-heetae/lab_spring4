package web.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class Board41MDao {
	Logger logger = Logger.getLogger(Board41MDao.class);
	SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public List<Map<String, Object>> getBoardList(Map<String, Object> pmap) {
		logger.info("Board41MDao - getBoardList 호출성공 ");
		List<Map<String, Object>> boardList = null;
		boardList = sqlSessionTemplate.selectList("getBoardList",pmap);
		logger.info("Board41MDao - getBoardList 호출성공 " + boardList);
		return boardList;
	}
	public int boardInsert(Map<String, Object> pmap) {
		logger.info("boardMDao.boardInsert 호출성공");
		int result = 0;
		result = sqlSessionTemplate.insert("boardInsertMaster",pmap);
		
		return result;
	}
	public int boardUpdate(Map<String, Object> pmap) {
		logger.info("boardMDao.boardUpdate 호출성공");
		int result = 0;
//		result = sqlSessionTemplate.update("boardUpdateMaster",pmap);
		
		return result;
	}
}

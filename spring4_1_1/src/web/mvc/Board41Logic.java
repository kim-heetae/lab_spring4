package web.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class Board41Logic {
	Logger logger = Logger.getLogger(Board41Logic.class);
	private Board41MDao boardMDao = null;
	public void setBoardMDao(Board41MDao boardMDao) {
		this.boardMDao = boardMDao;
	}
	private Board41SDao boardSDao = null;
	public void setBoardSDao(Board41SDao boardSDao) {
		this.boardSDao = boardSDao;
	}

	public List<Map<String, Object>> getBoardList(Map<String, Object> pmap) {
		logger.info("getBoardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		boardList = boardMDao.getBoardList(pmap);
		return boardList;
	}

	public int boardInsert(Map<String, Object> pmap) {
		int result = 0;
		logger.info("boardInsert 호출성공");
		int resultMaster = boardSDao.boardInsert(pmap);
		int resultSub = boardMDao.boardInsert(pmap);
		if(resultMaster == 1 && resultSub == 1) {
			result = 1;
		}
		else {
			result = 0;
		}
		return result;
	}
}

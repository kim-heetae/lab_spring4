package web.mvc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

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
		String gubun = null;
		if(pmap.get("gubun") != null) {
			gubun = pmap.get("gubun").toString();			
		}
		if(gubun != null && "detail".equals(gubun)) {
			int bm_no = 0;
			bm_no = Integer.parseInt(pmap.get("bm_no").toString());
			boardMDao.hitCount(bm_no);
		}
		boardList = boardMDao.getBoardList(pmap);
		return boardList;
	}
	//=>board/boardInsert.sp4?bm_no=6&bm_title=게시글제목&bs_file=a.txt&bm_writer=%EC%9D%B4%EC%88%9C%EC%8B%A0&bm_email=test@hot.com&bm_content=%EC%97%B0%EC%8A%B5&bm_pw=123
	public int boardInsert(Map<String, Object> pmap) {
		int result = 0;
		int bm_no = 0;
		int bm_group = 0;
//		int pbm_no = Integer.parseInt(pmap.get("bm_no").toString());
		bm_no = boardMDao.getBmNo(bm_no);
		pmap.put("bm_no", bm_no);
		if(pmap.get("bm_group") != null) {
			bm_group = Integer.parseInt(pmap.get("bm_group").toString());
		}
		if(bm_group > 0) {
			boardMDao.bmStepUpdate(pmap);
			pmap.put("bm_pos", Integer.parseInt(pmap.get("bm_pos").toString()) + 1);
			pmap.put("bm_step", Integer.parseInt(pmap.get("bm_step").toString()) + 1);
		}
		else {//새글일때
			bm_group = boardMDao.getBmGroup();
			pmap.put("bm_group", bm_group);
			pmap.put("bm_pos", 0);
			pmap.put("bm_step", 0);
		}
		int resultMaster = boardMDao.boardInsert(pmap);
		if((pmap.get("bs_file") != null) && (pmap.get("bs_file").toString().length() > 0)) {
//			pmap.put("bm_no", bm_no);
			pmap.put("bs_seq", 1);
			boardSDao.boardInsert(pmap);
		}
		logger.info("boardInsert 호출성공");
			result = 1;
		return result;
	}

	public int boardUpdate(Map<String, Object> pmap) {
		int result = 0;
		result = boardMDao.boardUpdate(pmap);
		if(!pmap.get("bs_file").toString().equals("해당없음")) {
			
		}
		return result;
	}

	public int boardDelete(Map<String, Object> pmap) {
		int result = 0;
		result = boardMDao.boardDelete(pmap);
		boardFileDelete(pmap);
		return result;
	}
	public int boardFileDelete(Map<String, Object> pmap) {
		int result = 0;
			try {
				String filePath = "C://portfolio_hit//lab_spring4//spring4_1_1//WebContent//pds//";
				String filename = pmap.get("bs_file").toString();
				String fullName = filePath + filename;
				File file = new File(fullName);
				if(file != null) {
					if(file.exists()) {
						boolean isOk = file.delete();
					}
				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		return result;
	}
	public boolean boardFileManagerDelete(Map<String, Object> pmap) {
		int result = 0;
		boolean isOk = false;
		logger.info("filedelete ====================== " + pmap);
		String bs_files = (String)pmap.get("bs_file").toString();
		StringTokenizer st = new StringTokenizer(bs_files, "*");
		while(st.hasMoreTokens()) {
			try {
				String filePath = "C://portfolio_hit//lab_spring4//spring4_1_1//WebContent//pds//";
				String filename = st.nextToken();
				String fullName = filePath + filename;
				File file = new File(fullName);
				if(file != null) {
					if(file.exists()) {
						if(file.delete()) {
							result++;
						}
	//					pmap.put("bs_seq", 1);
	//					boardSDao.boardSDelete(pmap);
					}
				}
				isOk = true;
			}
			catch (Exception e) {
				isOk = false;
			}
		}
		isOk = true;
		return isOk;
	}
	public int boardManagerDelete(Map<String, Object> pmap) {
		int result = 0;
		boolean fileresult = false;
//		List<Map<String, Object>> subList = new ArrayList<>();
//		subList = boardSDao.boardFileNoSelect(pmap);
		result = boardMDao.boardManagerDelete(pmap);
		logger.info("filedelete ====================== " + pmap);
		fileresult = boardFileManagerDelete(pmap);
//		subresult = boardSDao.boardManagerDelete(subList);
//		subresult = boardSDao.boardManagerDelete(pmap);
		if(result == 1 && fileresult) {
			result = 1; 
		}
		else {
			result = 0;
		}
		logger.info("boardManagerDelete Logic =============== " + result);
		return result;
	}

	public int getPwManager(Map<String, Object> pmap) {
		int result = 0;
		
		return result;
	}
	
//	public int boardInsert(Map<String, Object> pmap) {
//		int result = 0;
//		int fileOk = 1;
//		logger.info("boardUpdate 호출성공");
//		int resultMaster = boardMDao.boardInsert(pmap);
//		if(pmap.containsKey("bs_file")) {
//			fileOk = boardSDao.boardInsert(pmap);
//		}
//		if(resultMaster == 1 && fileOk == 1) {
//			result = 1;
//		}
//		else {
//			result = 0;
//		}
//		return result;
//	}
	
//	public int boardUpdate(Map<String, Object> pmap) {
//		int result = 0;
//		int fileOk = 1;
//		logger.info("boardUpdate 호출성공");
//		int resultMaster = boardMDao.boardUpdate(pmap);
//		if(pmap.containsKey("bs_file")) {
//			fileOk = boardSDao.boardUpdate(pmap);
//		}
//		if(resultMaster == 1 && fileOk == 1) {
//			result = 1;
//		}
//		else {
//			result = 0;
//		}
//		return result;
//	}
}

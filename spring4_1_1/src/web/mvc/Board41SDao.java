package web.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class Board41SDao {
	Logger logger = Logger.getLogger(Board41SDao.class);
	SqlSessionTemplate sqlSessionTemplate = null;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public int boardInsert(Map<String, Object> pmap) {
		logger.info("boardMDao.boardInsert 호출성공");
		int result = 0;
		pmap.put("bs_seq", 1);
		pmap.put("bs_size", 50);
		result = sqlSessionTemplate.insert("boardInsertSub",pmap);
		
		return result;
	}

	public int boardUpdate(Map<String, Object> pmap) {
		logger.info("boardMDao.boardUpdate 호출성공");
		int result = 0;
		pmap.put("bs_seq", 1);
		pmap.put("bs_size", 50);
//		result = sqlSessionTemplate.update("boardUpdateSub",pmap);
		
		return result;
	}

	public int boardDelete(Map<String, Object> pmap) {
		int result = 0;
		result = sqlSessionTemplate.delete("boardSDelete", pmap);
		return result;
	}

//	public int boardManagerDelete(List<Map<String, Object>> subList) {
//		int result = 0;
//		Map<String,Object> subpmap2 = new HashMap<>();
//		subpmap2 = subList.get(0);
//		StringBuilder bm_nos = new StringBuilder();
//		for(int i = 0; i < subList.size(); i++) {
//			if(i == subList.size() - 1) {
//				bm_nos.append(subList.get(i).values().toString());				
//			}
//			else {
//				bm_nos.append(subList.get(i).values().toString());
//				bm_nos.append("cutter");
//			}
//		}
//		logger.info("bm_nos ===============" + bm_nos);
//		String bm_noss = bm_nos.toString();
//		logger.info("bm_noss ===============" + bm_noss);
//		bm_noss.replace("[", " ");
//		bm_noss.replace("]", " ");
//		logger.info("bm_noss ===============" + bm_noss);
//		StringTokenizer st = new StringTokenizer(bm_noss,"cutter");
//		List<Integer> li = new ArrayList<>();
//		Map<String, List<Integer>> deleteMap = new HashMap();
//		while(st.hasMoreTokens()) {
//			li.add(Integer.parseInt(st.nextToken()));
//		}
//		deleteMap.put("li", li);
//		result = sqlSessionTemplate.delete("boardSManagerDelete", deleteMap);
//		logger.info(result);
//		if(result == li.size()) {
//			result = 1;
//		}
//		else {
//			result = 0;
//		}
//		return result;
//	}
	public int boardManagerDelete(Map<String, Object> pmap) {
		int result = 0;
		List<String> li = new ArrayList<>();
		Map<String, List<String>> fileNoMap = new HashMap<>();
		String bs_files = (String)pmap.get("bs_file");
		logger.info("bs_files ==================== > " + bs_files);
		StringTokenizer st = new StringTokenizer(bs_files, "cutter");
		while(st.hasMoreTokens()) {
			li.add(st.nextToken());
		}
		fileNoMap.put("li", li);
		result = sqlSessionTemplate.delete("boardSManagerDelete",fileNoMap);
		if(result == li.size()) {
			result = 1;
		}
		else {
			result = 0;
		}
		return result;
	}

	public List<Map<String, Object>> boardFileNoSelect(Map<String, Object> pmap) {
		
		List<Map<String, Object>> subList = new ArrayList<>();
		String bm_nos = (String)pmap.get("bm_no");
		StringTokenizer st = new StringTokenizer(bm_nos,"cutter");
		List<Integer> li = new ArrayList<>();
		Map<String, List<Integer>> fileNoMap = new HashMap<>();
		while(st.hasMoreTokens()) {
			li.add(Integer.parseInt(st.nextToken()));
		}
		fileNoMap.put("li", li);
		subList = sqlSessionTemplate.selectList("boardFileNoSelect", fileNoMap);
		return subList;
	}
}

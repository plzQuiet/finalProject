package com.fin.project.intro.service;

import java.util.List;
import java.util.Map;

public interface IntroService {

	/** 카테고리 리스트 얻어오는 Service
	 * @return category
	 */
	List<Map<String, Object>> selectCategoryList();
	
	

}

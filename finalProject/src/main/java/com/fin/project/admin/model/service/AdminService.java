package com.fin.project.admin.model.service;

import java.util.Map;

public interface AdminService {

	Map<String, Object> selectMemberList(int cp);

	int member(String updateList);

	int board(String updateList);

	int comment(String updateList);

}

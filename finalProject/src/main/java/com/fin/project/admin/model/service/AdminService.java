package com.fin.project.admin.model.service;

import java.util.Map;

public interface AdminService {

	Map<String, Object> selectMemberList(int cp);

	int member(String updateList);

	Map<String, Object> selectboardList(int cp);

	int board(String updateList);

	Map<String, Object> selectCommentList(int cp);

	int comment(String updateList);

}

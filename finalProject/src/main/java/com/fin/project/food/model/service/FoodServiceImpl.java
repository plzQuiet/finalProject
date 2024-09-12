package com.fin.project.food.model.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.fin.project.common.utility.Util;
import com.fin.project.food.model.dao.FoodDAO;
import com.fin.project.food.model.dto.Food;

@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodDAO dao;

	// 백반 메뉴 가져오기
	@Override
	public List<Food> selectFoodList() {
		return dao.selectFoodList();
	}

	// 커피 메뉴 가져오기
	@Override
	public List<Food> selectCoffeeList() {

		List<Food> foodList = new ArrayList<Food>();

		List<Food> foodList2 = dao.selectFoodList();


		for(Food food : foodList2) {
			if(food.getTypeNo() == 2) {
				foodList.add(food);
			}
		}

		return foodList;
	}

	// 분식 메뉴 추가하기
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertFoodMenu(Food newFood, MultipartFile menuImage, String webPath, String filePath) throws IllegalStateException, IOException {

		String originName = webPath + "/foodIsNotReady.png";

		String rename = null;

		if(menuImage.getSize() > 0 ) {	//파일 안 가져옴

			rename = Util.fileRename(menuImage.getOriginalFilename());

			newFood.setFoodImg(webPath+rename);

		}else {
			newFood.setFoodImg(originName);
		}

		newFood.setFoodName(Util.XSSHandling(newFood.getFoodName()));

		int result = dao.insertFoodMenu(newFood);

		if(result > 0) {
			// 새 이미지가 업로드된 경우
			if(rename != null) {
				menuImage.transferTo(new File(filePath + rename));
			}


		}
		
		return result;

	}	

}
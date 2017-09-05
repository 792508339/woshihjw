package com.yellow.service;

import java.sql.SQLException;
import java.util.List;

import com.yellow.dao.CategoryDao;
import com.yellow.domain.Category;

public class CategoryService {

	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		CategoryDao categoryDao = new CategoryDao();
		List<Category> list =null;
	    try {
			list = categoryDao.getAllCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}

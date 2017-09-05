package com.yellow.service;

import java.sql.SQLException;
import java.util.List;

import vo.Condition;

import com.yellow.dao.SearchDao;
import com.yellow.domain.Product;

public class SearchService {

	public List<Product> findProductiesByCondition(Condition condition) throws SQLException {
		// TODO Auto-generated method stub
      SearchDao searchDao = new SearchDao();
      List<Product> product = searchDao.findProductiesByCondition(condition);
      return product;
	}
}

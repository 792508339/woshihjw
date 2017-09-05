package com.yellow.service;

import java.sql.SQLException;

import com.yellow.dao.ShowDao;
import com.yellow.domain.Product;

public class ShowService {

	public Product showProduct(String pid) {
		// TODO Auto-generated method stub
		ShowDao showDao = new ShowDao();
		Product pro = null;
		try {
			pro = showDao.showProduction(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
	}

}

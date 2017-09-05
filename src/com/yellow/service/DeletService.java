package com.yellow.service;

import java.sql.SQLException;

import com.yellow.dao.DeletDao;

public class DeletService {

	public void deletProduct(String pid) {
		// TODO Auto-generated method stub
		DeletDao deletDao = new DeletDao();
		try {
			deletDao.deletProduction(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

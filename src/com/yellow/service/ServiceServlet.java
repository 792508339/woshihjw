package com.yellow.service;


import java.sql.SQLException;
import java.util.List;

import com.yellow.dao.DaoServlet;
import com.yellow.domain.Product;

public class ServiceServlet {

	public List<Product> getAllProduction() throws SQLException {
		DaoServlet daoServlet = new DaoServlet();
		List<Product> list = null;
		list = daoServlet.getAllProduction();
		return list;
	}

	public void setProduction(Product product) {
		// TODO Auto-generated method stub
		DaoServlet daoServlet = new DaoServlet();
		try {
			daoServlet.setProduction(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

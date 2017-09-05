package com.yellow.service;

import java.sql.SQLException;

import com.yellow.dao.EditDao;
import com.yellow.domain.Product;

public class EditService {

	public void editProcut(Product pro) {
		// TODO Auto-generated method stub
        EditDao editDao = new EditDao();
        try {
			editDao.editProduct(pro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

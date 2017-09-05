package com.yellow.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.yellow.domain.Product;
import com.yellow.utils.C3POUtils;

public class ShowDao {

	public Product showProduction(String pid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qry = new QueryRunner(C3POUtils.getDataSource());
		String sql = "select * from product where pid=?";
		Product pro = qry.query(sql, new BeanHandler<Product>(Product.class),pid);
		return pro;
	}

}

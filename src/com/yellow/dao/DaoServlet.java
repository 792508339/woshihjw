package com.yellow.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yellow.domain.Product;
import com.yellow.utils.C3POUtils;

public class DaoServlet {

	public List<Product> getAllProduction() throws SQLException {
		QueryRunner qry = new QueryRunner(C3POUtils.getDataSource());
		String sql = "select * from product";
		List<Product> list = qry.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
	}

	public void setProduction(Product product) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qry = new QueryRunner(C3POUtils.getDataSource());
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
		qry.update(sql,product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCid());
	}

}

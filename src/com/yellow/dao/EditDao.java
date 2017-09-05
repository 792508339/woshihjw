package com.yellow.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.yellow.domain.Product;
import com.yellow.utils.C3POUtils;

public class EditDao {

	public void editProduct(Product product) throws SQLException {
		QueryRunner qry = new QueryRunner(C3POUtils.getDataSource());
		String sql = "update product set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?";
		qry.update(sql,product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCid(),product.getPid());
	}
}

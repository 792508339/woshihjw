package com.yellow.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yellow.domain.Category;
import com.yellow.utils.C3POUtils;

public class CategoryDao {

	public List<Category> getAllCategory() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qry = new QueryRunner(C3POUtils.getDataSource());
		String sql = "select * from category";
		List<Category> list = qry.query(sql, new BeanListHandler<Category>(Category.class));
		return list;
	}
}

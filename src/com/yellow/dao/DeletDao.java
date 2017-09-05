package com.yellow.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.yellow.utils.C3POUtils;

public class DeletDao {

	public void deletProduction(String pid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qry = new QueryRunner(C3POUtils.getDataSource());
		String sql = "delete from product where pid=?";
		qry.update(sql,pid);
	}

}

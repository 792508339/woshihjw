 package com.yellow.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import vo.Condition;

import com.yellow.domain.Product;
import com.yellow.utils.C3POUtils;

public class SearchDao {

	public List<Product> findProductiesByCondition(Condition condition) throws SQLException {
		// TODO Auto-generated method stub
     QueryRunner qry = new QueryRunner(C3POUtils.getDataSource());
     String sql = "select * from product where 1=1";
     List<String> searchsql = new ArrayList<String>();
     if(condition.getPname()!=null&&!condition.getPname().trim().equals("")){
    	 sql+=" and pname like ? ";
    	 searchsql.add("%"+condition.getPname()+"%");
     }
     if(condition.getIsHot()!=null&&!condition.getIsHot().trim().equals("")){
    	 sql+=" and is_hot=? ";
    	 searchsql.add(condition.getIsHot());
     }
     if(condition.getCid()!=null&&!condition.getCid().trim().equals("")){
    	 sql+=" and cid=? ";
    	 searchsql.add(condition.getCid());
     }
     List<Product> producties = qry.query(sql, new BeanListHandler<Product>(Product.class),searchsql.toArray());
     return producties;
	}

}

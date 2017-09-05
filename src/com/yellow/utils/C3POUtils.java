package com.yellow.utils;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3POUtils {
        private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

        public static DataSource getDataSource(){
        	return dataSource;
        }

        public static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

        public static Connection getCurrentConnection(){
        	Connection conn = tl.get();
        	if(conn==null){
        		conn = getConnection();
        		tl.set(conn);
        	}
        	return conn;
        }

        public static void startTransAction() throws SQLException{
        	Connection conn  = getCurrentConnection();
        	conn.setAutoCommit(false);
        }

        public static void commitTransAction() throws SQLException{
        	Connection conn = getCurrentConnection();
        	conn.commit();
        }

        public static void stopTransAction() throws SQLException{
        	Connection conn = getCurrentConnection();
        	conn.rollback();
        }

        public static Connection getConnection(){
           try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
        }
}



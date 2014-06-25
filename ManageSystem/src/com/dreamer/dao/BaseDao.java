package com.dreamer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BaseDao {
	protected String sql = "";
	protected Context initContext,envContext;
	protected DataSource dataSource;
	protected Connection connection;
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;
	
	protected void initMySQL(){
		try{
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/ManageSystem");
			connection = dataSource.getConnection();
			//statement = connection.prepareStatement();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("数据库连接池初始化异常！"+e);
		}
	}
	
	protected void close() {
		try {
			if(resultSet!=null){
				resultSet.close();
			}
			if(preparedStatement!=null){
				preparedStatement.close();
			}
			if(connection!=null){
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("关闭数据库资源异常！"+e);
		}
	}
}

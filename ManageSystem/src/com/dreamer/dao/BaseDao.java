package com.dreamer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dreamer.util.DbUtil;
/**
 * 数据库操作的基类，封装数据库的基本操作
 * @author Dreamer
 *
 */
public class BaseDao {
	protected String sql = "";
	protected Connection connection;
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;
	/**
	 * 初始化数据库连接
	 */
	protected void initMySQL(){
		try{
			connection = DbUtil.getConnection();
		}catch (Exception e) {
			System.out.println("数据库连接池初始化异常！"+e);
		}
	}
	/**
	 * 关闭数据库连接
	 */
	protected void closeConnection() {
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
			System.out.println("关闭数据库连接资源异常！"+e);
		}
	}
}

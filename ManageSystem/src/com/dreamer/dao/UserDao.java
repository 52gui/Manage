package com.dreamer.dao;

import java.sql.ResultSet;

import com.dreamer.bean.UserBean;
/**
 * 该类为用户的操作类
 * @author Dreamer
 *
 */
public class UserDao extends BaseDao{
	private ResultSet resultSet;
	private UserBean userBean;

	public UserDao(){
		userBean = new UserBean();
		initMySQL();
	}
	
	public UserDao(UserBean userBean){
		this.userBean = userBean;
		initMySQL();
	}
	
	/**
	 * 设置当前的UserBaen
	 * @param userBean
	 */
	
	public void setCurrentUser(UserBean userBean){
		this.userBean = userBean;
	}
	
	public void verifyUser(){
		String strPassword = "";
		initMySQL();
		sql = "select * from user where login_name=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userBean.getLoginName());
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				userBean.setId(-1);
				closeResultSet();
				return;
			}
			strPassword = resultSet.getString("password");
			System.out.println(strPassword);
			if (!strPassword.equals(userBean.getPassword())){
				userBean.setId(-2);
				closeResultSet();
				return;
			}
			if (resultSet.getInt("enabled")==0) {
				userBean.setId(-3);
				closeResultSet();
				return;
			}
			userBean.setId(resultSet.getInt("id"));
			userBean.setName(resultSet.getString("name"));
			userBean.setLoginTimes(resultSet.getInt("login_times"));
			userBean.setLastLoginIP(resultSet.getString("last_login_ip"));
			userBean.setSuperAdmin(resultSet.getString("superadmin"));
			userBean.setModuleRight(resultSet.getInt("module_right"));
			userBean.setReadORwrite(resultSet.getInt("read_write"));
			closeResultSet();
			return;
		} catch (Exception e) {
			// TODO: handle exception
			userBean.setId(0);
			closeResultSet();
			System.out.println("获取结果集异常！"+e);
		} 
	}
	
	private void closeResultSet(){
		try {
			if(resultSet!=null){
				resultSet.close();
			}
		} catch (final Exception e) {
			// TODO: handle exception
			System.out.println("关闭resultSet异常！"+e);
		} finally{
			close();
		}
	}
	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
}

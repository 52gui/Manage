package com.dreamer.bean;

public class UserBean {
	private int id;
	private String name;
	private String loginName;
	private String password;
	private int loginTimes;
	private String lastLoginIP;
	private String superAdmin;
	private int moduleRight;
	private int readORwrite;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLoginTimes() {
		return loginTimes;
	}
	public void setLoginTimes(int loginTimes) {
		this.loginTimes = loginTimes;
	}
	public String getLastLoginIP() {
		return lastLoginIP;
	}
	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}
	public String getSuperAdmin() {
		return superAdmin;
	}
	public void setSuperAdmin(String superAdmin) {
		this.superAdmin = superAdmin;
	}
	public int getModuleRight() {
		return moduleRight;
	}
	public void setModuleRight(int moduleRight) {
		this.moduleRight = moduleRight;
	}
	public int getReadORwrite() {
		return readORwrite;
	}
	public void setReadORwrite(int readORwrite) {
		this.readORwrite = readORwrite;
	}
	
}

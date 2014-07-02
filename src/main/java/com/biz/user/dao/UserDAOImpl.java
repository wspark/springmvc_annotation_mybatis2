package com.biz.user.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


//import org.springframework.stereotype.Repository;

import com.biz.common.JDBCUtil;
import com.biz.user.vo.Users;
import com.ibatis.sqlmap.client.SqlMapClient;

//@Repository("userDAO")
public class UserDAOImpl implements UserDAOIF {

	
	@Override
	public int insertUser(Users user) {
	
		SqlMapClient sqlMap = JDBCUtil.getSqlMapInstance();
		
		int row=-1;
		try{
			sqlMap.insert("insertUser",user);
			row=1;
		}catch(Exception e){
		e.printStackTrace();	
		}
	
		return row;	
		
	}

	@Override
	public int updateUser(Users user) {
		int row=-1;		
		SqlMapClient sqlMap = JDBCUtil.getSqlMapInstance();
		
		try {
			row = sqlMap.update("updateUser", user);
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return row;	
	}

	@Override
	public int deleteUser(String id) {
		int row=-1;		
		SqlMapClient sqlMap = JDBCUtil.getSqlMapInstance();
		
		try {
			row = sqlMap.delete("deleteUser", id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return row;
	}

	@Override
	public Users findUser(String id) {
		Users user=null;
		SqlMapClient sqlMap = JDBCUtil.getSqlMapInstance();
		try {
			user = (Users)sqlMap.queryForObject("findUsers",id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return user;
	}

	@Override
	public boolean login(String id, String password) {
		boolean isExist=false;		
		SqlMapClient sqlMap = JDBCUtil.getSqlMapInstance();
		HashMap<String, String> loginInfo = new HashMap<String, String>();
		loginInfo.put("id", id);
		loginInfo.put("password",password);

		
		try {
			Object result = sqlMap.queryForObject("login", loginInfo);
			if(result != null ) isExist=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isExist;
	
	}

	@Override
	public ArrayList<Users> findUserList() {
		ArrayList<Users> userList=new ArrayList<Users>();
		SqlMapClient sqlMap = JDBCUtil.getSqlMapInstance();
		
		try {
			userList = (ArrayList)sqlMap.queryForList("findUserList");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
	}
}

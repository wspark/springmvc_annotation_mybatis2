package com.biz.user.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.biz.user.vo.Users;
import com.ibatis.sqlmap.client.SqlMapClient;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.biz.common.JDBCUtil;

@Repository
public class UserDAOImpl implements UserDAOIF {
	
	@Override
	public int insertUser(Users user) {
	
		SqlSession session = JDBCUtil.getSqlMapInstance().openSession(true);
		
		int row=-1;
		try{
			session.insert("insertUser",user);
			row=1;
		}finally{
			session.close();
		}	
		return row;			
	}

	@Override
	public int updateUser(Users user) {
		int row=-1;		
		SqlSession session = JDBCUtil.getSqlMapInstance().openSession(true);
		
		try {
			row = session.update("updateUser", user);
		} finally{
			session.close();
		}	
		return row;	
	}

	@Override
	public int deleteUser(String id) {
		int row=-1;		
		SqlSession session = JDBCUtil.getSqlMapInstance().openSession(true);
		
		try {
			row = session.delete("deleteUser", id);
		}finally{
			session.close();
		}			
		return row;
	}

	@Override
	public Users findUser(String id) {
		Users user=null;
		SqlSession session = JDBCUtil.getSqlMapInstance().openSession(true);
		try {
			user = (Users)session.selectOne("findUsers",id);
		} finally{
			session.close();
		}		
		return user;
	}

	@Override
	public boolean login(String id, String password) {
		boolean isExist=false;		
		SqlSession session = JDBCUtil.getSqlMapInstance().openSession(true);
		HashMap<String, String> loginInfo = new HashMap<String, String>();
		loginInfo.put("id", id);
		loginInfo.put("password",password);
		
		try {
			Object result = session.selectOne("login", loginInfo);
			if(result != null ) isExist=true;
		} finally{
			session.close();
		}	
		return isExist;	
	}

	@Override
	public ArrayList<Users> findUserList() {
		ArrayList<Users> userList=new ArrayList<Users>();
		SqlSession session = JDBCUtil.getSqlMapInstance().openSession(true);
		
		try {
			List<Users> result = session.selectList("findUserList");
			for(Users user : result){
				userList.add(user);
			}
		} finally{
			session.close();
		}			
		return userList;
	}
}

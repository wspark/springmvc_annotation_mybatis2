package com.biz.common;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
//import org.apache.ibatis.io.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class JDBCUtil {
	private static final SqlMapClient sqlMap;
	static {
	try {
		String resource = "SqlConfigMap.xml";
		Reader reader = Resources.getResourceAsReader (resource);
		sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader); //xml parsing
	}catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException ("Error initializing	MyAppSqlConfig class. Cause: " + e);
	
		}
	}
	public static SqlMapClient getSqlMapInstance(){
		return sqlMap;
	}
	
}

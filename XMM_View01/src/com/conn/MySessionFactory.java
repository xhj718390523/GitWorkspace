package com.conn;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MySessionFactory {
	private static SqlSessionFactory sessionFactory ;
	//--连接数据库--
	static{
	    //--SqlMappingConfig。xml 源文件
	     String resource = "SqlMapperConfig.xml";
	     Reader reader = null;
	     
		//--获取输入流
			try {
				
				reader = Resources.getResourceAsReader(resource);
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("获取resource 失败");
			}
		//--创建构造器
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//--构造SqlSessionFactory
			sessionFactory = sqlSessionFactoryBuilder.build(reader);	
	}
	
	//--获取SqlSession---
	public static SqlSession getSession() {
		return sessionFactory.openSession();
	}
	//--关闭SqlSession
	public static void close(SqlSession sqlSession){
		if(sqlSession != null)
			sqlSession.close();
	}
	
			
}

































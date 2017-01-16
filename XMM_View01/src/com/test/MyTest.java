package com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.class01.TranslateXML;
import com.conn.MySessionFactory;
import com.data.SelectData;
import com.user.User;
import com.user.UserMapper;
public class MyTest {

	@Test
	public void test() {
		File file = new File("src/web.xml");
		TranslateXML translateXML = new TranslateXML();
		try {
			FileReader reader = new FileReader(file);
			translateXML.tran(reader);
			String str = translateXML.getTranXML();
//			System.out.println("-------------------------------------");
			System.out.println(str);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void connTest(){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/xhj";
		String user = "root";
		String password = "";
		//--加载驱动
		try {
			Class.forName(driver);
			System.out.println("驱动加载成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//--连接数据库
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("连接数据库成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
   //----测试配置文件是否正确--------------------------
	@Test
	public void testMapper(){
		//---指定源文件
		String resource = "SqlMapperConfig.xml" ;
		//--获取源文件输入流
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			System.out.println("获取源文件成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("获取源文件失败");
		}
		
	}
	
	@Test
	//---测试数据库操作----
	public void dataTest(){
		//--获取session
		SqlSession session = MySessionFactory.getSession();
		//---映射接口
		UserMapper mapper = session.getMapper(UserMapper.class);
		//SelectData selectData = new SelectData();
		User user = new User();
////		user.setId(4);
		user.setName("insertDate");
		user.setPassword("123456");
		mapper.insert(user);
//		selectData.insertDate(user);
//		System.out.println(mapper.selectname("insertDate"));
		//session.commit();
		//selectData.insertDate(user);
		
		//System.out.println(selectData.select("insertDate"));
	
	}
}


































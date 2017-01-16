package com.data;

import org.apache.ibatis.session.SqlSession;

import com.conn.MySessionFactory;
import com.user.User;
import com.user.UserMapper;

public class SelectData {
	static UserMapper mapper = null;
	static SqlSession session;
	static{
		//--获取session
		 session = MySessionFactory.getSession();
		//--映射接口
		 mapper = session.getMapper(UserMapper.class);
	}
	public void comm(){
		session.commit();
	}
	//------操作数据库-------------
	public User select(String name){
		User user = mapper.selectname(name);
		return user;
	}
	//--插入用户----
	public void insertDate(User user){
		mapper.insert(user);
	}

}

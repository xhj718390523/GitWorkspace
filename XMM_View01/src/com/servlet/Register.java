package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.conn.MySessionFactory;
import com.data.SelectData;
import com.user.User;
import com.user.UserMapper;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//--获取用户提交的信息：用户名，密码
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//--存储返回消息------------------------------------
		String mes = "";
		//--判断用户名，密码是否为空. 如果为空，则---
		if(name == "" || password == ""){
			mes = "null";
			request.setAttribute("message", mes);
            request.getRequestDispatcher("register.jsp").forward(request, response);
			
		}else{
		//System.out.println(name+"  "+password);
		//--获取数据库操作对象
//		SelectData data = new SelectData();
			SqlSession session = MySessionFactory.getSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
		//-----检查用户名是否存在，如果存在，跳转到注册页面，重新输入用户名
			System.out.println(name);
		User user = mapper.selectname(name);
		//--如果用户名不存在，注册用户
		if(user != null){
			mes = "exist";
			request.setAttribute("message", mes);
            request.getRequestDispatcher("register.jsp").forward(request, response);
            
		}else{
		//注册成功，跳转到登录页面
			User newUser = new User();
			newUser.setName(name);
			newUser.setPassword(password);
			mapper.insert(newUser);
			session.commit();
			session.close();
			//request.getRequestDispatcher("login.jsp").forward(request, response);
			response.sendRedirect("login.jsp");
			
		}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

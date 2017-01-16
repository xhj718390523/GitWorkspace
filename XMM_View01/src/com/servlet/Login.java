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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//---获取用户提交的用户名，密码
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String mes = "";
		//--判断用户名或者密码是否为空,如果为空，返回登录页面
		if(name == "" || password == ""){
			mes =  "null";
			request.setAttribute("logmessage", mes);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			
		
		//-- 数据库验证----创建搜索功能类对象---
//		SelectData seclectDate = new SelectData();
			SqlSession session = MySessionFactory.getSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
		//--获取会员信息-------
	    User user = mapper.selectname(name);
	    //--如果查询不到会员，跳转提示用户不存在
	    if(user == null){
	    	request.setAttribute("logmessage", "nameError");
	    	request.getRequestDispatcher("login.jsp").forward(request, response);
	    	
	    	System.out.println("用户不存在");
	    }else if (password.equals(user.getPassword())) {
	    //--如果用户存在，密码正确，跳转到解析页面
		
			request.getSession().setAttribute("islogin", "success");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
		//---如果密码错误，跳转提示密码错误	
			request.setAttribute("logmessage", "passwordError");
	    	request.getRequestDispatcher("login.jsp").forward(request, response);
		    System.out.println("密码错误");
		}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

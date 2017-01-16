package com.servlet;

import java.io.IOException;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.class01.TranslateXML;

@WebServlet("/TranXML")
public class TranXML extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TranXML() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//--servlet 验证
		String islogin = (String) request.getSession().getAttribute("islogin");
//		if(islogin == null){
//			System.out.println(islogin);
//			response.sendRedirect("login.jsp");
//		}
		//--获取用户提交的文本信息
		String str = request.getParameter("text");
		//--将文本转成Reader输入流
		StringReader reader = new StringReader(str);
		//--获取xml文件解析对象
		TranslateXML translateXML = new TranslateXML();
		//---解析xml文件流,
		translateXML.tran(reader);
		//--获取解析过的字符串，并上传-----------
		str = translateXML.getTranXML();
		System.out.println(str);
//		request.setAttribute("xml", str);
		request.getSession().setAttribute("xml", str);
		//--关闭流
		reader.close();
		//---转发到指定页面
//		request.getRequestDispatcher("TranXML.jsp").forward(request, response);
		response.sendRedirect("TranXML.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

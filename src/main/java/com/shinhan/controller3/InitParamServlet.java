package com.shinhan.controller3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
/* 1. 프로그램 안에 고정하는 방법 2.WEB-INF 에 web.xml파일로 빼서 사용 
@WebServlet(
		urlPatterns = { 
				"/InitParamServlet", 
				"/init","/init2"
		}, 
		initParams = { 
				@WebInitParam(name = "myname", value = "Seoyeon"), 
				@WebInitParam(name = "email", value = "rlatjdus0827@naver.com"),
				@WebInitParam(name = "phone", value = "010-1234-5678")
		})*/
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InitParamServlet() {
    	System.out.println("InitParamServlet 생성자");
    }
	@Override
	public void destroy() {
		System.out.println("InitParamServlet 소멸자(destroy)");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("InitParamServlet 초기화(init)");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

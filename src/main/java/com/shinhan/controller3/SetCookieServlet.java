package com.shinhan.controller3;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieServlet
 */
@WebServlet("/jsp/cookieSet")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pass = request.getParameter("userpass");
		
		Cookie c1 = new Cookie("myid",id);
		Cookie c2 = new Cookie("mypass",pass);
		Cookie c3 = new Cookie("myInfo",URLEncoder.encode("신한금융sw아카데미","utf-8"));
		c1.setMaxAge(24*60*60); //하루동안 유효
		c2.setMaxAge(3*60); //3분동안 유효
		//c3는 default : 유효시간을 설정하지 않으면 브라우저 종료시 지워진다.
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		
		request.getRequestDispatcher("cookie.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

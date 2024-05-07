package com.shinhan.controller5;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/jsp/order.go")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("order.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String menuName = request.getParameter("lunch");
		int count = Integer.parseInt(request.getParameter("count"));
		System.out.println(menuName + "==>" + count);
		//request는 요청시마다 값이 다르다 (x)
		//session 은 브라우저당 하나 (ok)
		//application은 다른사람과 공유된다 (x)
		
		HttpSession session = request.getSession();
		Map<String,Integer> cart = (Map<String,Integer>)session.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<String,Integer>();
			cart.put(menuName, count);
		}else {
			if(cart.containsKey(menuName)) {
				cart.put(menuName, cart.get(menuName) + count);
			}else {
				cart.put(menuName, count);
			}
		}
		session.setAttribute("cart", cart);
		request.getRequestDispatcher("orderResult.jsp").forward(request,response);
	
	}

}

package com.shinhan.controller3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;
import com.shinhan.filter.MySessionListener;


/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/auth/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	List<String> user_list = new ArrayList<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//login창 보여주기
//		System.out.println("hello");
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 입력한 ID, pass 검사
		EmpService service = new EmpService();
		String email = request.getParameter("email");
		String phone = request.getParameter("pswd");
		EmpDTO emp = service.loginChk(email, phone);
		if(emp == null || emp.getEmployee_id() == -1) { //아이디 존재하지 않음
			request.setAttribute("message", "존재하지 않는 아이디");
		}else if(emp.getEmployee_id() == -2) { //비밀번호 오류
			request.setAttribute("message", "비밀번호 오류");
		}else {
			ServletContext app = getServletContext();
			HttpSession session = request.getSession();
			MySessionListener loginUser = new MySessionListener(email, phone);
		    System.out.println("새로운 세션인가?" + session.isNew());
		 
			session.setAttribute("loginUser", loginUser);
			user_list.add(email);
			app.setAttribute("user_list", user_list);
			app.setAttribute("total_user", MySessionListener.total_user);
		 
			//List<String> list = ((List<String>)app.getAttribute("user_list"));
			//System.out.println(list!=null?list.size():0);
			
			session.setAttribute("loginEmp", emp);
			String remember = request.getParameter("remember");
			session.setAttribute("kind", remember);
			
			String lastAddress = (String)session.getAttribute("lastRequest");
			if(lastAddress == null || lastAddress.length() ==0) {
				lastAddress = getServletContext().getContextPath();
				
			}
			response.sendRedirect(lastAddress);
			
			//response.sendRedirect("../emp/emplist.do");
			return;
		}
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}

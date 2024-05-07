package com.shinhan.controller2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DeptService;
import com.shinhan.emp.EmpService;

/**
 * Servlet implementation class EmpByDeptServlet
 */
@WebServlet("/emp/empByDept.do")
public class EmpByDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("deptlist",new DeptService().selectAll());
		request.getRequestDispatcher("empByDept.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptid = Integer.parseInt(request.getParameter("deptid"));
		
		request.setAttribute("emplist", new EmpService().selectBydept(deptid));
		request.getRequestDispatcher("empByDept2.jsp").forward(request, response);
		
	}

}

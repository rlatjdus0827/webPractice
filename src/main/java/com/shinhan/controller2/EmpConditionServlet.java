package com.shinhan.controller2;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DeptDTO;
import com.shinhan.dept.DeptService;
import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;
import com.shinhan.emp.JobDTO;
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class JobListServlet
 */
@WebServlet("/emp/retrieve.do")
public class EmpConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 객체생성
		// 비지니스로직수헹
		// job조회
		EmpService eService = new EmpService();
		List<JobDTO> joblist = eService.selectAllJob();
		System.out.println("job : " + joblist.size() + "건 조회됨.");
		// 요청문서에 데이터를 저장 (jsp가사용하기위해)
		request.setAttribute("job_datas", joblist);// joblist의 내용이 j_datas라는 이름으로 저장댐

		// 부서조회
		DeptService dService = new DeptService();
		List<DeptDTO> deptlist = dService.selectAll();
		System.out.println("dept : " + deptlist.size() + "건 조회됨.");
		request.setAttribute("dept_datas", deptlist);

		// jsp에위임
		RequestDispatcher rd = request.getRequestDispatcher("retrieve.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String jobid = req.getParameter("jobid");
		int deptid = Integer.parseInt(req.getParameter("deptid"));
		int salary = Integer.parseInt(req.getParameter("salary"));
		Date hiredate = DateUtil.getSQLDate(req.getParameter("hiredate"));
		
		EmpService service = new EmpService();
		List<EmpDTO> emplist = service.selectByCondition(deptid, jobid, hiredate, salary);
		req.setAttribute("emplist", emplist);
		RequestDispatcher rd = req.getRequestDispatcher("emplist2.jsp");
		rd.forward(req, resp);
		}
	
	
}

package com.shinhan.emp;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Controller->Service->DAO
//          <-         <- 
//Service : 비지니스 로직을 수행한다. 
public class EmpService {

	EmpDAO empDAO = new EmpDAO();
	
	//login chk
	public EmpDTO loginChk(String email, String phone) {
		return empDAO.loginChk(email, phone);
	}
	//job모두조회
	public List<JobDTO> selectAllJob() {
		return empDAO.selectAllJob();
	}
	//매니저모두조회
	public List<HashMap<String,Object>> selectAllManager() {
		return empDAO.selectAllManager();
	}
	public int selectByEmail(String email) {
		return empDAO.selectByEmail(email);
	}
	//직원번호가 들어오면 직원보너스를 return 하는 함수를 호출
	public double callFunction (int empid) {
		return empDAO.callFunction(empid);
	}
	
	//직원번호를 이용해서 직원 이름과 직책 급여를 조회
	public Map<String,Object> empInfo(int empid){
		return empDAO.empInfo(empid);
	}
	 //8.삭제(Delete)
    public int empDelete(int empid) {
    	return empDAO.empDelete(empid);
    }
	//7.수정(Update)
    public int empUpdate(EmpDTO emp) {
    	return empDAO.empUpdate(emp);
    }
	//6.입력(Insert)
    public int empInsert(EmpDTO emp) {
    	return empDAO.empInsert(emp);
    }
    //5.다양한 조건으로 조회하기
    //부서별(=), 직책별(=), 입사일별(>=), 급여(>=)
    public List<EmpDTO> selectByCondition(int deptid, String jobid,
    		                              Date hdate, int salary) {
    	return empDAO.selectByCondition(deptid, jobid, hdate, salary);
    }
	//4.특정JOB인 직원조회
  	public List<EmpDTO> selectByJob(String jobid) {
		return empDAO.selectByJob(jobid);
	}
	 //3.특정부서의 직원모두조회
  	public List<EmpDTO> selectBydept(int deptid) {
  		return empDAO.selectBydept(deptid);
  	}
	//2.특정직원의 상세보기
    public EmpDTO selectById(int empid) {
    	return empDAO.selectById(empid);
    }
	
	//1.직원모두조회
	public List<EmpDTO> selectAll() {		
		return empDAO.selectAll();
	}
}
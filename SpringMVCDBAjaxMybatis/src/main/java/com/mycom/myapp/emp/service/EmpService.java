package com.mycom.myapp.emp.service;

import java.util.List;
import java.util.Map;

import com.mycom.myapp.emp.dto.EmpDto;

public interface EmpService {

	List<EmpDto> listEmp();
	EmpDto detailEmp(int employeeId);
	int insertEmp(EmpDto empDto);
	int updateEmp(EmpDto empDto);
	int deleteEmp(int employeeId);
	
	List<EmpDto> listEmpLike(String searchWord);
	List<EmpDto> listEmpResultMap(String searchWord);
	List<EmpDto> listEmpResultMap2(String searchWord);
	List<EmpDto> listEmpParametertMap(String searchWord);
	List<EmpDto> listEmpParameterMap(Map<String, String> map);
	List<EmpDto> listEmpParameterMap2(String firstName, String lastName);
	List<EmpDto> listEmpParameterMap3(EmpDto empDto);
	List<EmpDto> listEmpWhereIf(String firstName, String lastName, String email);
}

package com.mycom.myapp.emp.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mycom.myapp.emp.dao.EmpDao;
import com.mycom.myapp.emp.dto.EmpDto;

@Service
public class EmpServiceImpl implements EmpService {

	// 생성자 DI, @Autowired 필요 X
	private final EmpDao empDao;
	
	public EmpServiceImpl(EmpDao empDao) {
		this.empDao = empDao;
	}
	
	@Override
	public List<EmpDto> listEmp() {
		return empDao.listEmp();
	}

	@Override
	public EmpDto detailEmp(int employeeId) {
		return empDao.detailEmp(employeeId);
	}

	@Override
	public int insertEmp(EmpDto empDto) {
		return empDao.insertEmp(empDto);
	}

	@Override
	public int updateEmp(EmpDto empDto) {
		return empDao.updateEmp(empDto);
	}

	@Override
	public int deleteEmp(int employeeId) {
		return empDao.deleteEmp(employeeId);
	}

	@Override
	public List<EmpDto> listEmpLike(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpDto> listEmpResultMap(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpDto> listEmpResultMap2(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpDto> listEmpParametertMap(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpDto> listEmpParameterMap(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpDto> listEmpParameterMap2(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpDto> listEmpParameterMap3(EmpDto empDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpDto> listEmpWhereIf(String firstName, String lastName, String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
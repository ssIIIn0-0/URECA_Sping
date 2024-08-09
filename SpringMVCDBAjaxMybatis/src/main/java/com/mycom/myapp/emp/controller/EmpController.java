package com.mycom.myapp.emp.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mycom.myapp.emp.dto.EmpDto;
import com.mycom.myapp.emp.service.EmpService;

@Controller
@RequestMapping("/emps")
public class EmpController {
	// 생성자 DI
	private final EmpService empService;

	public EmpController(EmpService empService) {
		this.empService = empService;
	}

	@GetMapping("/")
	public String empMain() {
		return "emps"; // emps.jsp
	}

	@GetMapping("/list")
	@ResponseBody // View Resolver 탐색을 진행하지 않고 바로 응답 (JSON)
	public List<EmpDto> listEmp() {
		List<EmpDto> empList = empService.listEmp();
		return empList; // empList 객체를 json 문자열로 변경 후에 client 에 전송
	}

	@GetMapping("/detail/{employeeId}")
	@ResponseBody // View Resolver 탐색을 진행하지 않고 바로 응답 (JSON)
	public EmpDto detailEmp(@PathVariable int employeeId) {
		EmpDto empDto = empService.detailEmp(employeeId);
		return empDto;
	}

	@PostMapping("/insert")
	@ResponseBody // View Resolver 탐색을 진행하지 않고 바로 응답 (JSON)
	public int insertEmp(EmpDto empDto) {
		int ret = empService.insertEmp(empDto);
		return ret;
	}

	@PostMapping("/update")
	@ResponseBody // View Resolver 탐색을 진행하지 않고 바로 응답 (JSON)
	public int updateEmp(EmpDto empDto) {
		int ret = empService.updateEmp(empDto);
		return ret;
	}

	@GetMapping("/delete/{employeeId}")
	@ResponseBody // View Resolver 탐색을 진행하지 않고 바로 응답 (JSON)
	public int deleteEmp(@PathVariable int employeeId) {
		int ret = empService.deleteEmp(employeeId);
		return ret;
	}
}
package com.mycom.myapp.emp.controller;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mycom.myapp.emp.dto.EmpDto;
import com.mycom.myapp.emp.service.EmpService;
@Controller
public class EmpController2 {
    // 생성자 DI
    private final EmpService empService;
    
    public EmpController2(EmpService empService) {
        this.empService = empService;
    }
    @GetMapping("/listEmpLike")
    @ResponseBody 
    public List<EmpDto> listEmpLike(@RequestParam("searchWord") String searchWord) {
        List<EmpDto> empList = empService.listEmpLike(searchWord);
        return empList;
    }
    @GetMapping("/listEmpResultMap")
    @ResponseBody 
    public List<EmpDto> listEmpResultMap(@RequestParam("searchWord") String searchWord) {
        List<EmpDto> empList = empService.listEmpResultMap(searchWord);
        return empList;
    }
    
    @GetMapping("/listEmpResultMap2")
    @ResponseBody 
    public List<EmpDto> listEmpResultMap2(@RequestParam("searchWord") String searchWord) {
        List<EmpDto> empList = empService.listEmpResultMap2(searchWord);
        return empList;
    }   
    
    @GetMapping("/listEmpParameterMap")
    @ResponseBody 
    public List<EmpDto> listEmpParameterMap(@RequestParam Map<String, String> map) {
        List<EmpDto> empList = empService.listEmpParameterMap(map);
        return empList;
    }
    
    @GetMapping("/listEmpParameterMap2")
    @ResponseBody 
    public List<EmpDto> listEmpParameterMap2(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        List<EmpDto> empList = empService.listEmpParameterMap2(firstName, lastName);
        return empList;
    }
    
    @GetMapping("/listEmpParameterMap3")
    @ResponseBody 
    public List<EmpDto> listEmpParameterMap3(EmpDto empDto) {
        List<EmpDto> empList = empService.listEmpParameterMap3(empDto);
        return empList;
    }
    
    @GetMapping("/listEmpWhereIf")
    @ResponseBody 
    public List<EmpDto> listEmpWhereIf(
            @RequestParam(value="firstName", required=false) String firstName, 
            @RequestParam(value="lastName", required=false) String lastName,
            @RequestParam(value="email", required=false) String email
        ) {
        List<EmpDto> empList = empService.listEmpWhereIf(firstName, lastName, email);
        return empList;
    }
}
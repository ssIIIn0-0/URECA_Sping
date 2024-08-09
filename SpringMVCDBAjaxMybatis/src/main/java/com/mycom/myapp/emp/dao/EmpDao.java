package com.mycom.myapp.emp.dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.mycom.myapp.emp.dto.EmpDto;
@Mapper
public interface EmpDao {
    // 기본적인 crud
    List<EmpDto> listEmp();
    EmpDto detailEmp(int employeeId);
    int insertEmp(EmpDto empDto);
    int updateEmp(EmpDto empDto);
    int deleteEmp(int employeeId);
    
    // Mybatis 연습
    List<EmpDto> listEmpLike(String searchWord);  // like 검색
    List<EmpDto> listEmpResultMap(String searchWord);  // ResultMap 사용
    List<EmpDto> listEmpResultMap2(String searchWord);  // ResultMap 사용
    
    // parameter type map
    List<EmpDto> listEmpParameterMap(Map<String, String> map);
    List<EmpDto> listEmpParameterMap2(@Param("firstName") String firstName, @Param("lastName") String lastName );
    List<EmpDto> listEmpParameterMap3(EmpDto empDto);
    
    // 동적 sql
    List<EmpDto> listEmpWhereIf(
            @Param("firstName") String firstName, 
            @Param("lastName") String lastName,
            @Param("email") String email
        );
}

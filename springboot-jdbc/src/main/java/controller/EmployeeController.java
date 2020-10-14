package controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import mapper.EmployeeMapper;
import model.Employee;

@RestController
public class EmployeeController {
	
	@Resource
	private EmployeeMapper employeeMapper;

    @GetMapping("emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }
}

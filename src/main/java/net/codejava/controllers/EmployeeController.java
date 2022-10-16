package net.codejava.controllers;


import net.codejava.models.Employee;
import net.codejava.models.WorkerSchedule;
import net.codejava.repository.EmployeeRepository;
import net.codejava.repository.WorkerScheduleRepository;
import net.codejava.service.EmployeeService;
import net.codejava.service.WorkerScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/employees_list")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;



    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }

    //web/employees
    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("employees1", employeeService.findAll());
        return "employees_list";
    }

    //web/employees
    @PostMapping
    public String create(@ModelAttribute Employee employee, @ModelAttribute WorkerSchedule workerSchedule) {
        employeeService.save(employee);
             return "redirect:/employees_list";
    }

    //web/employees/create
    @GetMapping("create")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee_create";
    }

    //web/employees/{id}}
    @GetMapping("/{id}")
    public String update(Model model, @PathVariable long id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
        } else {
            model.addAttribute("employee", new Employee());
        }
        return "employee_edit";
    }

    //web/employees/delete/{id}}
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        employeeService.deleteById(id);
        return "redirect:/employees_list";
    }

    @PostMapping("/update/{id}")
    public String updateDate(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees_list";
    }
}

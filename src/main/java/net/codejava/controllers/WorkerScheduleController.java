package net.codejava.controllers;

import net.codejava.models.WorkerSchedule;
import net.codejava.repository.EmployeeRepository;
import net.codejava.repository.WorkerScheduleRepository;
import net.codejava.service.WorkerScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/worker_schedule")
public class WorkerScheduleController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private WorkerScheduleService workerScheduleService;

    public WorkerScheduleController(EmployeeRepository employeeRepository, WorkerScheduleService workerScheduleService) {
        this.employeeRepository = employeeRepository;
        this.workerScheduleService = workerScheduleService;
    }

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("schedule", workerScheduleService.findAll());
        return "worker_schedule";
    }
    @GetMapping("/{id}")
    public String update(Model model, @PathVariable long id) {
        Optional<WorkerSchedule> workerSchedule = workerScheduleService.findById(id);
        model.addAttribute("employees1", employeeRepository.findAll());
        if (workerSchedule.isPresent()) {
            model.addAttribute("workerSchedule", workerSchedule.get());
        } else {
            model.addAttribute("workerSchedule", new WorkerSchedule());
        }
        return "worker_schedule_edit";
    }
    @PostMapping("/update/{id}")
    public String updateDate(@ModelAttribute WorkerSchedule workerSchedule) {
        workerScheduleService.updateWithPartialDate(workerSchedule.getId(),workerSchedule);
        return "redirect:/worker_schedule";
    }
}


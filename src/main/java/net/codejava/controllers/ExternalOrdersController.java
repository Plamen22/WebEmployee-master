package net.codejava.controllers;


import net.codejava.models.ExternalOrders;

import net.codejava.service.EmployeeService;
import net.codejava.service.ExternalOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/external_orders")
public class ExternalOrdersController {

    @Autowired
    private ExternalOrdersService externalOrdersService;

    @Autowired
    private EmployeeService employeeService;

    public ExternalOrdersController(EmployeeService employeeService, ExternalOrdersService externalOrdersService) {
        this.employeeService = employeeService;
        this.externalOrdersService = externalOrdersService;
    }


    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("orders", externalOrdersService.findAll());
      //  model.addAttribute("employees1",employeeRepository.findAll());
        return "external_orders";
    }


    @PostMapping
    public String create(@ModelAttribute ExternalOrders externalOrders) {
        externalOrdersService.save(externalOrders);
        return "redirect:/external_orders";
    }


    @GetMapping("create")
    public String createOrders(Model model) {
        model.addAttribute("orders", externalOrdersService.findAll());
        model.addAttribute("employees1", employeeService.findAll());
        model.addAttribute("externalOrders", new ExternalOrders());
        return "orders_create";
    }

    @GetMapping("/{id}")
    public String update(Model model, @PathVariable long id) {
        Optional<ExternalOrders> externalOrders = externalOrdersService.findById(id);
        model.addAttribute("employees1", employeeService.findAll());
        if (externalOrders.isPresent()) {
            model.addAttribute("externalOrders", externalOrders.get());
        } else {
            model.addAttribute("externalOrders", new ExternalOrders());
        }
        return "orders_edit";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        externalOrdersService.deleteById(id);
        return "redirect:/external_orders";
    }

    @PostMapping("/update/{id}")
    public String updateDate(@ModelAttribute ExternalOrders externalOrders) {
        externalOrdersService.save(externalOrders);
        return "redirect:/external_orders";
    }

}


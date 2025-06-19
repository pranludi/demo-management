package com.example.management.controller;

import com.example.management.domain.Staff;
import com.example.management.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/list")
    public String staffList(Model model) {
        model.addAttribute("list", staffService.list());
        return "staffList";
    }

    @GetMapping("/add/form")
    public String staffAddForm() {
        return "staffAddForm";
    }

    @PostMapping("/add/form")
    public String staffAddForm(StaffAddForm staffAddForm) {
        Staff staff = new Staff();
        staff.setLoginId(staffAddForm.getLoginId());
        staff.setPassword(staffAddForm.getPassword());
        staff.setName(staffAddForm.getName());
        staff.setBirthDate(staffAddForm.getBirthDate());
        staff.setEmail(staffAddForm.getEmail());
        staffService.addStaff(staff);
        return "redirect:/list";
    }

    @GetMapping("/edit/form/{id}")
    public String staffEditForm(@PathVariable Long id, Model model) {
        Staff staff = staffService.getStaff(id);
        model.addAttribute("staffId", id);
        model.addAttribute("staff", staff);
        return "staffEditForm";
    }


}

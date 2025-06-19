package com.example.management.service;

import com.example.management.domain.Staff;
import com.example.management.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository repository;

    public StaffService(StaffRepository repository) {
        this.repository = repository;
    }

    public Staff getStaff(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Staff getStaffByLoginId(String loginId) {
        return repository.findByLoginId(loginId);
    }

    public Staff addStaff(Staff staff) {
        return repository.save(staff);
    }

    public List<Staff> list() {
        return repository.findAll();
    }
}

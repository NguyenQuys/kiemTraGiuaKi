package com.example.Kiemtragiuaki.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Kiemtragiuaki.model.NhanVien;
import com.example.Kiemtragiuaki.service.NhanVienService;
import com.example.Kiemtragiuaki.service.PhongBanService;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class NhanVienController {
    @Autowired
    private PhongBanService phongBanService;

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public String nhanVien(Model model){
        List<NhanVien> nhanVien = nhanVienService.getAll();
        model.addAttribute("employees", nhanVien);
        return "nhanVien/employee-list";
    }

    @GetMapping("/add")
    public String addNhanVien(Model model){
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("phongBanList", phongBanService.getAll());
        return "nhanVien/add-employee";
    }

    @PostMapping("/add")
    public String add(@Valid NhanVien nhanVien, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("nhanVien", new NhanVien());
            model.addAttribute("phongBanList", phongBanService.getAll());
            return "nhanVien/add-employee";
        }
        nhanVienService.add(nhanVien);
        return "redirect:/employee";
    }

    @GetMapping("/update/{id}")
    public String updateNhanVienForm(@PathVariable("id") String id, Model model) {
        NhanVien nhanVien = nhanVienService.getAllById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee id: " + id));
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("phongBanList", phongBanService.getAll());
        return "nhanVien/update-employee";
    }

    @PostMapping("/update/{id}")
    public String updateNhanVien(@PathVariable("id") String id, @Valid NhanVien nhanVien,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("phongBanList", phongBanService.getAll());
            return "nhanVien/update-employee";
        }
        nhanVien.setMaNV(id); 
        nhanVienService.update(nhanVien);
        return "redirect:/employee-list"; 
    }

    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable String id){
        nhanVienService.deleteById(id);
        return "redirect:/employee-list";
    }
}

package com.example.Kiemtragiuaki.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Kiemtragiuaki.model.PhongBan;
import com.example.Kiemtragiuaki.service.PhongBanService;

import java.util.List;

@Controller
@RequestMapping("/board")
public class PhongBanController {
    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String phongBan(Model model){
        List<PhongBan> phongBans = phongBanService.getAll();
        model.addAttribute("board", phongBans);
        return "phongBan/board-list";
    }

    @GetMapping("/add")
    public String addPhongBan(Model model){
        model.addAttribute("board", new PhongBan());
        return "phongBan/add-board";
    }

    @PostMapping("/add")
    public String add(@Valid PhongBan phongBan, BindingResult result, Model model){
        if (result.hasErrors()){
            return "phongBan/add-board";
        }
        phongBanService.add(phongBan);
        // model.addAttribute("board", new PhongBan());
        return "redirect:/board";
    }

    @GetMapping("/update/{id}")
    public String updatePhongBanForm(@PathVariable("id") String id, Model model) {
        PhongBan phongBan = phongBanService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid category id: " + id));
        model.addAttribute("phongBan", phongBan);
        return "phongBan/update-board";
    }

    @PostMapping("/update/{id}")
    public String updatePhongBan(@PathVariable("id") String id, @Valid PhongBan phongBan,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "phongBan/update-board";
        }
        phongBan.setMaPhong(id); 
        phongBanService.update(phongBan);
        return "redirect:/phong-ban";
    }

    @GetMapping("/delete/{id}")
    public String deletePhongBan(@PathVariable String id){
        phongBanService.deleteById(id);
        return "redirect:/phong-ban";
    }
}

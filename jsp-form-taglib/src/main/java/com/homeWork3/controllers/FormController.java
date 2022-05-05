package com.homeWork3.controllers;

import com.homeWork3.model.FormObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/form")
public class FormController {

    @GetMapping
    public String getForm(Model model) {
        FormObject formObject = new FormObject();
        model.addAttribute("pageTitle", "Practicing Form Taglib");
        model.addAttribute("formObj", formObject);
        List<String> locationList = new ArrayList<>();
        locationList.add("Dhaka");
        locationList.add("Chittagong");
        locationList.add("Khulna");
        model.addAttribute("locationList", locationList);
        return "form-elements";
    }

    @PostMapping
    public String postForm (Model model, @ModelAttribute("formObj") FormObject formObject) {
        System.out.printf(formObject.toString());

        return null;
    }
}

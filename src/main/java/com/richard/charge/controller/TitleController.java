package com.richard.charge.controller;

import com.richard.charge.model.StatusTitle;
import com.richard.charge.model.Title;
import com.richard.charge.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/titles")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @GetMapping("/new")
    public ModelAndView titleNew(Title title) {
        ModelAndView mv = new ModelAndView("title/register-title");
        mv.addObject(title);
        return mv;
    }

    @PostMapping("/new")
    public  ModelAndView save(@Valid Title title, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors())
            return titleNew(title);

        titleService.save(title);
        attributes.addFlashAttribute("message", "Título salvo com sucesso!");

        return new ModelAndView("redirect:/titles/new") ;
    }

    @GetMapping
    public ModelAndView search() {
        List<Title> titleList = titleService.findAll();
        ModelAndView mv = new ModelAndView("title/search-title");
        mv.addObject("titleList", titleList);
        return mv;
    }

    @GetMapping("/{code}")
    public ModelAndView edit(@PathVariable("code") Title title) {
        return titleNew(title);
    }

    @DeleteMapping("/{code}")
    public String delete(@PathVariable("code") Title title ,
                         RedirectAttributes attributes) {
        titleService.delete(title);
        attributes.addFlashAttribute("message", "Vinho removido com sucesso");
        return "redirect:/titles";
    }


    @ModelAttribute
    public List<StatusTitle> statusTitleList() {
        return Arrays.asList(StatusTitle.values());
    }


}

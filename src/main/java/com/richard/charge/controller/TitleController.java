package com.richard.charge.controller;

import com.richard.charge.model.StatusTitle;
import com.richard.charge.model.Title;
import com.richard.charge.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/titles")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @GetMapping("/new")
    public ModelAndView wineNew(Title title) {
        ModelAndView mv = new ModelAndView("title/register-title");
        return mv;
    }

    @PostMapping("/new")
    public  ModelAndView save(@Valid Title title, BindingResult result) {

        if (result.hasErrors())
            return wineNew(title);

        titleService.save(title);
        ModelAndView mv = new ModelAndView("redirect:/title/new");
        mv.addObject("message", "Título salvo com sucesso!");

        return mv ;
    }

    @GetMapping
    public ModelAndView search() {
        List<Title> titleList = titleService.findAll();
        ModelAndView mv = new ModelAndView("title/search-title");
        mv.addObject("titles", titleList);
        return mv;
    }


    @ModelAttribute
    public List<StatusTitle> statusTitleList() {
        return Arrays.asList(StatusTitle.values());
    }


}

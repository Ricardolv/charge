package com.richard.charge.controller;

import com.richard.charge.model.StatusTitle;
import com.richard.charge.model.Title;
import com.richard.charge.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class TitleController {

    @Autowired
    private TitleService titleService;

    @GetMapping("/title/new")
    public ModelAndView wineNew(Title title) {
        ModelAndView mv = new ModelAndView("title/Register-title");
        mv.addObject("statusList", StatusTitle.values());
        return mv;
    }

    @PostMapping("/title/new")
    public  ModelAndView save(@Valid Title title, BindingResult result) {

        if (result.hasErrors())
            return wineNew(title);

        titleService.save(title);
        ModelAndView mv = new ModelAndView("redirect:/title/new");
        mv.addObject("message", "Título salvo com sucesso!");

        return mv ;
    }


}

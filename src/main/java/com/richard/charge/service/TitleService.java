package com.richard.charge.service;

import com.richard.charge.model.Title;
import com.richard.charge.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleService {

    @Autowired
    private TitleRepository titleRepository;

    public Title save(Title title) {
        return titleRepository.save(title);
    }

    public List<Title> findAll() {
        return titleRepository.findAll();
    }

    public Title findOne(Long code) {
        return titleRepository.findOne(code);
    }

    public void delete(Title title) {
        titleRepository.delete(title);
    }
}

package com.richard.charge.service;

import com.richard.charge.model.Title;
import com.richard.charge.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TitleService {

    @Autowired
    private TitleRepository titleRepository;

    public Title save(Title title) {
        return titleRepository.save(title);
    }
}
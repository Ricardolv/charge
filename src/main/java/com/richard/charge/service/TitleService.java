package com.richard.charge.service;

import com.richard.charge.model.StatusTitle;
import com.richard.charge.model.Title;
import com.richard.charge.repository.TitleRepository;
import com.richard.charge.repository.filter.TitleFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleService {

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private Environment env;

    public Title save(Title title) {

        try {
            return titleRepository.save(title);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Formato de data inválido");
        }
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

    public String get(Long code) {
        Title title = titleRepository.findOne(code);
        title.setStatus(StatusTitle.RECEIVED);
        titleRepository.save(title);
        return title.getStatus().getDescription();
    }

    public List<Title> search(TitleFilter filter) {
        return titleRepository.findByDescriptionContaining(
                filter.getDescription() == null ? "%" : filter.getDescription());
    }
}

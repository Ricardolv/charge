package com.richard.charge.repository;


import com.richard.charge.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TitleRepository extends JpaRepository<Title, Long> {

    List<Title> findByDescriptionContaining(String description);

}

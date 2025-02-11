package com.bookshore.demo.repositories;

import com.bookshore.demo.models.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<AutorModel, UUID> {

    AutorModel findAutorByName(String title);

}

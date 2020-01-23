package com.br.qualiti.espacoodonto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.br.qualiti.espacoodonto.model.Pacient;

@Repository
public interface PacientRepository extends JpaRepository<Pacient, Long> {

}

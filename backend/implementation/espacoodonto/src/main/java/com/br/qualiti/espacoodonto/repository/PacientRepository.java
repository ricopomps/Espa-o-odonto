package com.br.qualiti.espacoodonto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.qualiti.espacoodonto.model.Pacient;

@Repository
public interface PacientRepository extends JpaRepository<Pacient, Long> {

}

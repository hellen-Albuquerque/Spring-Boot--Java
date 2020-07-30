package com.secretaria.escolaFeliz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.secretaria.escolaFeliz.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    public List<Turma> findAllByDescricaoContainingIgnoreCase (String turma);
}

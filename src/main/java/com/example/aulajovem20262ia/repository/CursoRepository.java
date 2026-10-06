package com.example.aulajovem20262ia.repository;


import com.example.aulajovem20262ia.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Long> {
}

package com.example.aulajovem20262ia.repository;


import com.example.aulajovem20262ia.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long> {

    Optional<Empresa> getEmpresaByCnpj(String cnpj);
    
}

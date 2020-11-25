package com.gabriel.crudDeAlunos.domain.repositoty;


import com.gabriel.crudDeAlunos.domain.model.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Long> {
}

package com.ipiecoles.java.mdd050.repository;
import com.ipiecoles.java.mdd050.model.Manager;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ManagerRepository extends JpaRepository<Manager, Long> {


    @EntityGraph(attributePaths = "equipe")
    Manager findOneWithEquipeById(Long id);
    Manager findByMatricule(String matriculeManager);
}
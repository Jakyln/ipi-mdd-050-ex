package com.ipiecoles.java.mdd050.repository;
import com.ipiecoles.java.mdd050.model.Technicien;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.awt.print.Pageable;
import java.util.List;

public interface TechnicienRepository extends JpaRepository<Technicien, Long> {

    List<Technicien> findByGradeBetween(Integer gradeLower, Integer gradeUpper);
    Slice<Technicien> findTop5ByGrade(Integer grade);
    Technicien findByMatricule(String matriculeTechnicien);
}



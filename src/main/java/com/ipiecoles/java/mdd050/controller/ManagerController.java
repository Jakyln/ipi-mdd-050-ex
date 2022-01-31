package com.ipiecoles.java.mdd050.controller;
import com.ipiecoles.java.mdd050.model.Manager;
import com.ipiecoles.java.mdd050.model.Technicien;
import com.ipiecoles.java.mdd050.repository.ManagerRepository;
import com.ipiecoles.java.mdd050.repository.TechnicienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    private TechnicienRepository technicienRepository;

    @Autowired
    private ManagerRepository managerRepository;
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{idManager}/equipe/{idTechnicien}/remove"
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeTechnicienEquipe(
            @PathVariable Long idManager,
            @PathVariable Long idTechnicien
    ){
        Technicien technicien = technicienRepository.findById(idTechnicien).get();
        technicien.setManager(null);
        technicienRepository.save(technicien);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{idManager}/equipe/{matriculeTechnicien}/add",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Technicien addTechnicienToEquipe(
            @PathVariable Long idManager,
            @PathVariable String matriculeTechnicien
    ){
        Technicien technicien = technicienRepository.findByMatricule(matriculeTechnicien);
        Manager manager = managerRepository.findById(idManager).get();
        technicien.setManager(manager);
        return technicienRepository.save(technicien);
    }

}
package com.ipiecoles.java.mdd050.controller;
import com.ipiecoles.java.mdd050.model.Manager;
import com.ipiecoles.java.mdd050.model.Technicien;
import com.ipiecoles.java.mdd050.repository.ManagerRepository;
import com.ipiecoles.java.mdd050.repository.TechnicienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/techniciens")
public class TechnicienController {

    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private TechnicienRepository technicienRepository;
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{idTechnicien}/manager/{matriculeManager}/add"
    )
    public Manager addManagerToTechnicien(
            @PathVariable Long idTechnicien,
            @PathVariable String matriculeManager
    ){
        Technicien technicien = technicienRepository.findById(idTechnicien).get();
        Manager manager = managerRepository.findByMatricule(matriculeManager);
        technicien.setManager(manager);
        technicienRepository.save(technicien);
        return manager;
    }

}
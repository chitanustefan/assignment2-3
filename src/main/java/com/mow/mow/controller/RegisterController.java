package com.mow.mow.controller;


import com.mow.mow.dao.PersoanaService;
import com.mow.mow.entities.Persoana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController {

    @Autowired
   public PersoanaService ps = new PersoanaService();

    @PostMapping("/register")
    void addUser(@RequestBody Persoana persoana) {
        System.out.println(persoana.getEmail() + " " + persoana.getName());
        ps.persist(persoana);
    }

    @PostMapping("/login")
    public Persoana loginProcess(@RequestBody Persoana persoana) {
        Persoana pers = ps.login(persoana.getEmail(), persoana.getPassword());
        if(pers.getRole().equals("user")) {
            System.out.println("Logare user "+ pers.getIdUser());
            return pers;
        }else {
            if(pers.getRole().equals("admin")) {
                System.out.println("Logare admin "+ pers.getIdUser());
                return pers;
            }
            return pers;
        }
    }
}

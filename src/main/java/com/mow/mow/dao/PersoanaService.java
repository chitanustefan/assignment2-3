package com.mow.mow.dao;

import com.mow.mow.entities.Persoana;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersoanaService {

    private static PersoanDao persoanDao;

    public PersoanaService() {
        persoanDao = new PersoanDao();
    }

    public void persist(Persoana entity) {
        persoanDao.connection.openCurrentSessionwithTransaction();
        persoanDao.persist(entity);
        persoanDao.connection.closeCurrentSessionwithTransaction();
    }

    public void update(Persoana entity) {
        persoanDao.connection.openCurrentSessionwithTransaction();
        persoanDao.update(entity);
        persoanDao.connection.closeCurrentSessionwithTransaction();
    }

    public Persoana findById(String id) {
        persoanDao.connection.openCurrentSession();
        Persoana persoana = persoanDao.findById(id);
        persoanDao.connection.closeCurrentSession();
        return persoana;
    }

    public Persoana login(String email, String pass) {
        List<Persoana> list = findAll();
        Persoana u1 = new Persoana();
        boolean notfound=true;
        for (Persoana u : list){ ;
            if (u.getEmail().equals(email) && u.getPassword().equals(pass)){
                notfound = false;
                u1.setRole(u.getRole());
                u1.setPassword(pass);
                u1.setAdresa(u.getAdresa());
                u1.setEmail(email);
                u1.setTelefon(u.getTelefon());
                u1.setIdUser(u.getIdUser());
                u1.setName(u.getName());
                u1.setRestaurant(0);
            }
        }
        if (!notfound)
            System.out.println("Logare cu succes ");
        else System.out.println("Email invalid");
        return u1;
    }

    public void delete(String id) {
        persoanDao.connection.openCurrentSessionwithTransaction();
        Persoana user = persoanDao.findById(id);
        persoanDao.delete(user);
        persoanDao.connection.closeCurrentSessionwithTransaction();
    }

    public List<Persoana> findAll() {
        persoanDao.connection.openCurrentSession();
        List<Persoana> users = persoanDao.findAll();
        persoanDao.connection.closeCurrentSession();
        return users;
    }

    public void deleteAll() {
        persoanDao.connection.openCurrentSessionwithTransaction();
        persoanDao.deleteAll();
        persoanDao.connection.closeCurrentSessionwithTransaction();
    }

    public PersoanDao persoanDao() {
        return persoanDao;
    }

}


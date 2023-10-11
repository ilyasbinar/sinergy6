package org.example.service;

import org.example.model.Departement;
import org.example.repository.DepartementRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DepartementService {
    private final DepartementRepository departementRepository;

    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    public void initiateData() {

        if(departementRepository.count()==0){
            departementRepository.save(new Departement().setName("Sales & Marketing"));
            departementRepository.save(new Departement().setName("Human Resources"));
            departementRepository.save(new Departement().setName("Information & Technology"));
            departementRepository.save(new Departement().setName("Purchasing"));
            departementRepository.save(new Departement().setName("Accounting"));
            departementRepository.save(new Departement().setName("General Affair"));
        }
    }

    public List<Departement> getDepartements() {
        return departementRepository.findAll();
    }

    public Departement getById(int departementSelected) {
        Optional<Departement> departementOptional =  departementRepository.findById(departementSelected);
        if(departementOptional.isPresent()){
            return departementOptional.get();
        }
        throw new RuntimeException();
    }
}

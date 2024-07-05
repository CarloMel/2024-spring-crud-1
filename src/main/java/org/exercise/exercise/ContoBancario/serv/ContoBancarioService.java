package org.exercise.exercise.ContoBancario.serv;

import java.util.List;
import java.util.Optional;

import org.exercise.exercise.ContoBancario.pojo.ContoBancario;
import org.exercise.exercise.ContoBancario.repo.ContoBancarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContoBancarioService {

    @Autowired
    private ContoBancarioRepo contoBancarioRepo;

    //READ ALL
    public List<ContoBancario> getAllContiBancari() {

        return contoBancarioRepo.findAll();
    }
    // READ ONE BY ID
    public Optional<ContoBancario> getContoBancarioById(int id) {

        return contoBancarioRepo.findById(id);
    }

    //CREATE - UPDATE
    public void save(ContoBancario conto) {

        contoBancarioRepo.save(conto);
    }

    public void delete(ContoBancario conto) {

        contoBancarioRepo.delete(conto);
    }
}

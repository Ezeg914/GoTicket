package com.GoTicket.GoTicket.services;

import com.GoTicket.GoTicket.models.Passanger;
import com.GoTicket.GoTicket.repositories.PassangerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class PassangerService implements BaseService<Passanger> {

    private PassangerRepository passangerRepository;

    public PassangerService(PassangerRepository passangerRepository) {
        this.passangerRepository = passangerRepository;
    }


    @Override
    @Transactional
    public List<Passanger> findAll() throws Exception {
        try {
            List<Passanger> models = passangerRepository.findAll();
            return models;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Passanger findById(Long id) throws Exception {
        try {
            Optional<Passanger> modelOptional = passangerRepository.findById(id);
            return modelOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Passanger save(Passanger model) throws Exception {
        try {
            model = passangerRepository.save(model);
            return model;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Passanger update(Long id, Passanger model) throws Exception {
        try {
            Optional<Passanger> modelOptional = passangerRepository.findById(id);
            Passanger passanger = modelOptional.get();
            passanger = passangerRepository.save(passanger);
            return passanger;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(passangerRepository.existsById(id)) {
                passangerRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.NaveEspacialRepository;
import com.luv2code.springboot.cruddemo.entity.NaveEspacial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NaveEspacialServiceImpl implements NaveEspacialService {

    private NaveEspacialRepository naveEspacialRepository;

    @Autowired
    public NaveEspacialServiceImpl(NaveEspacialRepository naveEspacialRepository) {
        this.naveEspacialRepository = naveEspacialRepository;
    }

    @Override
    public List<NaveEspacial> findAll() {
        return naveEspacialRepository.findAll();
    }

    @Override
    public NaveEspacial findById(int id) {
        Optional<NaveEspacial> result = naveEspacialRepository.findById(id);
        NaveEspacial naveEspacial = null;

        if (result.isPresent()) {
            naveEspacial = result.get();
        } else {
            throw new RuntimeException("No se encontró la nave espacial con id - " + id);
        }
        return naveEspacial;
    }

    @Override
    public NaveEspacial save(NaveEspacial naveEspacial) {
        return naveEspacialRepository.save(naveEspacial);
    }

    @Override
    public void deleteById(int id) {
        naveEspacialRepository.deleteById(id);
    }
}
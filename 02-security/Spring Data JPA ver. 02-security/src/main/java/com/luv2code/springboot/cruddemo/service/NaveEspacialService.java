package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.NaveEspacial;
import java.util.List;

public interface NaveEspacialService {
    List<NaveEspacial> findAll();
    NaveEspacial findById(int id);
    NaveEspacial save(NaveEspacial naveEspacial);
    void deleteById(int id);
}
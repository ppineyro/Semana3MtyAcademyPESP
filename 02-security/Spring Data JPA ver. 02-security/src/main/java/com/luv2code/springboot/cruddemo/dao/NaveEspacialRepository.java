package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.NaveEspacial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NaveEspacialRepository extends JpaRepository<NaveEspacial, Integer> {

    // that's it ... no need to write any code LOL!

}

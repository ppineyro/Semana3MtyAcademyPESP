package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.NaveEspacial;
import com.luv2code.springboot.cruddemo.service.NaveEspacialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/naves")
public class NaveEspacialRestController {

    private NaveEspacialService naveEspacialService;

    @Autowired
    public NaveEspacialRestController(NaveEspacialService naveEspacialService) {
        this.naveEspacialService = naveEspacialService;
    }

    @GetMapping("")
    public List<NaveEspacial> findAll() {
        return naveEspacialService.findAll();
    }

    @GetMapping("/{naveId}")
    public NaveEspacial getNaveEspacial(@PathVariable int naveId) {
        NaveEspacial naveEspacial = naveEspacialService.findById(naveId);
        if (naveEspacial == null) {
            throw new RuntimeException("Nave espacial no encontrada con id - " + naveId);
        }
        return naveEspacial;
    }

    @PostMapping("")
    public NaveEspacial addNaveEspacial(@RequestBody NaveEspacial naveEspacial) {
        //fuerza el id a 0 para que jpa sepa que es una insercion
        naveEspacial.setId(0);
        return naveEspacialService.save(naveEspacial);
    }

    @PutMapping("")
    public NaveEspacial updateNaveEspacial(@RequestBody NaveEspacial naveEspacial) {
        return naveEspacialService.save(naveEspacial);
    }

    @PatchMapping("/{naveId}")
    public NaveEspacial patchNaveEspacial(@PathVariable int naveId, @RequestBody NaveEspacial naveIncompleta) {
        // busca registro original
        NaveEspacial naveExistente = naveEspacialService.findById(naveId);
        if (naveExistente == null) {
            throw new RuntimeException("Nave espacial no encontrada con id - " + naveId);
        }
        
        // actualiza solo los campos que el cliente manda
        if (naveIncompleta.getNombre() != null) {
            naveExistente.setNombre(naveIncompleta.getNombre());
        }
        if (naveIncompleta.getModelo() != null) {
            naveExistente.setModelo(naveIncompleta.getModelo());
        }
        if (naveIncompleta.getCapacidadTripulacion() != 0) {
            naveExistente.setCapacidadTripulacion(naveIncompleta.getCapacidadTripulacion());
        }
        
        // guadra el objeto combinado
        return naveEspacialService.save(naveExistente);
    }

    @DeleteMapping("/{naveId}")
    public String deleteNaveEspacial(@PathVariable int naveId) {
        NaveEspacial tempNave = naveEspacialService.findById(naveId);
        if (tempNave == null) {
            throw new RuntimeException("Nave espacial no encontrada con id - " + naveId);
        }
        naveEspacialService.deleteById(naveId);
        return "Nave espacial eliminada con id - " + naveId;
    }
}
package com.oocl.Spring_flywaydb.controller.oneToOne;

import com.oocl.Spring_flywaydb.controller.dto.oneToOne.KlassDTO;
import com.oocl.Spring_flywaydb.entities.oneToOne.Klass;
import com.oocl.Spring_flywaydb.repositories.oneToOne.KlassReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class KlassController {
    private KlassReository klassReository;
    @Autowired
    KlassController(KlassReository klassReository){
        this.klassReository = klassReository;
    }
    @GetMapping("/Klass")
    public List<Klass> getAllKlass(){
        return klassReository.findAll();
    }

    @Transactional
    @PostMapping("/Klass")
    public Klass save(@RequestBody Klass klass){
        klass.getLeader().setKlass(klass);
        return klassReository.save(klass);
    }

    @Transactional
    @GetMapping("/Klass/{id}")
    public KlassDTO getById(@PathVariable("id") Long id ){
        Klass one = klassReository.findById(id).get();
        return new KlassDTO(one);
    }
    @Transactional
    @PutMapping("/Klass")
    public ResponseEntity update(@RequestBody Klass klass){
            if(klass.getLeader().getKlass()==null){
                klass.getLeader().setKlass(klass);
            }
            klassReository.save(klass);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    @DeleteMapping("/Klass/{id}")
    public Klass delete(@PathVariable("id")Long id){
        Klass one = klassReository.findById(id).get();
        klassReository.delete(one);
        return one;
    }
}

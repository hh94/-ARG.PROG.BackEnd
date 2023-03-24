package com.portafolioAP.hmh.Controller;

import com.portafolioAP.hmh.Dto.dtoAcerca;
import com.portafolioAP.hmh.Entity.Acerca;
import com.portafolioAP.hmh.Security.Controller.Mensaje;
import com.portafolioAP.hmh.Service.SAcerca;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/acercaDe")
@CrossOrigin(origins = "https://fe-argprog.firebaseapp.com")
//@CrossOrigin(origins = "https://fe-argprog.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class CAcerca {
    @Autowired
    SAcerca sAcerca;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Acerca>> list() {
        List<Acerca> list = sAcerca.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }   
    
        @GetMapping("/detail/{id}")
        public ResponseEntity<Acerca> getById(@PathVariable("id") int id){
            if(!sAcerca.existsById(id))
                return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
            Acerca acerca = sAcerca.getOne(id).get();
            return new ResponseEntity(acerca, HttpStatus.OK);
        }
        
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> delete(@PathVariable("id") int id) {
            if (!sAcerca.existsById(id)) {
                return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
            }
            sAcerca.delete(id);
            return new ResponseEntity(new Mensaje("eliminado"), HttpStatus.OK);
        }


        @PostMapping("/create")
        public ResponseEntity<?> create(@RequestBody dtoAcerca dtoacerca){
            if(StringUtils.isBlank(dtoacerca.getNombreA()))
                return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
            if(sAcerca.existsByNombreA(dtoacerca.getNombreA()))
                return new ResponseEntity(new Mensaje("Ya existe."), HttpStatus.BAD_REQUEST);

            Acerca acerca = new Acerca(dtoacerca.getNombreA(), dtoacerca.getApellidoA(), dtoacerca.getProfesionA(), dtoacerca.getSobreTiA());
            sAcerca.save(acerca);

            return new ResponseEntity(new Mensaje("Agregado."), HttpStatus.OK);
        }
    
    
        @PutMapping("/update/{id}")
        public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcerca dtoacerca){
            //validamos si existe el id
            if(!sAcerca.existsById(id))
                return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
            //compara nombres de experiencias
            if(sAcerca.existsByNombreA(dtoacerca.getNombreA()) && sAcerca.getNombreA(dtoacerca.getNombreA()).get().getId() != id)
                return new ResponseEntity(new Mensaje("Ya existe."), HttpStatus.BAD_REQUEST);
            //no puede estar vacio
            if(StringUtils.isBlank(dtoacerca.getNombreA()))
                return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
            
            Acerca acerca = sAcerca.getOne(id).get();
            acerca.setNombreA(dtoacerca.getNombreA());
            acerca.setApellidoA((dtoacerca.getApellidoA()));
            acerca.setProfesionA((dtoacerca.getProfesionA()));
            acerca.setSobreTiA((dtoacerca.getSobreTiA()));
            
            sAcerca.save(acerca);
            return new ResponseEntity(new Mensaje("Actualizado."), HttpStatus.OK);
        }
}
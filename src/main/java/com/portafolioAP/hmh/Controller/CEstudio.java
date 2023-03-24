package com.portafolioAP.hmh.Controller;

import com.portafolioAP.hmh.Dto.dtoEstudio;
import com.portafolioAP.hmh.Entity.Estudio;
import com.portafolioAP.hmh.Security.Controller.Mensaje;
import com.portafolioAP.hmh.Service.SEstudio;
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
@RequestMapping("/estu")
@CrossOrigin(origins = "https://fe-ap23.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class CEstudio {
    @Autowired
    SEstudio sEstudio;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Estudio>> list() {
        List<Estudio> list = sEstudio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }   
    
        @GetMapping("/detail/{id}")
        public ResponseEntity<Estudio> getById(@PathVariable("id") int id){
            if(!sEstudio.existsById(id))
                return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
            Estudio estudio = sEstudio.getOne(id).get();
            return new ResponseEntity(estudio, HttpStatus.OK);
        }
        
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> delete(@PathVariable("id") int id) {
            if (!sEstudio.existsById(id)) {
                return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
            }
            sEstudio.delete(id);
            return new ResponseEntity(new Mensaje("eliminado"), HttpStatus.OK);
        }


        @PostMapping("/create")
        public ResponseEntity<?> create(@RequestBody dtoEstudio dtoest){
            if(StringUtils.isBlank(dtoest.getNombreS()))
                return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
            if(sEstudio.existsByNombreS(dtoest.getNombreS()))
                return new ResponseEntity(new Mensaje("Ya existe."), HttpStatus.BAD_REQUEST);

            Estudio estudio = new Estudio(dtoest.getNombreS(), dtoest.getDescripcionS());
            sEstudio.save(estudio);

            return new ResponseEntity(new Mensaje("Agregado."), HttpStatus.OK);
        }
    
    
        @PutMapping("/update/{id}")
        public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEstudio dtoest){
            //validamos si existe el id
            if(!sEstudio.existsById(id))
                return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
            //compara nombres de experiencias
            if(sEstudio.existsByNombreS(dtoest.getNombreS()) && sEstudio.getNombreS(dtoest.getNombreS()).get().getId() != id)
                return new ResponseEntity(new Mensaje("Ya existe."), HttpStatus.BAD_REQUEST);
            //no puede estar vacio
            if(StringUtils.isBlank(dtoest.getNombreS()))
                return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
            
            Estudio estudio = sEstudio.getOne(id).get();
            estudio.setNombreS(dtoest.getNombreS());
            estudio.setDescripcionS((dtoest.getDescripcionS()));
            
            sEstudio.save(estudio);
            return new ResponseEntity(new Mensaje("Actualizado."), HttpStatus.OK);
        }
}

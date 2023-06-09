package com.portafolioAP.hmh.Controller;

import com.portafolioAP.hmh.Dto.dtoProyecto;
import com.portafolioAP.hmh.Entity.Proyecto;
import com.portafolioAP.hmh.Security.Controller.Mensaje;
import com.portafolioAP.hmh.Service.SProyecto;
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
@RequestMapping("/pro")
@CrossOrigin(origins = "https://fe-ap23.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {
    @Autowired
    SProyecto sProyecto;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }   
    
        @GetMapping("/detail/{id}")
        public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
            if(!sProyecto.existsById(id))
                return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
            Proyecto proyecto = sProyecto.getOne(id).get();
            return new ResponseEntity(proyecto, HttpStatus.OK);
        }
        
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> delete(@PathVariable("id") int id) {
            if (!sProyecto.existsById(id)) {
                return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
            }
            sProyecto.delete(id);
            return new ResponseEntity(new Mensaje("eliminado"), HttpStatus.OK);
        }


        @PostMapping("/create")
        public ResponseEntity<?> create(@RequestBody dtoProyecto dtopro){
            if(StringUtils.isBlank(dtopro.getNombreP())){
                return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);}
            if(sProyecto.existsByNombreP(dtopro.getNombreP())){
                return new ResponseEntity(new Mensaje("Ya existe."), HttpStatus.BAD_REQUEST);}

            Proyecto proyecto = new Proyecto(dtopro.getNombreP(), dtopro.getDescripcionP());
            sProyecto.save(proyecto);

            return new ResponseEntity(new Mensaje("Agregado."), HttpStatus.OK);
        }
    
    
        @PutMapping("/update/{id}")
        public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtopro){
            //validamos si existe el id
            if(!sProyecto.existsById(id))
                return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
            //compara nombres de experiencias
            if(sProyecto.existsByNombreP(dtopro.getNombreP()) && sProyecto.getNombreP(dtopro.getNombreP()).get().getId() != id)
                return new ResponseEntity(new Mensaje("Ya existe."), HttpStatus.BAD_REQUEST);
            //no puede estar vacio
            if(StringUtils.isBlank(dtopro.getNombreP()))
                return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
            
            Proyecto proyecto = sProyecto.getOne(id).get();
            proyecto.setNombreP(dtopro.getNombreP());
            proyecto.setDescripcionP((dtopro.getDescripcionP()));
            
            sProyecto.save(proyecto);
            return new ResponseEntity(new Mensaje("Actualizado."), HttpStatus.OK);
        }
}

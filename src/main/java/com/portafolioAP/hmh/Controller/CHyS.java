package com.portafolioAP.hmh.Controller;

import com.portafolioAP.hmh.Dto.dtoHyS;
import com.portafolioAP.hmh.Entity.HyS;
import com.portafolioAP.hmh.Security.Controller.Mensaje;
import com.portafolioAP.hmh.Service.SHyS;
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
@RequestMapping("/hys")
@CrossOrigin(origins = "https://fe-ap23.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class CHyS {
    @Autowired
    SHyS sHyS;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<HyS>> list() {
        List<HyS> list = sHyS.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }   
    
        @GetMapping("/detail/{id}")
        public ResponseEntity<HyS> getById(@PathVariable("id") int id){
            if(!sHyS.existsById(id))
                return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
            HyS hys = sHyS.getOne(id).get();
            return new ResponseEntity(hys, HttpStatus.OK);
        }
        
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> delete(@PathVariable("id") int id) {
            if (!sHyS.existsById(id)) {
                return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
            }
            sHyS.delete(id);
            return new ResponseEntity(new Mensaje("eliminado"), HttpStatus.OK);
        }


        @PostMapping("/create")
        public ResponseEntity<?> create(@RequestBody dtoHyS dtohys){
            if(StringUtils.isBlank(dtohys.getNombreH())){
                return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
            }
            if(sHyS.existsByNombreH(dtohys.getNombreH())){
                return new ResponseEntity(new Mensaje("Ya existe."), HttpStatus.BAD_REQUEST);
            }

            HyS hys = new HyS(dtohys.getNombreH(), dtohys.getPorcentajeH());
            sHyS.save(hys);
            
            return new ResponseEntity(new Mensaje("Agregado."), HttpStatus.OK);
        }
    
    
        @PutMapping("/update/{id}")
        public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHyS dtohys){
            //validamos si existe el id
            if(!sHyS.existsById(id))
                return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
            //compara nombres de experiencias
            if(sHyS.existsByNombreH(dtohys.getNombreH()) && sHyS.getNombreH(dtohys.getNombreH()).get().getId() != id)
                return new ResponseEntity(new Mensaje("Ya existe."), HttpStatus.BAD_REQUEST);
            //no puede estar vacio
            if(StringUtils.isBlank(dtohys.getNombreH()))
                return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
            
            HyS hys = sHyS.getOne(id).get();
            hys.setNombreH(dtohys.getNombreH());
            hys.setPorcentajeH(dtohys.getPorcentajeH());
            
            sHyS.save(hys);
            return new ResponseEntity(new Mensaje("Actualizado."), HttpStatus.OK);
        }
}
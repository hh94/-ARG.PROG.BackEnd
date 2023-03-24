  package com.portafolioAP.hmh.Controller;

  
import Interface.IPersonaService;
import com.portafolioAP.hmh.Entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
  
  
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://fe-argprog.web.app")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada.";
    }
    
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada.";
    }
    
    
    //  URL:PUERTO/personas/editar/4/nombre & apellido & img
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido ){
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        
        ipersonaService.savePersona(persona);
        return persona;
        
    }
    
        @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
    
}
   
        /*    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaService.list();
         return new ResponseEntity(list, HttpStatus.OK);
    }   
    
        @GetMapping("/detail/{id}")
        public ResponseEntity<Persona> getById(@PathVariable("id") int id){
            if(!personaService.existsById(id))
                return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
            Persona persona = personaService.getOne(id).get();
            return new ResponseEntity(persona, HttpStatus.OK);
        }
     
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> delete(@PathVariable("id") int id) {
            if (!personaService.existsById(id)) {
                return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
            }
            personaService.delete(id);
            return new ResponseEntity(new Mensaje("eliminado"), HttpStatus.OK);
        }


        @PostMapping("/create")
        public ResponseEntity<?> create(@RequestBody dtoEstudio dtoest){
            if(StringUtils.isBlank(dtoest.getNombreS()))
                return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
            if(personaService.existsByNombreS(dtoest.getNombreS()))
                return new ResponseEntity(new Mensaje("Ya existe."), HttpStatus.BAD_REQUEST);

            Estudio estudio = new Estudio(dtoest.getNombreS(), dtoest.getDescripcionS());
            personaService.save(estudio);

            return new ResponseEntity(new Mensaje("Agregado."), HttpStatus.OK);
        }

    
        @PutMapping("/update/{id}")
        public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
            //validamos si existe el id
            if(!personaService.existsById(id))
                return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
            //compara nombres de experiencias
            if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getNombre(dtopersona.getNombre()).get().getId() != id)
                 return new ResponseEntity(new Mensaje("Ya existe."), HttpStatus.BAD_REQUEST);
            //no puede estar vacio
            if(StringUtils.isBlank(dtopersona.getNombre()))
                return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
            
            Persona persona = personaService.getOne(id).get();
            persona.setNombre(dtopersona.getNombre());
            
            persona.setApellido(dtopersona.getApellido());
            persona.setProfesion(dtopersona.getProfesion());
            persona.setSobreTi(dtopersona.getSobreTi());
            
            personaService.save(persona);
            return new ResponseEntity(new Mensaje("Actualizado."), HttpStatus.OK);
        }
}
    */
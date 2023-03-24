package com.portafolioAP.hmh.Service;

import com.portafolioAP.hmh.Entity.Acerca;
import com.portafolioAP.hmh.Repository.RAcerca;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SAcerca { 
    
    @Autowired RAcerca rAcerca;
    public List<Acerca> list(){
        return rAcerca.findAll();
    }
    
    public Optional<Acerca> getOne(int id){
        return rAcerca.findById(id);
    }
    
    public Optional<Acerca> getNombreA(String nombreA){
        return rAcerca.findByNombreA(nombreA);
    }
    
    public void save(Acerca acerca){
        rAcerca.save(acerca);
    }
    
    public void delete(int id){
        rAcerca.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rAcerca.existsById(id);
    }
    
    public boolean existsByNombreA(String nombreA){
        return rAcerca.existsByNombreA(nombreA);
    }
    
}
package com.portafolioAP.hmh.Service;

import com.portafolioAP.hmh.Entity.Estudio;
import com.portafolioAP.hmh.Repository.REstudio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SEstudio {
    
    @Autowired
    REstudio rEstudio;
    public List<Estudio> list(){
        return rEstudio.findAll();
    }
    
    public Optional<Estudio> getOne(int id){
        return rEstudio.findById(id);
    }
    
    public Optional<Estudio> getNombreS(String nombreS){
        return rEstudio.findByNombreS(nombreS);
    }
    
    public void save(Estudio est){
        rEstudio.save(est);
    }
    
    public void delete(int id){
        rEstudio.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEstudio.existsById(id);
    }
    
    public boolean existsByNombreS(String nombreS){
        return rEstudio.existsByNombreS(nombreS);
    }
    
}

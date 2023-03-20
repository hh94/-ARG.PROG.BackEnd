package com.portafolioAP.hmh.Service;

import com.portafolioAP.hmh.Entity.HyS;
import com.portafolioAP.hmh.Repository.RHyS;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Transactional
public class SHyS {
    
    @Autowired
    RHyS rHyS;
    
    public List<HyS> list(){
        return rHyS.findAll();
    }
    
    public Optional<HyS> getOne(int id){
        return rHyS.findById(id);
    }
    
    public Optional<HyS> getNombreH(String nombreH){
        return rHyS.findByNombreH(nombreH);
    }
    
    public void save(HyS hys){
        rHyS.save(hys);
    }
    
    public void delete(int id){
        rHyS.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHyS.existsById(id);
    }
    
    public boolean existsByNombreH(String nombreH){
        return rHyS.existsByNombreH(nombreH);
    }
    
}


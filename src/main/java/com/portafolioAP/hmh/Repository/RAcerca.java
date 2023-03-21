package com.portafolioAP.hmh.Repository;

import com.portafolioAP.hmh.Entity.Acerca;
import com.portafolioAP.hmh.Entity.Estudio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RAcerca  extends JpaRepository<Acerca, Integer>{
    public Optional<Estudio> findByNombreA(String nombreA);
    public boolean existsByNombreA(String nombreA);
}

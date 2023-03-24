package com.portafolioAP.hmh.Repository;

import com.portafolioAP.hmh.Entity.Acerca;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RAcerca  extends JpaRepository<Acerca, Integer>{
    public Optional<Acerca> findByNombreA(String nombreA);
    public boolean existsByNombreA(String nombreA);
}

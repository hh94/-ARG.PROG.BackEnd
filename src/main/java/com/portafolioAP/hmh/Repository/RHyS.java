package com.portafolioAP.hmh.Repository;

import com.portafolioAP.hmh.Entity.HyS;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RHyS  extends JpaRepository<HyS, Integer>{
    public Optional<HyS> findByNombreH(String nombreH);
    public boolean existsByNombreH(String nombreH);
}

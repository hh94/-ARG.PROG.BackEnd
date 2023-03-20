package com.portafolioAP.hmh.Repository;

import com.portafolioAP.hmh.Entity.Estudio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface REstudio extends JpaRepository<Estudio, Integer>{
    public Optional<Estudio> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
}
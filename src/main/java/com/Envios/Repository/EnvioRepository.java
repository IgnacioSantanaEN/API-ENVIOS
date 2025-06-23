package com.Envios.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Envios.Models.Envio;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Integer>{

}

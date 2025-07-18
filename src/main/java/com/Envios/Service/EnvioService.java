package com.Envios.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Envios.DTO.EnvioDTO;
import com.Envios.Models.Envio;
import com.Envios.Repository.EnvioRepository;

@Service
public class EnvioService {
    @Autowired
    private EnvioRepository envioRepository;

    public List<Envio> getAllEnvios(){
        return envioRepository.findAll();
    }

    public Envio getEnvioById(Integer id){
        return envioRepository.findById(id).orElse(null);
    }

    public Envio CreateEnvio(Envio envio){
        return envioRepository.save(envio);
    }

    public Envio updateEnvio(Integer id, Envio envio){
        Envio existente = envioRepository.findById(id).orElse(null);

        if(existente != null){
            existente.setDireccionDestino(envio.getDireccionDestino());
            existente.setEstado(envio.getEstado());
            existente.setIdVenta(envio.getIdVenta());

            return envioRepository.save(existente);
        }

        return null;
    }
    public void eliminarEnvio(Integer id){
        envioRepository.deleteById(id);
    }

    public EnvioDTO toDTO(Envio envio) {
            if (envio == null) return null;

            EnvioDTO dto = new EnvioDTO(
            envio.getIdEnvio(),
            envio.getIdVenta(),
            envio.getDireccionEnvio(),
            envio.getEstadoEnvio(),
            envio.getDireccionDestino(),
            envio.getEstado(),
            "http://localhost:8090/api/ventas/" + envio.getIdVenta()
            );

        return dto;
    }
}

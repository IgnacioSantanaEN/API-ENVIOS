package com.Envios.Mapper;

import com.Envios.DTO.EnvioDTO;
import com.Envios.Models.Envio;

public class EnvioMapper {
    public static EnvioDTO toDTO(Envio envio) {
        if (envio == null) return null;

        EnvioDTO dto = new EnvioDTO(
        envio.getIdEnvio(),
        "http://localhost:8083/api/envios/" + envio.getIdEnvio()
    );

    return dto;
    }

    public static Envio toModel(EnvioDTO dto) {
        if (dto == null) return null;

        Envio envio = new Envio();
        envio.setIdEnvio(dto.getIdEnvio());
        return envio;
    }
    
}

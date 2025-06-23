package com.Envios.Mapper;

import com.Envios.DTO.EnvioDTO;
import com.Envios.Models.Envio;

public class EnvioMapper {
    public static EnvioDTO toDTO(Envio envio) {
        if (envio == null) return null;

        return new EnvioDTO(
                envio.getIdEnvio(),
                envio.getEstadoEnvio(),
                envio.getDireccionDestino()
        );
    }

    public static Envio toModel(EnvioDTO dto) {
        if (dto == null) return null;

        Envio envio = new Envio();
        envio.setIdEnvio(dto.getIdEnvio());
        envio.setEstadoEnvio(dto.getEstadoEnvio());
        envio.setDireccionDestino(dto.getDireccionDestino());
        return envio;
    }
    
}

package com.Envios.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioDTO {
    private Integer idEnvio;
    private Integer idVenta;
    private String direccionEnvio;
    private String estadoEnvio;
    private String direccionDestino;
    private String estado;
    private String link;
}

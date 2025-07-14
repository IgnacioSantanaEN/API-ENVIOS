package com.Envios.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "envios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_envio")
    private Integer idEnvio;

    @Column(name = "id_venta")
    private Integer idVenta;

    @Column(name = "direccion_envio")
    private String direccionEnvio;

    @Column(name = "estado_envio")
    private String estadoEnvio;

    @Column(name = "direccion_destino")
    private String direccionDestino;

    private String estado;
}

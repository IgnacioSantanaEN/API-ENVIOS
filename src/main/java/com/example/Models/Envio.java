package com.example.Models;

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
    private Integer idEnvio;
    private Integer idVenta;
    private String direccionDestino;
    private String estado;
}

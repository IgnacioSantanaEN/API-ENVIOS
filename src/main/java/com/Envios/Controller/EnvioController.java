package com.Envios.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Envios.DTO.EnvioDTO;
import com.Envios.Models.Envio;
import com.Envios.Service.EnvioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/envios")
public class EnvioController {
    @Autowired
    private EnvioService service;
    
    @GetMapping
    public ResponseEntity<?> obtenerEnvios(){
        List<EnvioDTO> envios = service.getAllEnvios().stream()
        .map(service::toDTO)
        .toList();;

        if (envios.isEmpty()) {
            return ResponseEntity.ok(new Mensaje("No se han encontrado envíos"));
        }

        return ResponseEntity.ok(envios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEnvioById(@PathVariable Integer id) {
        Envio envio = service.getEnvioById(id);

        if (envio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new Mensaje("id de envio no encontrado: " + id));
        }

        return ResponseEntity.ok(envio);
    }

    @PostMapping
    public ResponseEntity<?> createEnvio(@RequestBody Envio envio) {
        Envio nuevo = service.CreateEnvio(envio);

        if (nuevo == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Mensaje("Error al crear el envio"));    
        }

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(service.toDTO(nuevo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEnvio(@PathVariable Integer id, @RequestBody Envio envio) {
        Envio actualizado = service.updateEnvio(id, envio);
        if (actualizado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new Mensaje("No se encontro el Envio con id" + id));
        }
        return ResponseEntity.ok(service.toDTO(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEnvio(@PathVariable Integer id) {
        Envio envio = service.getEnvioById(id);
        if (envio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new Mensaje("No se encontró el envío con id: " + id));
        }

        service.eliminarEnvio(id);
        return ResponseEntity.ok(new Mensaje("Envío eliminado correctamente"));
    }

    static class Mensaje {
        private String mensaje;

        public Mensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }
    }
}

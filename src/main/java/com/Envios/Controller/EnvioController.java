package com.Envios.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private EnvioService envioService;

    @GetMapping("/")
    public List<Envio> getAllEnvios() {
        return envioService.getAllEnvios();
    }
    
    @GetMapping("/{id}")
    public Envio getEnvioById(@PathVariable Integer id) {
        return envioService.getEnvioById(id);
    }

    @PostMapping
    public Envio createEnvio(@RequestBody Envio envio) {
        return envioService.CreateEnvio(envio);
    }

    @PutMapping("/{id}")
    public Envio updateEnvio(@PathVariable Integer id, @RequestBody Envio envio) {
        return envioService.updateEnvio(id, envio);
    }
    @DeleteMapping("/{id}")
    public void deleteEnvio(@PathVariable Integer id) {
        envioService.eliminarEnvio(id);
    }
}

package com.envios;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Envios.Models.Envio;
import com.Envios.Repository.EnvioRepository;
import com.Envios.Service.EnvioService;

public class EnviosServiceTest {

    @Mock
    private EnvioRepository envioRepository;

    @InjectMocks
    private EnvioService envioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEnvioByIdFound() {
        Envio envio = new Envio();
        envio.setIdEnvio(1);
        envio.setDireccionDestino("Calle Mock");

        when(envioRepository.findById(1)).thenReturn(Optional.of(envio));

        Envio resultado = envioService.getEnvioById(1);

        assertNotNull(resultado);
        assertEquals("Calle Mock", resultado.getDireccionDestino());
        verify(envioRepository, times(1)).findById(1);
    }

    @Test
    void testGetEnvioByIdNotFound() {
        when(envioRepository.findById(999)).thenReturn(Optional.empty());

        Envio resultado = envioService.getEnvioById(999);

        assertNull(resultado);
        verify(envioRepository, times(1)).findById(999);
    }
}

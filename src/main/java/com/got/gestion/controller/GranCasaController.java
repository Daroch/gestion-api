package com.got.gestion.controller;

import com.got.gestion.entity.GranCasa;
import com.got.gestion.repository.GranCasaRepository;
import com.got.gestion.service.GranCasaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Tag(name = "Grandes casas", description = "Consulta de las grandes casas")
@RestController
@RequestMapping("/api/gran-casa")
@AllArgsConstructor
public class GranCasaController {

    private final GranCasaService granCasaService;

    @Operation(summary = "Listar todas las grandes casas")
    @GetMapping
    public List<GranCasa> obtenerGrandesCasas() {
        return granCasaService.obtenerGrandesCasas();
    }

    @Operation(summary = "Resumen de las grandes casas: nombre, lema y región")
    @GetMapping("/resumen")
    public List<GranCasaRepository.GranCasaResumen> obtenerGrandesCasasResumen() {
        return granCasaService.obtenerGrandesCasasResumen();
    }

    @Operation(summary = "Buscar una gran casa por nombre")
    @ApiResponse(responseCode = "200", description = "La casa encontrada")
    @ApiResponse(responseCode = "404", description = "No hay ninguna casa con ese nombre")
    @GetMapping("/buscar")
    public ResponseEntity<GranCasaRepository.GranCasaResumen> buscarPorNombre(
            @Parameter(description = "Texto que se busca en el nombre", example = "Stark")
            @RequestParam String nombre) {
        Optional<GranCasaRepository.GranCasaResumen> optionalGranCasa = granCasaService.buscarPorNombre(nombre);

        if (optionalGranCasa.isPresent()) {
            return ResponseEntity.ok(optionalGranCasa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
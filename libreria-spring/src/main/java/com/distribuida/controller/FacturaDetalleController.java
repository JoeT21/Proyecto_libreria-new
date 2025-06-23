package com.distribuida.controller;

import com.distribuida.model.FacturaDetalle;
import com.distribuida.service.FacturaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/factura-detalles")
public class FacturaDetalleController {
    @Autowired
    private FacturaDetalleService facturaDetalleService;

    @GetMapping
    public ResponseEntity<List<FacturaDetalle>> findAll(){
        List<FacturaDetalle> detalles = facturaDetalleService.findAll();
        return ResponseEntity.ok(detalles);

    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDetalle> FindOne(@PathVariable int id){
        FacturaDetalle detalle = facturaDetalleService.findOne(id);
        if (detalle == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detalle);
    }


}

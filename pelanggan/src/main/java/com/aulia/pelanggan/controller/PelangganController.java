package com.aulia.pelanggan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulia.pelanggan.model.Pelanggan;
import com.aulia.pelanggan.service.PelangganService;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {
    @Autowired
    private PelangganService pelangganService;

    @GetMapping
    public List<Pelanggan> getAllPelanggans(){
        return pelangganService.getAllPelanggans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelanggan> getPelangganById(@PathVariable Long id){
        Pelanggan pelanggan = pelangganService.getProkById(id);
        return pelanggan != null ? ResponseEntity.ok(pelanggan) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Pelanggan creatPelanggan(@RequestBody Pelanggan pelanggan){
        return pelangganService.creatPelanggan(pelanggan);
    }

    @DeleteMapping
    public ResponseEntity<?> deletePelanggan (@PathVariable Long id){
        pelangganService.deletePelanggan(id);
        return ResponseEntity.ok().build();
    }


}

package com.aulia.produk.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulia.produk.model.Produk;
import com.aulia.produk.service.ProdukService;

@RestController
@RequestMapping("/api/produk")
public class ProdukController {

    private static final Logger log = LoggerFactory.getLogger(ProdukController.class);

    @Autowired
    private ProdukService produkService;

    @GetMapping
    public List<Produk> getAllProduks() {
        log.info("Mengambil seluruh data produk");
        return produkService.getAllProduks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produk> getProdukById(@PathVariable Long id) {
        log.info("Mengambil produk dengan id {}", id);

        Produk produk = produkService.getProkById(id);

        return produk != null
                ? ResponseEntity.ok(produk)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Produk createProduk(@RequestBody Produk produk) {
        log.info("Menambahkan produk baru");

        return produkService.createProduk(produk);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduk(@PathVariable Long id) {
        log.info("Menghapus produk dengan id {}", id);

        produkService.deleteProduk(id);

        return ResponseEntity.ok("Produk berhasil dihapus");
    }
}
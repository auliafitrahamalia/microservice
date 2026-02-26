package com.aulia.produk.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulia.produk.model.Produk;
import com.aulia.produk.repository.ProdukRepository;

@Service
public class ProdukService {
    @Autowired
    private ProdukRepository produkRepository;

    public List<Produk> getAllProduks(){
        return produkRepository.findAll();
    }

    public Produk getProkById(Long id){
        return produkRepository.findById(id).orElse(null);
    }

    public Produk createProduk(Produk produk){
        return produkRepository.save(produk);
    }

    public void deleteProduk (Long id){
        produkRepository.deleteById(id);
    }

}

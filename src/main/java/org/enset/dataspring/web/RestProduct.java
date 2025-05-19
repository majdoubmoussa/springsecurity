package org.enset.dataspring.web;

import org.enset.dataspring.entities.Produit;
import org.enset.dataspring.repository.ProduitRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestProduct {

    private ProduitRepository produitRepository;

    public RestProduct(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }
    @GetMapping("/getProduits")
    public List<Produit> getProduits() {
        return produitRepository.findAll();

    }
    @GetMapping("/getProduits/{id}")
    public Produit getProduit(@PathVariable(name = "id") Long id) {
        return produitRepository.findById(id).get();
    }
}

package org.enset.dataspring.repository;

import org.enset.dataspring.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    public List<Produit> findByNomContaining(String nom);
}

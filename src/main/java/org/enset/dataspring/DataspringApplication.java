package org.enset.dataspring;

import org.enset.dataspring.entities.Produit;
import org.enset.dataspring.repository.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DataspringApplication {

    public static void main(String[] args) {

        SpringApplication.run(DataspringApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProduitRepository repo) {
        return args -> {
            Produit p1 = new Produit();
            p1.setNom("P1");
            p1.setPrix(4580);
            p1.setQuantite(6);
            Produit p2 = new Produit();
            p2.setNom("P2");
            p2.setPrix(4000);
            p2.setQuantite(5);



            //repo.save(p1);
            //repo.save(p2);
            System.out.println("Hello Spring Boot data !");
            List<Produit> produits=repo.findByNomContaining("IMP");
            for (Produit produit:produits) {
                System.out.println(produit.getNom());
            }



        };
    }

}

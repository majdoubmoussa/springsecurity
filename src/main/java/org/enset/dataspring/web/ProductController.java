package org.enset.dataspring.web;

import jakarta.validation.Valid;
import org.enset.dataspring.entities.Produit;
import org.enset.dataspring.repository.ProduitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {
    private ProduitRepository produitRepository;

    public ProductController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }


    @GetMapping("/index")
    public String index(Model model) {
        List<Produit> produits = produitRepository.findAll();
        model.addAttribute("listProduits", produits);
        return "products";
    }
    @GetMapping("/deleteProduct")

    public String delete(@RequestParam(name = "id") Long id) {
        produitRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/updateProduct")
    public String update(@RequestParam(name = "id") Long id, Model model) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produit introuvable avec id: " + id));
        model.addAttribute("produit", produit);
        return "updateProduct";
    }

    @PostMapping("/rechercher")
    public String rechercher(@RequestParam(name = "motcle") String motcle, Model model) {
        List<Produit> produits = produitRepository.findByNomContaining(motcle);

        model.addAttribute("listProduits", produits);
        model.addAttribute("motcle", motcle);
        return "products";
    }

    @GetMapping("/")

    public String Home() {

        return "redirect:/index";

    }
    @GetMapping("/newProduct")
    public String newProduct(Model model) {
        model.addAttribute("produit", new Produit());
        return "newProduct";
    }
    @PostMapping("/saveProduct")
    public String saveProduct(@Valid Produit produit, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) return "newProduct";
        produitRepository.save(produit);
        return "redirect:/index";

    }
    @GetMapping("/notAuthorized")
    public String notAuthorized(Model model) {
        return "notAuthorized";
    }




}

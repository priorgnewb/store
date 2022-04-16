package org.faze.store.controllers;
import org.faze.store.models.Product;
import org.faze.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/products")
public class StoreController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("allprods", productService.getAllProducts());
        return "index";
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("item", productService.getProduct(id));
        return "item_show";
    }

    @GetMapping("/new")
    public String newProduct(@ModelAttribute("product") Product product) {
    return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") @Valid Product product,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";

        productService.saveProduct(product);
        return "redirect:/products";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("product", productService.getProduct(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "edit";

        productService.updateProduct(id, product);
        return "redirect:/products";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}

package com.certus.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.certus.spring.models.Product;
import com.certus.spring.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/pangea")
public class CartController {

    @Autowired
    private ProductService productService;

    @GetMapping("/cart")
    public String viewCart(Model model, HttpSession session) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        // Calcula el total del carrito
        double total = cart.stream().mapToDouble(Product::getPrice).sum();

        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        return "cart";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam("productId") Long productId, HttpSession session) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        // Añadir el producto al carrito
        Product product = productService.findById(productId);
        cart.add(product);
        session.setAttribute("cart", cart);
        return "redirect:/pangea/cart";
    }
}
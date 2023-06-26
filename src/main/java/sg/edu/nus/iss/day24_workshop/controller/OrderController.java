package sg.edu.nus.iss.day24_workshop.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.day24_workshop.model.Order;
import sg.edu.nus.iss.day24_workshop.model.OrderDetails;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping
public class OrderController {

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("orderDetails", new OrderDetails());
        return "index";
    }

    @PostMapping(path = "/order", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String newOrder(@ModelAttribute Order order, @ModelAttribute OrderDetails orderDetails) {

       

        return "success";
    }
    
    
}

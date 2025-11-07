package com.example.frontend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Value("${API_URL:http://localhost:9082/api/usuarios}")
    private String apiUrl;

  /*  @GetMapping("/")
    public String home() {
        return "index";
    }
    */

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("apiUrl", apiUrl);
        return "index";
    }
}

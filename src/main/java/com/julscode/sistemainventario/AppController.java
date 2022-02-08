package com.julscode.sistemainventario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class AppController {

    @GetMapping(value="/")
    public String  verPaginaDeInicio() {
        
        return "index";
    }
    
    
}

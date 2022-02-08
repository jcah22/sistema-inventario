package com.julscode.sistemainventario.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/categorias")
    public String listarCategorias(Model model) {

        List<Categoria> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        return "categorias";

    }

    @GetMapping("/categorias/nuevo")
    public String mostrarFormularioDeNuevaCategoria(Model model) {

        model.addAttribute("categoria", new Categoria());

        return "categoria_formulario";

    }

    @PostMapping("/categorias/guardar")
    public String guardarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);

        return "redirect:/categorias";

    }

}

package com.julscode.sistemainventario.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        model.addAttribute("listaUsuarios", listaUsuarios);

        return "usuarios";

    }

    @GetMapping("/usuarios/nuevo")
    public String mostrarFormularioDeRegistroDeUsuario(Model model) {
        List<Rol> listaRoles = rolRepository.findAll();
        model.addAttribute("listaRoles", listaRoles);
        model.addAttribute("usuario", new Usuario());

        return "usuario_formulario";

    }

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);

        return "redirect:/usuarios";

    }

    @GetMapping("/usuarios/editar/{id}")
    public String mostrarFormularioDeEditarUsuario(@PathVariable("id") Integer id, Model model) {
        Usuario usuario = usuarioRepository.findById(id).get();
        model.addAttribute("usuario", usuario);
        List<Rol> listaRoles = rolRepository.findAll();
        model.addAttribute("listaRoles", listaRoles);

        return "usuario_formulario";

    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") Integer id, Model model) {

        usuarioRepository.deleteById(id);
        return "redirect:/usuarios";
    }

}

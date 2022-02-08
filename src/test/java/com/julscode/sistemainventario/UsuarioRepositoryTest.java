package com.julscode.sistemainventario;


import com.julscode.sistemainventario.usuario.Rol;
import com.julscode.sistemainventario.usuario.Usuario;
import com.julscode.sistemainventario.usuario.UsuarioRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCrearRoles(){

        Rol rolAdmin = new Rol("Administrador");
        Rol rolEditor = new Rol("Editor");
        Rol rolVisitante = new Rol("Visitante");

        entityManager.persist(rolAdmin);
        entityManager.persist(rolEditor);
        entityManager.persist(rolVisitante);


       
    }

    @Test
    public void testCrearNuevoUsuarioConRol(){
        Rol rolAdmin = entityManager.find(Rol.class, 1);
        Usuario usuario = new Usuario("jcah549@gmail.com","Chuchuluco2204*");

        usuario.añadirRol(rolAdmin);
        usuarioRepository.save(usuario);
        
    }


    @Test
    public void testCrearNuevoUsuarioConDosRoles(){
        Rol rolEditor = entityManager.find(Rol.class, 2);
        Rol rolVisitante = entityManager.find(Rol.class, 3); 

        Usuario usuario = new Usuario("julscode@gmail.com","123456");

        usuario.añadirRol(rolEditor);
        usuario.añadirRol(rolVisitante);
        usuarioRepository.save(usuario);
        
    }

    @Test
    public void testAsignarRolAusuarioExistente(){
      

        Usuario usuario = usuarioRepository.findById(1).get();

        Rol rolAdmin =entityManager.find(Rol.class, 2);

        usuario.añadirRol(rolAdmin);
        usuarioRepository.save(usuario);
        
    }

    @Test
    public void testEliminarRolDeUnUsuarioExistente(){
        Usuario usuario = usuarioRepository.findById(1).get();
        Rol rol = new Rol(2); // le pasamos el id del rol a eliminar
        usuario.eliminarRol(rol);

    }

    @Test
    public void testCrearNuevoUsuarioConNuevoRol(){
        Rol rolVendedor = new Rol("Vendedor");
        Usuario usuario = new Usuario("vendedor@gmail.com","12345");

        usuario.añadirRol(rolVendedor);
        usuarioRepository.save(usuario);
    }

    @Test
    public void testobtenerUsuario(){
        Usuario usuario = usuarioRepository.findById(1).get();
        entityManager.detach(usuario);

        System.out.println(usuario.getEmail());
        System.out.println(usuario.getRoles());

    }

    @Test
    public void testEliminarUsuario(){
        usuarioRepository.deleteById(7);
    }


    
}

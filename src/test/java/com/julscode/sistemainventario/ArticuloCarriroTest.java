package com.julscode.sistemainventario;

import com.julscode.sistemainventario.carrito.ArticuloCarriroRepository;
import com.julscode.sistemainventario.carrito.ArticuloCarrito;
import com.julscode.sistemainventario.producto.Producto;
import com.julscode.sistemainventario.usuario.Usuario;

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
public class ArticuloCarriroTest {

    @Autowired 
    private ArticuloCarriroRepository articuloCarriroRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testAñadirArticulo(){
        Producto producto = testEntityManager.find(Producto.class, 3);
        Usuario usuario = testEntityManager.find(Usuario.class, 1);

        ArticuloCarrito articulo = new ArticuloCarrito(1,producto,usuario);
        articuloCarriroRepository.save(articulo);
    }



    
}

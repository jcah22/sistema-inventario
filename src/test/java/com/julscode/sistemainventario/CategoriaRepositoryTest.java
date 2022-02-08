package com.julscode.sistemainventario;

import com.julscode.sistemainventario.categoria.Categoria;
import com.julscode.sistemainventario.categoria.CategoriaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoriaRepositoryTest {

    @Autowired
    private CategoriaRepository repositorio;



    @Test
    public void testCrearCategoria(){
        Categoria categoriaGuardada = repositorio.save( new Categoria("Electronicos") );
          //  assertThat(categoriaGuardada.getId()).isGreaterThan(0);
    
    }   

    
}

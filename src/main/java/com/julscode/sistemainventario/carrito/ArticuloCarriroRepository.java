package com.julscode.sistemainventario.carrito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloCarriroRepository extends JpaRepository<ArticuloCarrito, Integer>{
    
}

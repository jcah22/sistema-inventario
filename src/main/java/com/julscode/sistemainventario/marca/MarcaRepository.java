package com.julscode.sistemainventario.marca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository <Marca , Integer> {

    
    
}

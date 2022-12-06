package com.exemple.algamoney.api.rerpository;

import com.exemple.algamoney.api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}

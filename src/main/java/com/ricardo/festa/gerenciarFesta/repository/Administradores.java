package com.ricardo.festa.gerenciarFesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ricardo.festa.gerenciarFesta.model.Administrador;

public interface Administradores extends JpaRepository<Administrador, Long> {

}

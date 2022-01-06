package com.ricardo.festa.gerenciarFesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricardo.festa.gerenciarFesta.model.Convidado;

public interface Convidados  extends JpaRepository <Convidado, Long> {

}

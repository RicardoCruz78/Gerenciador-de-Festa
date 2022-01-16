package com.ricardo.festa.gerenciarFesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ricardo.festa.gerenciarFesta.model.Administrador;

public interface Administradores extends JpaRepository<Administrador, Long> {
//@Query(value="select id  > 0 THEN 'true' ELSE 'false' END from administradores where id = :id",nativeQuery = true)
//@Query(value="select id from administradores where id = :id",nativeQuery = true)
	@Query(value = "select CASE WHEN count(1) > 0 THEN 'true'ELSE 'false' END from administradores where id = :id", nativeQuery = true)
	public boolean exist(Long id);

	@Query(value = "select * from administradores where email = :email and senha = :senha", nativeQuery = true)

	public Administrador Login(String email, String senha);

}

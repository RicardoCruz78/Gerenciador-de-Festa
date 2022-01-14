package com.ricardo.festa.gerenciarFesta.model;


import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Column ;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor ;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "administradores")
public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private  Long  id;
	
	@Column(name="nomeAdm",length = 140, nullable = false)
	private  String nome;	
	
	
	@Column(name="emailAdm",length = 120, nullable = false)
	private String email;	
	
	
	
	@Column(name="senhaAdm",length = 110, nullable = false)
	
   private String senha; 
	
	@Column(name="observacaoAdm" )
	private String observacao;

	

	

	
	
}

package com.example.cadastro.usuario.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.cadastro.usuario.model.Usuario;
import com.example.cadastro.usuario.model.Usuario.Genero;

public class UsuarioFormDto {

	@NotBlank
	@NotNull
	@Size(min = 2, max = 30)
	private String nome;

	@NotNull
	@NotBlank
	@Size(min = 2, max = 30)

	private String sobreNome;

	@Email
	@NotBlank
	@NotNull
	@Column(unique = true)
	private String email;

	@NotBlank
	@NotNull
	@Size(min = 6, max = 10)
	private String senha;

	@NotNull
	private LocalDate localDate;

	@NotNull
	private Genero genero;

	public String getNome() {
		return nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public Genero getGenero() {
		return genero;
	}

}

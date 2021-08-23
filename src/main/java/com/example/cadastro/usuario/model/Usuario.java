package com.example.cadastro.usuario.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import com.example.cadastro.usuario.dto.UsuarioFormDto;

@Entity(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

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

	public enum Genero {
		MASCULINO, FEMININO, OUTRO
	}

	@PastOrPresent
	private LocalDateTime createDateTime;

	@Deprecated
	public Usuario() {

	}

	public Usuario(UsuarioFormDto usuarioDto) {
		this.nome = usuarioDto.getNome();
		this.sobreNome = usuarioDto.getSobreNome();
		this.email = usuarioDto.getEmail();
		this.senha = usuarioDto.getSenha();
		this.localDate = usuarioDto.getLocalDate();
		this.genero = usuarioDto.getGenero();
		this.createDateTime = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public LocalDateTime getCreaDateTime() {
		return createDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.createDateTime = localDateTime;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", email=" + email + ", senha="
				+ senha + ", localDate=" + localDate + ", genero=" + genero + ", localDateTime=" + createDateTime + "]";
	}

}

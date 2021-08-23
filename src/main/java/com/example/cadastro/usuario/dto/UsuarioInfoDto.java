package com.example.cadastro.usuario.dto;

public class UsuarioInfoDto {

	private String nome;

	private String sobreNome;

	public UsuarioInfoDto(UsuarioFormDto usuarioFormDto) {

		this.nome = usuarioFormDto.getNome();
		this.sobreNome = usuarioFormDto.getSobreNome();
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSobreNome() {
		return sobreNome;
	}

}

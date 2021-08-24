package com.example.cadastro.usuario.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.usuario.dto.UsuarioFormDto;
import com.example.cadastro.usuario.dto.UsuarioInfoDto;
import com.example.cadastro.usuario.model.Usuario;
import com.example.cadastro.usuario.repository.copy.UsuarioRepository;

@RestController
@RequestMapping("api")
public class CadastroController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("cadastro")
	@Transactional
	public ResponseEntity<UsuarioInfoDto> cadastra(@RequestBody @Valid UsuarioFormDto usuarioFormDto) {
		if (isExistente(usuarioFormDto)) {
			return new ResponseEntity<UsuarioInfoDto>(new UsuarioInfoDto(usuarioFormDto), HttpStatus.BAD_REQUEST);
		} else {
			
			this.usuarioRepository.save(new Usuario(usuarioFormDto));
			return new ResponseEntity<UsuarioInfoDto>(new UsuarioInfoDto(usuarioFormDto), HttpStatus.OK);

		}

	}

	private boolean isExistente(UsuarioFormDto usuarioFormDto) {
		return this.usuarioRepository.findByEmail(new Usuario(usuarioFormDto).getEmail()) != null;
	}
}

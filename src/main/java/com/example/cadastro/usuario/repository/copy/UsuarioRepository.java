package com.example.cadastro.usuario.repository.copy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cadastro.usuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByEmail(String email);

}

package com.avaliacao.leonardo.repository;

import com.avaliacao.leonardo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    Usuario findByCpf(String cpf);

    // lista todos por tipo (ADMIN, FUNCIONARIO, CLIENTE)
    java.util.List<Usuario> findByPerfil(String perfil);
}

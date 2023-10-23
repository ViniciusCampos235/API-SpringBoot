package br.com.criandoapi.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.criandoapi.projeto.model.UsuarioModel;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
}

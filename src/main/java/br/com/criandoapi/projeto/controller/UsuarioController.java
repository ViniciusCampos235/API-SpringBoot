package br.com.criandoapi.projeto.controller;

import br.com.criandoapi.projeto.dto.UsuarioRecordsDto;
import br.com.criandoapi.projeto.repositories.IUsuarioRepository;
import br.com.criandoapi.projeto.model.UsuarioModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioRepository dao;

    @Transactional
    @GetMapping
    public List<UsuarioModel> listaUsuarios(){
        return (List<UsuarioModel>) dao.findAll();
    }

    @Transactional
    @PostMapping
    public ResponseEntity<UsuarioModel> criarUsuario(@RequestBody @Valid UsuarioRecordsDto usuarioRecord){
        UsuarioModel usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioRecord, usuarioModel);
        UsuarioModel usuarioSalvo = dao.save(usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

}

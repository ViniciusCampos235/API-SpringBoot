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
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Transactional
    @GetMapping
    public List<UsuarioModel> listaUsuarios(){
        return (List<UsuarioModel>) usuarioRepository.findAll();
    }

    @Transactional
    @PostMapping
    public ResponseEntity<UsuarioModel> criarUsuario(@RequestBody @Valid UsuarioRecordsDto usuarioRecord){
        UsuarioModel usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioRecord, usuarioModel);
        UsuarioModel usuarioSalvo = usuarioRepository.save(usuarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioSalvo);
    }

    @PutMapping("usuarios/{id}")
    public ResponseEntity<Object> alterarUsuario(@PathVariable(value = "id") Integer id,
                                                       @RequestBody @Valid UsuarioRecordsDto usuarioRecord){
        Optional<UsuarioModel> usuari0= usuarioRepository.findById(id);
        if(usuari0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        var usuarioModel = usuari0.get();
        BeanUtils.copyProperties(usuarioRecord, usuarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuarioModel));
    }

    @DeleteMapping("/{id}")
    public Optional<UsuarioModel> excluiUsuario(@PathVariable Integer id){
        Optional<UsuarioModel> usuarioModel = usuarioRepository.findById(id);
        usuarioRepository.deleteById(id);
        return usuarioModel;
    }

}

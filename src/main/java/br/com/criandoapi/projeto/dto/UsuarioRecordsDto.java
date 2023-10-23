package br.com.criandoapi.projeto.dto;


import jakarta.validation.constraints.NotBlank;

public record UsuarioRecordsDto(

        @NotBlank
        String nome_completo,
        @NotBlank
        String username,
        @NotBlank
        String email,
        @NotBlank
        String senha,
        @NotBlank
        String telefone){
}

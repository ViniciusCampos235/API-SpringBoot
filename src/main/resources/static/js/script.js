document.addEventListener('DOMContentLoaded', function(){
    const formulario = document.querySelector("form");
    const Inome = document.querySelector(".nome_completo");
    const Iusername = document.querySelector(".username");
    const Iemail = document.querySelector(".email");
    const Isenha = document.querySelector(".senha");
    const Itel = document.querySelector(".tel");

    console.log(Inome);
    console.log(Iusername);
    console.log(Iemail);
    console.log(Isenha);
    console.log(Itel);

    function cadastrar(){

        if (Inome && Iusername && Iemail && Isenha && Itel) {
            fetch("http://localhost:8080/usuarios", {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: "POST",
                body: JSON.stringify({
                    nome_completo: Inome.value,
                    username: Iusername.value,
                    email: Iemail.value,
                    senha: Isenha.value,
                    telefone: Itel.value
                })
            })
            .then(function(res) { console.log(res) })
            .catch(function(res) { console.log(res) });
        } else {
            console.error("Um dos elementos não foi encontrado.");
        }

    };

    function limpar(){
        Inome.value = "";
        Iusername.value = "";
        Iemail.value = "";
        Isenha.value = "";
        Itel.value = "";
    }

    formulario.addEventListener('submit', function(event){
        event.preventDefault();

        cadastrar();
        limpar();
    });
});

package douglas.rastreavel_agro.dto.produtores

import douglas.rastreavel_agro.entities.Produtor

class ProdutorVisu(
    var primeiroNome : String,
    var ultimoNome : String,
    var cpf : String,
    var email : String,
    var senha : String,
    var nomeLocalidade : String,
    var municipio : String
)
{
    constructor(produtor: Produtor) : this (
        primeiroNome = produtor.primeiroNome,
        ultimoNome = produtor.ultimoNome,
        cpf = produtor.cpf,
        email = produtor.email,
        senha = produtor.senha,
        nomeLocalidade = produtor.localidade.nomeLocalidade,
        municipio = produtor.localidade.municipio
    )
}

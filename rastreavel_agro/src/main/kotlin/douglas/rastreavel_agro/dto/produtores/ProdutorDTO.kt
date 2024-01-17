package douglas.rastreavel_agro.dto.produtores

import douglas.rastreavel_agro.entities.Localidade
import douglas.rastreavel_agro.entities.Produtor
import jakarta.validation.constraints.NotEmpty

data class ProdutorDTO(
    @field:NotEmpty(message ="Esta entrada não pode ser nula")
    var primeiroNome : String,
    @field:NotEmpty(message ="Esta entrada não pode ser nula")
    var ultimoNome : String,
    @field:NotEmpty(message ="Esta entrada não pode ser nula")
    var cpf : String,
    @field:NotEmpty(message ="Esta entrada não pode ser nula")
    var email : String,
    @field:NotEmpty(message ="Esta entrada não pode ser nula")
    var nomeLocalidade : String,
    @field:NotEmpty(message ="Esta entrada não pode ser nula")
    var municipio : String
) {
    fun toEntity(): Produtor = Produtor(
        primeiroNome = this.primeiroNome,
        ultimoNome = this.ultimoNome,
        cpf = this.cpf,
        email = this.email,
        localidade = Localidade(
            nomeLocalidade = this.nomeLocalidade,
            municipio = this.municipio
        )
    )

}

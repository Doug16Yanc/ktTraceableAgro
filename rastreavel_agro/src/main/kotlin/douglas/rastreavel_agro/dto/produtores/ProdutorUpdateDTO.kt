package douglas.rastreavel_agro.dto.produtores

import douglas.rastreavel_agro.entities.Produtor
import jakarta.validation.constraints.NotEmpty

data class ProdutorUpdateDTO(
    @field:NotEmpty(message ="Esta entrada não pode ser nula")
    var primeiroNome : String,
    @field:NotEmpty(message ="Esta entrada não pode ser nula")
    var ultimoNome : String,
    @field:NotEmpty(message ="Esta entrada não pode ser nula")
    var email : String,
    @field:NotEmpty(message ="Esta entrada não pode ser nula")
    var nomeLocalidade : String,
    @field:NotEmpty(message ="Esta entrada não pode ser nula")
    var municipio : String
) {
    fun toEntity(produtor: Produtor) : Produtor {
        produtor.primeiroNome = this.primeiroNome
        produtor.ultimoNome = this.ultimoNome
        produtor.email = this.email
        produtor.localidade.nomeLocalidade = this.nomeLocalidade
        produtor.localidade.municipio = this.municipio
        return produtor
    }

}

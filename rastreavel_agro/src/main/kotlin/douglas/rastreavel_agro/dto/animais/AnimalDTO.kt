package douglas.rastreavel_agro.dto.animais

import douglas.rastreavel_agro.entities.Animal
import douglas.rastreavel_agro.entities.Produtor
import jakarta.persistence.Column
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.util.*

data class AnimalDTO(
    @field:NotNull(message = "Esta entrada não pode ser nula.\n")
    var peso : Double,
    @field:NotNull(message = "Esta entrada não pode ser nula.\n")
    var dataNascimento : LocalDate,
    @field:NotNull(message = "Esta entrada não pode ser nula.\n")
    var percentPrenhez : Double,
    @field:NotNull(message = "Esta entrada não pode ser nula.\n")
    var desmame : LocalDate,
    @field:NotNull(message = "Esta entrada não pode ser nula.\n")
    var indexNatal : Double,
    @field:NotNull(message = "Esta entrada não pode ser nula.\n")
    var indexMortal : Double = 0.0,
    @field:NotNull(message = "Esta entrada não pode ser nula.\n")
    var produtor : Long
) {
    fun toEntity(): Animal = Animal(
        peso = this.peso,
        dataNascimento = this.dataNascimento,
        percentPrenhez = this.percentPrenhez,
        desmame = this.desmame,
        indexNatal = this.indexNatal,
        indexMortal = this.indexMortal,
        produtor = Produtor(
            id = this.produtor,

        )
    )


}

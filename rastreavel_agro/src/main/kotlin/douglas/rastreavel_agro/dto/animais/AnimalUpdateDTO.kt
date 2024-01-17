package douglas.rastreavel_agro.dto.animais

import douglas.rastreavel_agro.entities.Animal
import douglas.rastreavel_agro.entities.Produtor
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class AnimalUpdateDTO(
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
    fun toEntity(animal : Animal): Animal {
        animal.peso = this.peso
        animal.dataNascimento = this.dataNascimento
        animal.percentPrenhez = this.percentPrenhez
        animal.desmame = this.desmame
        animal.indexNatal = this.indexNatal
        animal.indexMortal = this.indexMortal
        return animal
    }

}

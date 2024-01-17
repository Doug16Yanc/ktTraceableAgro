package douglas.rastreavel_agro.dto.animais

import douglas.rastreavel_agro.entities.Animal
import douglas.rastreavel_agro.entities.Produtor
import jakarta.persistence.Column
import jakarta.persistence.ManyToOne
import java.time.LocalDate
import java.util.*

data class AnimalVisu(
    var idAnimal: UUID,
    var peso : Double,
    var dataNascimento : LocalDate,
    var percentPrenhez : Double,
    var desmame : LocalDate,
    var indexNatal : Double,
    var indexMortal : Double,
) {
    constructor(animal: Animal) : this (
        idAnimal =  animal.idAnimal,
        peso = animal.peso,
        dataNascimento = animal.dataNascimento,
        percentPrenhez = animal.percentPrenhez,
        desmame = animal.desmame,
        indexNatal = animal.indexNatal,
        indexMortal = animal.indexMortal
    )
}

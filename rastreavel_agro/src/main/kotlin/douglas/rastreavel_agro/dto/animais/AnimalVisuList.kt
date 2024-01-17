package douglas.rastreavel_agro.dto.animais

import douglas.rastreavel_agro.entities.Animal
import java.time.LocalDate
import java.util.*

data class AnimalVisuList(
    var idAnimal: UUID,
    var peso : Double,
    var dataNascimento : LocalDate
) {
    constructor(animal : Animal) : this(
        idAnimal = animal.idAnimal,
        peso = animal.peso,
        dataNascimento = animal.dataNascimento
    )

}

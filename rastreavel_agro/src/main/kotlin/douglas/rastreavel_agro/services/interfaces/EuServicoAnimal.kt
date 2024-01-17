package douglas.rastreavel_agro.services.interfaces

import douglas.rastreavel_agro.entities.Animal
import java.util.UUID

interface EuServicoAnimal {
    fun salvaAnimal(animal : Animal) : Animal

    fun encontraTodosPorProdutor(produtorId : Long) : List<Animal>

    fun encontraPorIdAnimal(produtorId : Long, idAnimal: UUID) : Animal?
}
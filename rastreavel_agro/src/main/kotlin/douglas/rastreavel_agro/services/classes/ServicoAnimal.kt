package douglas.rastreavel_agro.services.classes

import douglas.rastreavel_agro.entities.Animal
import douglas.rastreavel_agro.repositories.AnimalRepositorio
import douglas.rastreavel_agro.services.interfaces.EuServicoAnimal
import org.springframework.stereotype.Service
import java.util.*

@Service
class ServicoAnimal (private val animalRepositorio: AnimalRepositorio,
                    private val servicoProdutor: ServicoProdutor) : EuServicoAnimal{
    override fun salvaAnimal(animal: Animal): Animal {
        animal.apply { produtor = servicoProdutor.encontraPorId(animal.produtor?.id!!)  }
        return this.animalRepositorio.save(animal)
    }

    override fun encontraTodosPorProdutor(produtorId : Long): List<Animal> =
        this.animalRepositorio.encontrarTodosPorProdutor(produtorId)

    override fun encontraPorIdAnimal(produtorId: Long, idAnimal: UUID) : Animal {
        val animal : Animal = (
                this.animalRepositorio.encontrarPorIdAnimal(idAnimal)
                    ?:throw RuntimeException("Animal não encontrado.\n")
                )
        return if (animal.produtor?.id == produtorId) animal else throw IllegalArgumentException("Consulte o administrador do sistema, por favor.\n")

    }
}
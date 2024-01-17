package douglas.rastreavel_agro.repositories

import douglas.rastreavel_agro.entities.Animal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AnimalRepositorio : JpaRepository<Animal, UUID> {
    @Query("SELECT animal FROM Animal animal WHERE animal.idAnimal = :idAnimal")
    fun encontrarPorIdAnimal(@Param("idAnimal") idAnimal: UUID) : Animal

    fun encontrarTodosPorProdutor(produtorId : Long) : List<Animal>
}
package douglas.rastreavel_agro.repositories

import douglas.rastreavel_agro.entities.Produtor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProdutorRepositorio : JpaRepository<Produtor, Long> {
}
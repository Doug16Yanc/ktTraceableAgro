package douglas.rastreavel_agro.entities

import jakarta.persistence.*
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "animal")
data class Animal(
    @Id
    @Column(nullable = false, unique = true)
    var idAnimal: UUID = UUID.randomUUID(),
    @Column(nullable = false)
    var peso : Double = 0.0,
    @Column(nullable = false)
    var dataNascimento : LocalDate,
    @Column(nullable = false)
    var percentPrenhez : Double = 0.0,
    @Column(nullable = false)
    var desmame : LocalDate,
    @Column(nullable = false)
    var indexNatal : Double = 0.0,
    @Column(nullable = false)
    var indexMortal : Double = 0.0,
    @ManyToOne
    var produtor : Produtor? = null
)

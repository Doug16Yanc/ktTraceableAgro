package douglas.rastreavel_agro.entities

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDate

data class Animal(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idAnimal: Long? = null,
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

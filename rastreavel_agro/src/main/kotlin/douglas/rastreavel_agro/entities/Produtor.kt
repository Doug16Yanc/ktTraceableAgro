package douglas.rastreavel_agro.entities

import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import javax.annotation.processing.Generated

data class Produtor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,
    @Column(nullable = false)
    var primeiroNome : String = "",
    @Column(nullable = false)
    var ultimoNome : String = "",
    @Column(nullable = false, unique = true)
    var cpf : String = "",
    @Column(nullable = false, unique = true)
    var email : String = "",
    @Column(nullable = false)
    var senha : String = "",
    @Column(nullable = false)
    @Embedded
    var localidade : Localidade = Localidade(1, "", ""),
    @Column(nullable = false)
    var animais : List<Animal> = mutableListOf()
)

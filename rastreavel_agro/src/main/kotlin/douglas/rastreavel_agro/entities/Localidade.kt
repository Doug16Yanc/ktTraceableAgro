package douglas.rastreavel_agro.entities

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

data class Localidade(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var codigo : Long? = null,
    @Column(nullable = false)
    var nomeLocalidade : String = "",
    @Column(nullable = false)
    var municipio : String = ""
)


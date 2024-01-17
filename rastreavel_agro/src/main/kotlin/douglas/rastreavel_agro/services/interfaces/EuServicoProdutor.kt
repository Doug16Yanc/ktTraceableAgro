package douglas.rastreavel_agro.services.interfaces

import douglas.rastreavel_agro.entities.Produtor

interface EuServicoProdutor {
    fun salvaProdutor(produtor : Produtor) : Produtor

    fun encontraPorId(id : Long) : Produtor

    fun deletaProdutor(id : Long)
}
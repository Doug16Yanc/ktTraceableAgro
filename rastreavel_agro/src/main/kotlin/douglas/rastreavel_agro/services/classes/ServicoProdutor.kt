package douglas.rastreavel_agro.services.classes

import douglas.rastreavel_agro.entities.Produtor
import douglas.rastreavel_agro.repositories.ProdutorRepositorio
import douglas.rastreavel_agro.services.interfaces.EuServicoProdutor
import org.springframework.stereotype.Service

@Service
class ServicoProdutor(private val produtorRepositorio: ProdutorRepositorio) : EuServicoProdutor {
    override fun salvaProdutor(produtor: Produtor): Produtor =
        this.produtorRepositorio.save(produtor)

    override fun encontraPorId(id: Long): Produtor =
        this.produtorRepositorio.findById(id).orElseThrow {
            throw RuntimeException("Produtor não encontrado.\n")
        }


    override fun deletaProdutor(id: Long) {
        val produtor : Produtor = this.encontraPorId(id)
        this.produtorRepositorio.delete(produtor)
    }

}
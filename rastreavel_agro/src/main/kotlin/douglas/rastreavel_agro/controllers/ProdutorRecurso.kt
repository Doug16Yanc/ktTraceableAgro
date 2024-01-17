package douglas.rastreavel_agro.controllers

import douglas.rastreavel_agro.dto.produtores.ProdutorDTO
import douglas.rastreavel_agro.dto.produtores.ProdutorVisu
import douglas.rastreavel_agro.entities.Produtor
import douglas.rastreavel_agro.dto.produtores.ProdutorUpdateDTO
import douglas.rastreavel_agro.services.classes.ServicoProdutor
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/produces")
class ProdutorRecurso(
    private val servicoProdutor : ServicoProdutor
){
    @PostMapping("/{id}")
    fun salvaProdutor(@RequestBody @Valid produtorDTO : ProdutorDTO) : ResponseEntity <String> {
        val produtorSalvo = this.servicoProdutor.salvaProdutor(produtorDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Produtor com o email ${produtorSalvo.email} salvo com sucesso.\n")
    }
    @GetMapping("/{id}")
    fun encontraPorId(@PathVariable Id: Long) : ResponseEntity<ProdutorVisu> {
        val produtor : Produtor = this.servicoProdutor.encontraPorId(Id)
        return ResponseEntity.status(HttpStatus.OK).body(ProdutorVisu(produtor))
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletaProdutor(@PathVariable Id : Long){
        this.servicoProdutor.deletaProdutor(Id)
    }
    @PatchMapping
    fun mudaDadosProdutor(@RequestParam(value = "produtorId") id : Long, @RequestBody @Valid produtorUpdateDto : ProdutorUpdateDTO) : ResponseEntity<ProdutorVisu> {
        try {
            val produtor = this.servicoProdutor.encontraPorId(id)
            val produtorToUpdate: Produtor = produtorUpdateDto.toEntity(produtor)
            val produtorUpdated = this.servicoProdutor.salvaProdutor(produtorToUpdate)
            return ResponseEntity.status(HttpStatus.OK).body(ProdutorVisu(produtorUpdated))
        } catch (e : NoSuchElementException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }
}
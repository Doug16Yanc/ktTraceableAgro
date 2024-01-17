package douglas.rastreavel_agro.controllers

import douglas.rastreavel_agro.dto.animais.AnimalDTO
import douglas.rastreavel_agro.dto.animais.AnimalVisu
import douglas.rastreavel_agro.dto.animais.AnimalVisuList
import douglas.rastreavel_agro.entities.Animal
import douglas.rastreavel_agro.services.classes.ServicoAnimal
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/animais")
class AnimalRecurso(
    private val servicoAnimal : ServicoAnimal
) {
    @PostMapping
    fun salvaAnimal(@RequestBody @Valid animalDTO : AnimalDTO) : ResponseEntity<String> {
        val animalSalvo : Animal = this.servicoAnimal.salvaAnimal(animalDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body(
            "Animal ${animalSalvo.idAnimal} pertencente a ${animalSalvo.produtor?.primeiroNome} salvo com sucesso.\n"
        )
    }
    @GetMapping
    fun encontraPorTodoProdutorId(@RequestParam(value = "produtorId") produtorId: Long) : ResponseEntity<List<AnimalVisuList>> {
        val animaisVisuList : List<AnimalVisuList> = this.servicoAnimal.encontraTodosPorProdutor(produtorId).stream().map{
            animal : Animal -> AnimalVisuList(animal)
        }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(animaisVisuList)
    }
    @GetMapping("/{animalcodigo}")
    fun encontraPorAnimalCodigo(@RequestParam(value = "produtorId") produtorId : Long, @PathVariable animalCodigo : UUID) :
            ResponseEntity<AnimalVisu> {
        val animal : Animal = this.servicoAnimal.encontraPorIdAnimal(produtorId, animalCodigo)
        return ResponseEntity.status(HttpStatus.OK).body(AnimalVisu(animal))
    }
}
package org.example.rest

import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import org.apache.tomcat.util.file.ConfigurationSource.Resource
import org.example.entities.Genero
import org.example.entities.Musica
import org.example.repository.MusicaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/musica")
@CrossOrigin
class MusicaRest {

    @Autowired
    var repository: MusicaRepository? = null;

    @GetMapping
    fun findAll(): ResponseEntity<List<Musica>> {
        return ResponseEntity.ok(repository!!.findAll())
    }

    @GetMapping("{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<MusicaDto>{
        var musica = repository!!.findById(id).orElseThrow{ -> RuntimeException("Id não encontrado!")}
        var musicaDto = MusicaDto()
        musicaDto.id = musica.id
        musicaDto.arquivoFaixa = musica.arquivoFaixa!!.decodeToString()
        musicaDto.faixaNumero = musica.faixaNumero
        musicaDto.duracao = musica.duracao
        musicaDto.dtLancamento = musica.dtLancamento
        musicaDto.genero = musica.genero
        musicaDto.nome = musica.nome
        return ResponseEntity.ok(musicaDto)
    }

    @PostMapping
    fun insert(@RequestBody resource: MusicaDto): ResponseEntity<Musica> {
        var musica = Musica()
        musica.genero = resource.genero
        musica.faixaNumero = resource.faixaNumero
        musica.arquivoFaixa = resource.arquivoFaixa!!.encodeToByteArray()
        musica.dtLancamento = resource.dtLancamento
        musica.duracao = resource.duracao
        musica.nome = resource.nome
        musica.id = resource.id
        return ResponseEntity.ok(repository!!.save(musica))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody resource: Musica): ResponseEntity<Musica> {
        return ResponseEntity.ok(repository!!.save(resource))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        return ResponseEntity.ok(repository!!.deleteById(id))
    }


}

class MusicaDto {
    var id: Long? = null

    var nome: String? = null

    var dtLancamento: LocalDate? = null

    var duracao: String? = null

    var faixaNumero: Int? = null

    var arquivoFaixa: String? = null

    var genero: Genero? = null
}

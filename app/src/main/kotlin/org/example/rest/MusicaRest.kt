package org.example.rest

import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import org.apache.tomcat.util.file.ConfigurationSource.Resource
import org.example.entities.Artista
import org.example.entities.Genero
import org.example.entities.Musica
import org.example.repository.MusicaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
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
    fun findById(@PathVariable id: Long): ResponseEntity<Musica>{
        var musica = repository!!.findById(id).orElseThrow{ -> RuntimeException("Id não encontrado!")}
        return ResponseEntity.ok(musica)
    }

    @PostMapping
    fun insert(@RequestPart("form") resource: Musica, @RequestPart("file") musica: MultipartFile): ResponseEntity<Musica> {
        resource.arquivoFaixa = musica.bytes
        return ResponseEntity.ok(repository!!.save(resource))
    }

    @PutMapping("/{id}")
    fun update(@RequestPart("form") resource: Musica, @RequestPart("file") musica: MultipartFile): ResponseEntity<Musica>{
        resource.arquivoFaixa = musica.bytes
        return ResponseEntity.ok(repository!!.save(resource))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        return ResponseEntity.ok(repository!!.deleteById(id))
    }


}

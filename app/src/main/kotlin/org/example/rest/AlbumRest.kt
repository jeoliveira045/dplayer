package org.example.rest

import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import org.apache.tomcat.util.file.ConfigurationSource.Resource
import org.example.entities.*
import org.example.entities.Album
import org.example.repository.AlbumRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDate
import kotlin.math.abs

@RestController
@RequestMapping("/album")
class AlbumRest(private var repository: AlbumRepository) {

    @GetMapping
    fun findAll(): ResponseEntity<List<Album>> {
        return ResponseEntity.ok(repository.findAll())
    }

    @GetMapping("{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Any>{
        return ResponseEntity.ok(repository.findById(id).orElseThrow{ -> RuntimeException("Id não encontrado!")})
    }
    @PostMapping
    fun insert(@RequestPart("form") resource: Album, @RequestPart("file") capa: MultipartFile): ResponseEntity<Album> {
        resource.capa = capa.bytes
        return ResponseEntity.ok(repository.save(resource))
    }

    @PutMapping("/{id}")
    fun update(@RequestPart("form") resource: Album,  @RequestPart("file") capa: MultipartFile): ResponseEntity<Album>{
        resource.capa = capa.bytes
        return ResponseEntity.ok(repository!!.save(resource))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        return ResponseEntity.ok(repository.deleteById(id))
    }


}

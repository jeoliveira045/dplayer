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
import org.springframework.web.bind.annotation.RestController
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
    fun insert(@RequestBody resource: AlbumDto): ResponseEntity<Album> {
        var album = Album()
        album.capa = resource.capa!!.encodeToByteArray()
        album.generoAlbum = resource.generoAlbum
        album.nome = resource.nome!!
        album.duracao = resource.duracao
        album.artistas = resource.artistas
        album.musicas = resource.musicas
        album.gravadora = resource.gravadora
        album.dataLancamento = resource.dataLancamento
        return ResponseEntity.ok(repository.save(album))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody resource: Album): ResponseEntity<Album> {
        return ResponseEntity.ok(repository.save(resource))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        return ResponseEntity.ok(repository.deleteById(id))
    }


}

class AlbumDto{
    var id: Long? = null

    var nome: String? = null


    var capa : String? = null

    var duracao: String? = null

    var dataLancamento: LocalDate? = null

    var generoAlbum: GeneroAlbum? = null

    var gravadora: Gravadora? = null

    var artistas: Set<Artista>? = null

    var musicas: Set<Musica>? = null


}

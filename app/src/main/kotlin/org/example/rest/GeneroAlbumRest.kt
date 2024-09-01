package org.example.rest

import org.apache.tomcat.util.file.ConfigurationSource.Resource
import org.example.entities.GeneroAlbum
import org.example.repository.GeneroAlbumRepository
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

@RestController
@RequestMapping("/genero-album")
class GeneroAlbumRest {

    @Autowired
    var repository: GeneroAlbumRepository? = null;

    @GetMapping
    fun findAll(): ResponseEntity<List<GeneroAlbum>> {
        return ResponseEntity.ok(repository!!.findAll())
    }

    @PostMapping
    fun insert(@RequestBody resource: GeneroAlbum): ResponseEntity<GeneroAlbum> {
        return ResponseEntity.ok(repository!!.save(resource))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody resource: GeneroAlbum): ResponseEntity<GeneroAlbum> {
        return ResponseEntity.ok(repository!!.save(resource))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        return ResponseEntity.ok(repository!!.deleteById(id))
    }


}

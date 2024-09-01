package org.example.rest

import org.apache.tomcat.util.file.ConfigurationSource.Resource
import org.example.entities.Musica
import org.example.repository.MusicaRepository
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
@RequestMapping("/musica")
class MusicaRest {

    @Autowired
    var repository: MusicaRepository? = null;

    @GetMapping
    fun findAll(): ResponseEntity<List<Musica>> {
        return ResponseEntity.ok(repository!!.findAll())
    }

    @GetMapping("{id}")
    fun finddById(@PathVariable id: Long): ResponseEntity<Musica>{
        return ResponseEntity.ok(repository!!.findById(id).orElseThrow{ -> RuntimeException("Id não encontrado!")})
    }

    @PostMapping
    fun insert(@RequestBody resource: Musica): ResponseEntity<Musica> {
        return ResponseEntity.ok(repository!!.save(resource))
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

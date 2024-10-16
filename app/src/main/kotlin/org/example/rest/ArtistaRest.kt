package org.example.rest

import org.apache.tomcat.util.file.ConfigurationSource.Resource
import org.example.entities.Artista
import org.example.repository.ArtistaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
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
import java.sql.Blob
import javax.sql.rowset.serial.SerialBlob
import java.util.Base64

@RestController
@RequestMapping("/artista")
@CrossOrigin
class ArtistaRest {

    @Autowired
    var repository: ArtistaRepository? = null;

    @GetMapping
    fun findAll(): ResponseEntity<List<Artista>> {
        return ResponseEntity.ok(repository!!.findAll())
    }

    @GetMapping("{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Any>{
        return ResponseEntity.ok(repository!!.findById(id).orElseThrow{ -> RuntimeException("Id não encontrado!")})
    }
    @PostMapping
    fun insert(@RequestPart("form") resource: Artista,  @RequestPart("file") foto: MultipartFile): ResponseEntity<Artista>{
        resource.imagem = foto.bytes
        return ResponseEntity.ok(repository!!.save(resource))
    }

    @PutMapping("/{id}")
    fun update(@RequestPart("form") resource: Artista,  @RequestPart("file") foto: MultipartFile): ResponseEntity<Artista>{
        resource.imagem = foto.bytes
        return ResponseEntity.ok(repository!!.save(resource))
    }

//    @PutMapping("/{id}")
//    fun update(@PathVariable id: Long, @RequestBody resource: Artista): ResponseEntity<Artista> {
//        return ResponseEntity.ok(repository!!.save(resource))
//    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        return ResponseEntity.ok(repository!!.deleteById(id))
    }

    private fun base64ToBlob(base64String: String): Blob {
        val decodedBytes = Base64.getDecoder().decode(base64String)
        return SerialBlob(decodedBytes)
    }


}

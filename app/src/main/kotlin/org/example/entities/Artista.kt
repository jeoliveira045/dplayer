package org.example.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.sql.Blob


@Entity
class Artista {
    @Id
    var id: Long? = null

    var nome: String? = null

    var nacionalidade: String? = null

    var imagem : Blob? = null
}

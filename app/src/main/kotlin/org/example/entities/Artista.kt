package org.example.entities

import jakarta.persistence.*
import org.hibernate.annotations.Type
import java.io.Serializable
import java.sql.Blob


@Entity
class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTISTA_SEQ")
    var id: Long? = null

    var nome: String? = null

    var nacionalidade: String? = null

//    @Lob
//    @Column(columnDefinition = "BYTEA")
    var imagem: ByteArray? = null
}

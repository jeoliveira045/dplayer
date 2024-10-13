package org.example.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
class GeneroAlbum{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENEROALBUM_SEQ")
    var id: Long? = null

    var descricao: String? = null

}

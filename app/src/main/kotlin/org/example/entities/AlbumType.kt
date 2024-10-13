package org.example.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
class AlbumType{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALBUMTYPE_SEQ")
    var id: Long? = null

    var descricao: String? = null

}

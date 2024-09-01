package org.example.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id


@Entity
class GeneroAlbum{
    @Id
    var id: Long? = null

    var descricao: String? = null

}

package org.example.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id


@Entity
class Genero{
    @Id
    var id: Long? = null

    var descricao: String? = null

}

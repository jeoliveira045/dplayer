package org.example.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
class Gravadora{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRAVADORA_SEQ")
    var id: Long? = null

    var descricao: String? = null

}

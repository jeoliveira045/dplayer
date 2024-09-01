package org.example.entities

import jakarta.annotation.Nullable
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.sql.Blob
import java.sql.Time
import java.time.LocalDate
import java.util.Timer


@Entity
@Table(name = "ALBUM")
class Album{
    @Id
    var id: Long = 0L

    var nome: String = ""

    var capa : Blob? = null

    var duracao: Timer? = null

    var dataLancamento: LocalDate? = null

}

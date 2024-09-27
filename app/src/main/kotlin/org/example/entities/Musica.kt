package org.example.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne
import java.sql.Blob
import java.time.LocalDate

@Entity
class Musica {
    @Id
    var id: Long? = null

    var nome: String? = null

    var dtLancamento: LocalDate? = null

    var duracao: String? = null

    var faixaNumero: Int? = null

    var arquivoFaixa: ByteArray? = null

    @ManyToOne
    var genero: Genero? = null
}

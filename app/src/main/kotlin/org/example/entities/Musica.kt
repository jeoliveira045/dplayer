package org.example.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
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

    var arquivoFaixa: Blob? = null
}

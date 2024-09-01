package org.example.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.sql.Blob
import java.time.LocalDate
import java.util.Timer

@Entity
class Musica {
    @Id
    var id: Long? = null

    var nome: String? = null

    var dtLancamento: LocalDate? = null

    var duracao: Timer? = null

    var faixaNumero: Int? = null

    var arquivoFaixa: Blob? = null
}

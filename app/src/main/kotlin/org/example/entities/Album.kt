package org.example.entities

import jakarta.annotation.Nullable
import jakarta.persistence.*
import java.sql.Blob
import java.sql.Time
import java.time.LocalDate


@Entity
@Table(name = "ALBUM")
class Album{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALBUM_SEQ")
    var id: Long = 0L

    var nome: String = ""


    var capa : ByteArray? = null

    var duracao: String? = null

    var dataLancamento: LocalDate? = null

    @ManyToOne
    var generoAlbum: GeneroAlbum? = null

    @ManyToOne
    var gravadora: Gravadora? = null
    @ManyToMany
    var artistas: Set<Artista>? = null

    @ManyToMany
    var musicas: Set<Musica>? = null


}

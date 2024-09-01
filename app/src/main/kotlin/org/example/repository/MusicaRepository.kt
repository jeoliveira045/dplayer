package org.example.repository

import org.example.entities.Musica
import org.springframework.data.jpa.repository.JpaRepository
import kotlin.jvm.internal.Ref.LongRef

interface MusicaRepository: JpaRepository<Musica, Long> {
}

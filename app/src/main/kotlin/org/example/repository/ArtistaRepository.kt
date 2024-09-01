package org.example.repository

import org.example.entities.Artista
import org.example.entities.Genero
import org.springframework.data.jpa.repository.JpaRepository

interface ArtistaRepository : JpaRepository<Artista , Long> {
}

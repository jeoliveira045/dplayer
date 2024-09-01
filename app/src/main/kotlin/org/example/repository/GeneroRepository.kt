package org.example.repository

import org.example.entities.Genero
import org.springframework.data.jpa.repository.JpaRepository

interface GeneroRepository : JpaRepository<Genero, Long> {
}

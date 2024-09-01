package org.example.repository

import org.example.entities.Gravadora
import org.springframework.data.jpa.repository.JpaRepository

interface GravadoraRepository: JpaRepository<Gravadora, Long> {
}

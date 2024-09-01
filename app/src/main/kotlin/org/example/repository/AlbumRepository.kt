package org.example.repository

import org.example.entities.Album
import org.example.entities.Genero
import org.springframework.data.jpa.repository.JpaRepository

interface AlbumRepository: JpaRepository<Album, Long> {
}

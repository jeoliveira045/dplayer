package org.example.repository

import org.example.entities.GeneroAlbum
import org.springframework.data.jpa.repository.JpaRepository

interface GeneroAlbumRepository : JpaRepository<GeneroAlbum, Long> {
}

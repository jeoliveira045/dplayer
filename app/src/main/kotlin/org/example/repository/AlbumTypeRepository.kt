package org.example.repository

import org.example.entities.AlbumType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AlbumTypeRepository: JpaRepository<AlbumType, Long> {
}

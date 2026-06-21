package com.javas.yoedu_be.repositories;

import com.javas.yoedu_be.domain.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}

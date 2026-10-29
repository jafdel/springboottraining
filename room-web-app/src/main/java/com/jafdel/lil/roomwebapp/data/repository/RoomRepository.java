package com.jafdel.lil.roomwebapp.data.repository;

import com.jafdel.lil.roomwebapp.data.entity.RoomEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
//@Transactional
//@Component
public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {
}

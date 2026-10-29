package com.jafdel.lil.springroom.data.repository;

import com.jafdel.lil.springroom.data.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {

}

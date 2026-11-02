package com.jafdel.lil.springroom.service;

import com.jafdel.lil.springroom.data.entity.RoomEntity;
import com.jafdel.lil.springroom.data.repository.RoomRepository;
import com.jafdel.lil.springroom.web.model.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        List<RoomEntity> roomEntities = this.roomRepository.findAll();
        List<Room> rooms = new ArrayList<>(roomEntities.size());
        roomEntities.forEach(e -> rooms.add(getRoomFromEntity(e)));
        return rooms;
    }

    public Room getRoomById(UUID id) {
        Optional<RoomEntity> roomEntity = this.roomRepository.findById(id);
        if (roomEntity.isEmpty())
            return null;
        else
            return this.getRoomFromEntity(roomEntity.get());
    }

    public Room addRoom(Room room) {
        RoomEntity roomEntity = this.getRoomEntityFromRoom(room);
        roomEntity = this.roomRepository.save(roomEntity);
        return this.getRoomFromEntity(roomEntity);
    }

    public Room updateRoom(Room room) {
        RoomEntity roomEntity = this.getRoomEntityFromRoom(room);
        roomEntity = this.roomRepository.save(roomEntity);
        return this.getRoomFromEntity(roomEntity);
    }

    public void deleteRoom(UUID id) {
        this.roomRepository.deleteById(id);
    }

    private Room getRoomFromEntity(RoomEntity roomEntity) {
        return new Room(roomEntity.getRoomId(), roomEntity.getName(), roomEntity.getNumber(), roomEntity.getBedInfo());
    }

    private RoomEntity getRoomEntityFromRoom(Room room) {
        return new RoomEntity(room.getId(), room.getName(), room.getNumber(), room.getInfo());
    }
}

package com.jafdel.lil.springroom.async;

import com.jafdel.lil.springroom.service.RoomService;
import com.jafdel.lil.springroom.web.model.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

@Component
public class RoomCleanerListener {
    private static final Logger LOG = LoggerFactory.getLogger(RoomCleanerListener.class);
    private final ObjectMapper mapper;
    private final RoomService roomService;

    public RoomCleanerListener(ObjectMapper mapper, RoomService roomService) {
        this.mapper = mapper;
        this.roomService = roomService;
    }

    public void receiveMessage(String message) {
        try {
            AsyncPayload payload = mapper.readValue(message, AsyncPayload.class);
            if("ROOM".equals(payload.getModel())) {
                Room room = roomService.getRoomById(payload.getId());
                LOG.info("ROOM {}:{} needs to be cleaned", room.getNumber(), room.getName());
            } else
                LOG.warn("Unknown model type");

        } catch (JacksonException e) {
            e.printStackTrace();
        }
    }
}

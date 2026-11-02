package com.jafdel.lil.springroom.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="ROOMS")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="ROOM_ID")
    private UUID roomId;
    @Column(name="NAME")
    private String name;
    @Column(name="NUMBER")
    private String number;
    @Column(name="BED_INFO")
    private String bedInfo;
}

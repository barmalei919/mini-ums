package com.ums.mini_ums.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "channels")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ChannelType type;

    public enum ChannelType {
        SMS, EMAIL, PUSH
    }
}
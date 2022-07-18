package com.mainul35.bsuserinfo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_connections")
public class UserConnection {

    @EmbeddedId
    private UserConnectionId userConnectionId;
    @Enumerated(EnumType.STRING)
    private ConnectionStatus connectionStatus;
}


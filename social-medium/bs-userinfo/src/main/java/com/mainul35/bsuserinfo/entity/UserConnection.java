package com.mainul35.bsuserinfo.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_connections")
public class UserConnection {

    @EmbeddedId
    private UserConnectionId userConnectionId;
    private ConnectionStatus connectionStatus;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
class UserConnectionId implements Serializable {
    @Serial
    private static final long serialVersionUID = -5259789512124211493L;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "connection_id")
    private UserEntity connectionId;
}

enum ConnectionStatus {
    REQUESTED,
    ACCEPTED,
    REJECTED,
    BLOCKED
}

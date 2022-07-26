package com.mainul35.bsuserinfo.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_connections")
public class UserConnection {
    public UserConnection(UserConnectionId userConnectionId, ConnectionStatus connectionStatus) {
        this.userConnectionId = userConnectionId;
        this.connectionStatus = connectionStatus;
    }

    @EmbeddedId
    private UserConnectionId userConnectionId;
    @Enumerated(EnumType.STRING)
    private ConnectionStatus connectionStatus;
    @Column
    private String requestedById;
    @Column
    private String blockedById;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserConnection that = (UserConnection) o;
        return userConnectionId != null && Objects.equals(userConnectionId, that.userConnectionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userConnectionId);
    }
}


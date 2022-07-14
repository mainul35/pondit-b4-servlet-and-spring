package com.mainul35.bsuserinfo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tbl_user")
public class UserEntity {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;
    @Column(name = "profile_image_path")
    private String profileImagePath;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_connections",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "connection_id", referencedColumnName = "id")}
    )
    private Set<UserEntity> connections;
}

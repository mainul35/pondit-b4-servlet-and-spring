package com.pondit.b4.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "story")
public class Story {

    @Id
    @Column(name = "st_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    //    @Column(name = "userId")
    private long userId;

    @Column(name = "description")
    private String description;

    @Column(name = "privacy")
    private String privacy;

    //    @Column(name = "locationId")
    private long locationId;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "status_attachments",
            joinColumns = {@JoinColumn(name = "story_id", referencedColumnName = "st_id")},
            inverseJoinColumns = {@JoinColumn(name = "attachment_id", referencedColumnName = "at_id")}
    )
    private List<Attachment> statusAttachments;
}
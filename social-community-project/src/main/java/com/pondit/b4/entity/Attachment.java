package com.pondit.b4.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Attachment {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "at_id")
    private long id;

    @Column(name = "attachment_name")
    private String attachmentName;

    @Column(name = "attachment_path")
    private String attachmentPath;

    @Column(name = "type")
    private String type;
}
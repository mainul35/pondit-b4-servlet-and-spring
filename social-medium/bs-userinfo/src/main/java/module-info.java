module bs.userinfo {

    requires java.annotation;
    requires spring.beans;
    requires spring.context;
    requires spring.data.commons;
    requires spring.tx;
    requires spring.amqp;
    requires lombok;
    requires java.persistence;
    requires spring.rabbit;
    requires spring.web;
    requires spring.data.jpa;
    requires org.hibernate.orm.core;
    requires java.validation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires spring.core;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.webmvc;
    requires org.springdoc.openapi.common;
    requires org.slf4j;

    exports com.mainul35.bsuserinfo.controllers.dtos.response;
    exports com.mainul35.bsuserinfo.controllers.dtos.request;
    exports com.mainul35.bsuserinfo.controllers.definition;
//    exports com.mainul35.bsuserinfo.services.definition;
}
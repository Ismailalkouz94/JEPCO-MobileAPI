package com.bi.jepco.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Test")
public class Test implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @Column(name = "id")
   private Long id;
   
   @Column(name = "title")
   private String title;
   
   @Column(name = "author")
   private String author;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

}

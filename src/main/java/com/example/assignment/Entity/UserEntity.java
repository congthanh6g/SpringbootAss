package com.example.assignment.Entity;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int id;

      @Column(unique = true, name = "username")
      private String username;

      @Column(name = "password")
      private String password;

      public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
      }

    public UserEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.KingICT.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    public long id;

    public String email;

    public String username;

    public String password;

    public String role;
}

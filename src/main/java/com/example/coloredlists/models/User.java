package com.example.coloredlists.models;

import com.example.coloredlists.models.base.ModelEntity;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "users")
@EntityListeners(EnableJpaAuditing.class)
public class User implements ModelEntity {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@NotBlank
private String username;

private String password;

private String ver_code;

private int verified;

    public int getId() {
        return id;
    }

    @Override
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

    public String getVer_code() {
        return ver_code;
    }

    public void setVer_code(String ver_code) {
        this.ver_code = ver_code;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }
}

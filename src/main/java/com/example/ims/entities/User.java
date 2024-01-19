package com.example.ims.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String email;
    private String passwordHash;
    private boolean verified;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;

    public UUID getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public boolean isVerified() {
        return this.verified;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPasswordHash(String hash) {
        this.passwordHash = hash;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.andersenlab.adamovichjr.model;


import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

public class UserAccountDto {

    private Long id;
    @Pattern(regexp = "^[A-Za-z]{3,16}$", message = "User name must consist of latin letters and be 3-16 characters long")
    private String userName;
    @Pattern(regexp = "^((?=.*\\d)(?=.*[A-Za-z])(?!.*\\s).*){3,16}$",
            message = "Only latin characters and numbers.\n" +
            "At least one character;\n" +
            "At least one digit.")
//    @Null
    private String password;
    @Pattern(regexp = "^[A-Za-z]{1,16}$", message = "User first name must consist of latin letters and be less than 16 characters long")
    private String firstName;
    @Pattern(regexp = "^[A-Za-z]{1,16}$", message = "User last name must consist of latin letters and be less than 16 characters long")
    private String lastName;
    private LocalDateTime createdAt;
    private Role role;
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(!password.equals("")) {
            this.password = password;
        }else {
            this.password = null;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

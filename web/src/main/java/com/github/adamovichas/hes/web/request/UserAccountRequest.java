package com.github.adamovichas.hes.web.request;

import com.github.adamovichas.hes.model.Role;
import com.github.adamovichas.hes.model.Status;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

public class UserAccountRequest {

    private Long id;
    @Pattern(regexp = "^[A-Za-z]{3,16}$", message = "User name must consist of latin letters and be 3-16 characters long")
    private String userName;
    @Pattern(regexp = "^((?=.*\\d)(?=.*[A-Za-z])(?!.*\\s).*){3,16}$",
            message = "Only latin characters and numbers.\n" +
                    "At least one character;\n" +
                    "At least one digit.")
    private String Password;
    @Pattern(regexp = "^[A-Za-z]{1,16}$", message = "User first name must consist of latin letters and be less than 16 characters long")
    private String firstName;
    @Pattern(regexp = "^[A-Za-z]{1,16}$", message = "User last name must consist of latin letters and be less than 16 characters long")
    private String lastName;
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
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
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

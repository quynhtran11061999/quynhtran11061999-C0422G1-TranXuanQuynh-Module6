package com.example.model;

public class LoginRequest {
    private String email;
    private String password;
    private Long id ;

    public LoginRequest(String email, String password, Long id) {
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public LoginRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package com.example.spinners.model;

public class AuthTest {

    private String email;
    private String password;

    public AuthTest(String e, String p) {
        email = e;
        password = p;
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

}

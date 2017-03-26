package com.example.spinners.model;

public class AuthResponseTest {

    public AuthToken getData() {
        return data;
    }

    public void setData(AuthToken data) {
        this.data = data;
    }

    public AuthToken data;

    public AuthResponseTest(AuthToken data) {
        this.data = data;
    }

    public class AuthToken {

        public String getToken() {
            return access_token;
        }

        public void setToken(String token) {
            this.access_token = token;
        }

        private String access_token;

        public AuthToken(String token){
            this.access_token = token;
        }
    }
}

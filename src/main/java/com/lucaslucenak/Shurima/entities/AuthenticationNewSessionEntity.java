package com.lucaslucenak.Shurima.entities;

public class AuthenticationNewSessionEntity {

    private String accessToken;
    private String type;
    private Long expiresIn;

    public AuthenticationNewSessionEntity() {
    }

    public AuthenticationNewSessionEntity(String accessToken, String type, Long expiresIn) {
        this.accessToken = accessToken;
        this.type = type;
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
}

package com.lucaslucenak.Shurima.services;

import com.lucaslucenak.Shurima.entities.AuthenticationNewSessionEntity;
import com.sun.net.httpserver.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${ifood.credentials.merchantApiHost}")
    private String merchantApiHost;

    @Value("${ifood.credentials.grantType}")
    private String grantType;

    @Value("${ifood.credentials.clientId}")
    private String clientId;

    @Value("${ifood.credentials.clientSecret}")
    private String clientSecret;

    public AuthenticationNewSessionEntity getNewSession() {
        String url = merchantApiHost + "/authentication/v1.0/oauth/token";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        // Body x-www-form-urlencoded
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grantType", grantType);
        body.add("clientId", clientId);
        body.add("clientSecret", clientSecret);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);
        ResponseEntity<AuthenticationNewSessionEntity> newSession = restTemplate.exchange(url, HttpMethod.POST, request, AuthenticationNewSessionEntity.class);

        return newSession.getBody();
    }


}

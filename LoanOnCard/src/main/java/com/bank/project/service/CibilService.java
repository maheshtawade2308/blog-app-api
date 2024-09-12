package com.bank.project.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.project.model.CibilResponse;

@Service
public class CibilService {

    @Value("${cibil.api.url}")
    private String cibilApiUrl;

    @Value("${cibil.api.key}")
    private String apiKey;

    public int getCibilScore(String panNumber) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s/score?pan=%s&apiKey=%s", cibilApiUrl, panNumber, apiKey);
        CibilResponse response = restTemplate.getForObject(url, CibilResponse.class);
        return response != null ? response.getScore() : 0;
    }
}

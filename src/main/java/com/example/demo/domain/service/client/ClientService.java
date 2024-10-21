package com.example.demo.domain.service.client;

import com.example.demo.domain.bo.Client;


public interface ClientService {
    Client recupereClient(String reference) throws Exception;
}

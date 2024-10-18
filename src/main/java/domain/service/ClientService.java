package domain.service;

import domain.bo.Client;

public interface ClientService {
    Client findClient(String reference) throws Exception;
}

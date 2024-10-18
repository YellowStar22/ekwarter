package domain.service;

import domain.bo.Client;
import domain.bo.Particulier;

public class ClientServiceImpl implements ClientService {


    public ClientServiceImpl(){}

    public Client findClient(String reference){
        Client client = new Particulier.Builder().build();
        return client;
    }
}

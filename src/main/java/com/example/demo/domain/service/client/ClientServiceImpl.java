package com.example.demo.domain.service.client;

import com.example.demo.domain.bo.Client;
import com.example.demo.domain.exception.ClientException;
import com.example.demo.infrastructure.ParticulierRepository;
import com.example.demo.infrastructure.ProfessionnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    ParticulierRepository particulierRepository;
    ProfessionnelRepository professionnelRepository;

    @Autowired
    public ClientServiceImpl(ParticulierRepository particulierRepository, ProfessionnelRepository professionnelRepository){
        this.particulierRepository = particulierRepository;
        this.professionnelRepository = professionnelRepository;
    }

    public Client recupereClient(String reference) throws ClientException {
        this.validerReferenceClient(reference);
        Client client = this.particulierRepository.recupereParticulier(reference);
        if(client == null){
            client = this.professionnelRepository.recupereProfessionnel(reference);
        }
        if(client == null){
            throw new ClientException("Impossible de recuperer le client");
        }
        return client;
    }

    private void validerReferenceClient(String reference) throws ClientException {
        if (reference == null || !reference.matches("EKW\\d{8}")) {
            throw new ClientException("Erreur sur le format de la reference client");
        }
    }
}

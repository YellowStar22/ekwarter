package com.example.demo.domain.service.facturation;

import com.example.demo.domain.bo.*;
import com.example.demo.domain.service.calculateur.CalculateurFacture;
import com.example.demo.domain.service.calculateur.CalculateurFactureParticulier;
import com.example.demo.domain.service.calculateur.CalculateurFactureProfessionnel;
import com.example.demo.domain.service.client.ClientService;
import com.example.demo.domain.service.consommation.ConsommationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FacturationServiceImpl implements FacturationService {

    private ClientService clientService;
    private ConsommationService consommationService;


    @Autowired
    public FacturationServiceImpl(ConsommationService consommationService, ClientService clientService) {
        this.clientService = clientService;
        this.consommationService = consommationService;
    }

    public double facturation(String reference, LocalDate date) throws Exception {
        Client client = this.clientService.recupereClient(reference);
        Consommation consommation = this.consommationService.recupereConsommationClient(reference,date);
        CalculateurFacture calculateurFacture = this.definirCalculateur(client);
        return calculateurFacture.calculerFacture(consommation);
    }

    private CalculateurFacture definirCalculateur(Client client){
        if( client.isProfessionel()){
            return new CalculateurFactureProfessionnel(client);
        }else{
            return new CalculateurFactureParticulier();
        }

    }
}

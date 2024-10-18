package domain.service;

import domain.bo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FacturationServiceImpl implements FacturationService {

    @Autowired
    public ClientService clientService;

    @Autowired
    public ConsommationService consommationService;

    public Facture facturation(String reference, LocalDate date) throws Exception {

        Client client = this.clientService.findClient(reference);
        Consommation consommation = this.consommationService.getClientConsommation(reference);
        Contrat contrat = this.defineContrat(client);
        double total = this.calculFacture(consommation, contrat);
        return new Facture(total);
    }

    private double calculFacture(Consommation consommation, Contrat contrat){
        return consommation.getElectricity() * contrat.getElectricityPrice() + consommation.getGaz() * contrat.getGazPrice();
    }

    private Contrat defineContrat(Client client) throws Exception{
        if( client instanceof Professionnel){
            return ((Professionnel) client).isHautChiffreAffaire() ? Contrat.PROFESSIONNEL_PLUS : Contrat.PROFESSIONNEL_MOINS ;
        }else if (client instanceof Particulier){
            return Contrat.PARTICULIER;
        }
        throw new Exception("");

    }
}

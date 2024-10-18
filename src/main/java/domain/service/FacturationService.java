package domain.service;

import domain.bo.Facture;

import java.time.LocalDate;

public interface FacturationService {

    public Facture facturation(String reference, LocalDate date) throws Exception;
}

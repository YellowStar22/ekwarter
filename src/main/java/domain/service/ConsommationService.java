package domain.service;

import domain.bo.Consommation;

public interface ConsommationService {

    Consommation getClientConsommation(String reference) throws Exception;
}

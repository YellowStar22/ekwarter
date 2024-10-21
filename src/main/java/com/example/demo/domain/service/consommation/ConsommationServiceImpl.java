package com.example.demo.domain.service.consommation;

import com.example.demo.domain.bo.Consommation;
import com.example.demo.domain.exception.ConsommationException;
import com.example.demo.infrastructure.ConsommationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ConsommationServiceImpl implements ConsommationService{

    ConsommationRepository consommationRepository;
    @Autowired
    public ConsommationServiceImpl(ConsommationRepository consommationRepository) {
        this.consommationRepository = consommationRepository;
    }

    @Override
    public Consommation recupereConsommationClient(String reference, LocalDate date) throws ConsommationException {
        try {
            return consommationRepository.recupereConsommation(reference, date);
        } catch (Exception e) {
            throw new ConsommationException("Impossible de recuperer la consommation du client");
        }
    }
}

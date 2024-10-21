package com.example.demo.domain.service.consommation;

import com.example.demo.domain.bo.Consommation;

import java.time.LocalDate;

public interface ConsommationService {

    Consommation recupereConsommationClient(String reference, LocalDate date) throws Exception;
}

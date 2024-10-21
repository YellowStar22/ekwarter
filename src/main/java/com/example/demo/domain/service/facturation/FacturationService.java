package com.example.demo.domain.service.facturation;

import java.time.LocalDate;

public interface FacturationService {
    double facturation(String reference, LocalDate date) throws Exception;
}

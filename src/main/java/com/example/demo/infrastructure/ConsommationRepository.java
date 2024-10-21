package com.example.demo.infrastructure;

import com.example.demo.domain.bo.Consommation;
import com.example.demo.infrastructure.entity.ConsommationEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


public interface ConsommationRepository  {
    Consommation recupereConsommation(String reference, LocalDate date);
}

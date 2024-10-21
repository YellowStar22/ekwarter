package com.example.demo.infrastructure.mock;

import com.example.demo.domain.bo.Consommation;
import com.example.demo.infrastructure.ConsommationRepository;
import com.example.demo.infrastructure.adapter.ConsomationAdapter;
import com.example.demo.infrastructure.entity.ConsommationEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class ConsommationData implements ConsommationRepository {

    @Override
    public Consommation recupereConsommation(String reference, LocalDate date) {
        ConsommationEntity consommation = null;
        switch (reference){
            case "EKW00000001":
                consommation = this.recupereConsommation(date);
                break;
            case "EKW00000002":
                consommation =this.recupereConsommation(date);
                break;
            case "EKW00000003":
                consommation = this.recupereConsommation(date);
                break;
            case "EKW00000004":
                consommation =this.recupereConsommation(date);
                break;
        }
        return ConsomationAdapter.mapperVersModele(consommation);
    }

    public ConsommationEntity recupereConsommation(LocalDate date) {
        if(date.getMonth().equals(Month.JANUARY) || date.getMonth().equals(Month.FEBRUARY) || date.getMonth().equals(Month.MARCH) || date.getMonth().equals(Month.APRIL) || date.getMonth().equals(Month.MAY)){
            return new ConsommationEntity(10000 , 20000);
        }
        if(date.getMonth().equals(Month.JUNE) || date.getMonth().equals(Month.JULY) || date.getMonth().equals(Month.AUGUST) || date.getMonth().equals(Month.SEPTEMBER) || date.getMonth().equals(Month.OCTOBER) || date.getMonth().equals(Month.NOVEMBER) || date.getMonth().equals(Month.DECEMBER)){
            return new ConsommationEntity(250 , 150);
        }

        return null;
    }

}

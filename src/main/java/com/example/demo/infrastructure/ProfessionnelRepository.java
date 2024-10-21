package com.example.demo.infrastructure;

import com.example.demo.domain.bo.Professionnel;

public interface ProfessionnelRepository {
    Professionnel recupereProfessionnel(String reference) ;
}

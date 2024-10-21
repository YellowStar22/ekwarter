package com.example.demo.infrastructure;

import com.example.demo.domain.bo.Particulier;
import com.example.demo.infrastructure.entity.ParticulierEntity;
import org.springframework.stereotype.Component;


public interface ParticulierRepository {
    Particulier recupereParticulier(String reference);
}

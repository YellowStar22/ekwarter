package com.example.demo.controller;

import com.example.demo.domain.service.facturation.FacturationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


@Controller( "facturationController")
@RequestMapping("factures")
public class FacturationControllerImpl {

    FacturationService facturationService;

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Autowired
    public FacturationControllerImpl(FacturationService facturationService) {
        this.facturationService = facturationService;
    }

    @GetMapping("/client/{reference}")
    public ResponseEntity facture(@PathVariable(name = "reference") String reference, @RequestParam("mois") String mois , @RequestParam("annee") String annee){
        try {
            var total = this.facturationService.facturation(reference, this.valideDateParameter(mois,annee));
            return ResponseEntity.ok(total);
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    private LocalDate valideDateParameter(String mois , String annee){
        try {
            return LocalDate.parse("01/" + mois + "/" + annee, formatter);
        }catch (DateTimeParseException e){
            throw new DateTimeParseException("Les parametres de mois/annee ne sont pas correctes" , "Mois :" + mois + "Annee : " + annee , 0);
        }
    }
}

package controller;

import controller.dto.FactureDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@RequestMapping("client/{reference}/facture")
public interface FacturationController {

    @GetMapping("")
    public FactureDTO facture(String reference, LocalDate localDate);
}

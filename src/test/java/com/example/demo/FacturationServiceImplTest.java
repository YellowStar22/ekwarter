package com.example.demo;

import com.example.demo.domain.bo.*;
import com.example.demo.domain.service.client.ClientService;
import com.example.demo.domain.service.consommation.ConsommationService;
import com.example.demo.domain.service.facturation.FacturationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FacturationServiceImplTest {

    @InjectMocks
    private FacturationServiceImpl facturationService;

    @Mock
    private ClientService clientService;

    @Mock
    private ConsommationService consommationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void testCalculFacturePourParticulier() throws Exception {
        String reference = "client123";
        LocalDate date = LocalDate.now();

        Client client = new Particulier.Builder().nom("EkwarterN").prenom("EkwarterP").civilite(Civilite.MONSIEUR).build();
        Consommation consommation = new Consommation(100,200);

        when(clientService.recupereClient("client123")).thenReturn(client);
        when(consommationService.recupereConsommationClient(anyString(),any())).thenReturn(consommation);

        assertEquals(facturationService.facturation(reference, date), 100 * 0.121 + 200 * 0.115);
    }

    @Test
    public void testCalculFacturePourProfessionnelPlus() throws Exception {
        String reference = "client123";
        LocalDate date = LocalDate.now();

        Client client = new Professionnel.Builder().raisonSociale("Exemple SA").siret("").chiffreAffaire(100000.01).reference("client123").build();
        Consommation consommation = new Consommation(100,200);

        when(clientService.recupereClient("client123")).thenReturn(client);
        when(consommationService.recupereConsommationClient(anyString(),any())).thenReturn(consommation);
        assertEquals(facturationService.facturation(reference, date), 100 * 0.114 + 200 * 0.111);

    }

    @Test
    public void testCalculFacturePourProfessionnelMoins() throws Exception {
        String reference = "client123";
        LocalDate date = LocalDate.now();

        Client client = new Professionnel.Builder().raisonSociale("Exemple SA").siret("").chiffreAffaire(9999999).reference("client123").build();
        Consommation consommation = new Consommation(100,200);

        when(clientService.recupereClient("client123")).thenReturn(client);
        when(consommationService.recupereConsommationClient(anyString(),any())).thenReturn(consommation);
        assertEquals(facturationService.facturation(reference, date), 100 * 0.118 + 200 * 0.113);

    }
}
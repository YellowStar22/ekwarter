package domain.service;

import domain.bo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    public void testDefineContratForParticuler() throws Exception {
        String reference = "client123";
        LocalDate date = LocalDate.now();

        Client client = new Particulier.Builder().nom("EkwarterN").prenom("EkwarterP").civilite(Civilite.MONSIEUR).build();
        Consommation consommation = new Consommation(100,200);

        when(clientService.findClient("client123")).thenReturn(client);
        when(consommationService.getClientConsommation(anyString())).thenReturn(consommation);

        Facture facture = facturationService.facturation(reference, date);

        // Vérifiez que la facture n'est pas nulle
        assertEquals(facture.getTotal(), 100 * 0.121 + 200 * 0.115);
    }

    @Test
    public void testDefineContratForProfessionnelPlus() throws Exception {
        String reference = "client123";
        LocalDate date = LocalDate.now();

        Client client = new Professionnel.Builder().raisonSociale("Exemple SA").siret("").chiffreAffaire(100000.02).reference("client123").build();
        Consommation consommation = new Consommation(100,200);

        when(clientService.findClient("client123")).thenReturn(client);
        when(consommationService.getClientConsommation(anyString())).thenReturn(consommation);

        Facture facture = facturationService.facturation(reference, date);

        assertEquals(facture.getTotal(), 100 * 0.114 + 200 * 0.111);

    }

    @Test
    public void testFacturation() throws Exception {
        String reference = "client123";
        LocalDate date = LocalDate.now();

        Client client = new Professionnel.Builder().raisonSociale("Exemple SA").siret("").chiffreAffaire(9999999).reference("client123").build();
        Consommation consommation = new Consommation(100,200);

        when(clientService.findClient("client123")).thenReturn(client);
        when(consommationService.getClientConsommation(anyString())).thenReturn(consommation);

        Facture facture = facturationService.facturation(reference, date);

        assertEquals(facture.getTotal(), 100 * 0.118 + 200 * 0.113);

    }
}
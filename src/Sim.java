import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Sim {
    private CodiceAlfanumerico codiceSim;
    private NumeroTelefonico numeroTelefonico;
    private Date attivazioneSim;
    private Double creditoResiduo;
    private HashMap<NumeroTelefonico, Date> registroChiamate;
    private Promozione promozione;
    private Date rinnovoPromo;

    /**
     * Contructor di una nuova Sim
     */
    public Sim() {
        codiceSim = new CodiceAlfanumerico();
        numeroTelefonico = new NumeroTelefonico();
        attivazioneSim = new Date();
        creditoResiduo = 0.0;
        registroChiamate = null;
        promozione = null;
        rinnovoPromo = null;
    }

    /**
     * Constructor per creare una nuova Sim da un numero telefonico già esistente
     * @param numeroTelefonico
     */
    public Sim(NumeroTelefonico numeroTelefonico) {
        codiceSim = new CodiceAlfanumerico();
        this.numeroTelefonico = numeroTelefonico;
        attivazioneSim = new Date();
        creditoResiduo = 0.0;
        registroChiamate = null;
        promozione = null;
        rinnovoPromo = null;
    }

    /**
     * stampa nel formato dd/MM/yyyy la data di attivazione della Sim
     */
    public void printSimActivationDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(dateFormat.format(attivazioneSim));
    }
}

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import Eccezioni.*;


/**
 * classe per la gestione di una sim specifica e i suoi dati
 */
public class Sim {
    private CodiceNumericoSim codiceSim;
    private NumeroTelefonico numeroTelefonico;
    private Date attivazioneSim;
    private Double creditoResiduo;
    private HashMap<NumeroTelefonico, Time> registroChiamate;
    private Promozione promozione;
    private Date rinnovoPromo;
    private Time minuti;
    private int sms;
    private Byte internet;

    /**
     * Contructor di una nuova Sim
     */
    public Sim() {
        codiceSim = new CodiceNumericoSim();
        numeroTelefonico = new NumeroTelefonico();
        attivazioneSim = new Date();
        creditoResiduo = 0.0;
        registroChiamate = null;
        promozione = null;
        rinnovoPromo = null;
        minuti = null;
        sms = 0;
        internet = null;
    }

    /**
     * Constructor per creare una nuova Sim da un numero telefonico già esistente
     * @param numeroTelefonico
     */
    public Sim(NumeroTelefonico numeroTelefonico) {
        codiceSim = new CodiceNumericoSim();
        this.numeroTelefonico = numeroTelefonico;
        attivazioneSim = new Date();
        creditoResiduo = 0.0;
        registroChiamate = null;
        promozione = null;
        rinnovoPromo = null;
        minuti = null;
        sms = 0;
        internet = null;
    }

    /**
     * stampa nel formato dd/MM/yyyy la data di attivazione della Sim
     */
    public void stampaAttivazioneSim(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(dateFormat.format(attivazioneSim));
    }

    /**
     *
     * @return il codice seriale univoco della Sim generata
     */
    public CodiceNumerico getCodiceSim() {
        return codiceSim;
    }

    /**
     *
     * @return il numero telefonico associato alla Sim
     */
    public NumeroTelefonico getNumeroTelefonico() {
        return numeroTelefonico;
    }

    /**
     * metodo per accreditare denaro nella Sim
     * @param importo importo da sommare al credito rimanente
     */
    public void ricarica(int importo){
        creditoResiduo += importo;
    }

    /**
     *
     * @return il credito restante sulla Sim
     */
    public Double getCreditoResiduo() {
        return creditoResiduo;
    }

    /**
     * aggiunta di una promozione alla Sim e settaggio della data di rinnovo
     * @param promozione tipo di promozione
     */
    public void setPromozione(Promozione promozione) {
        this.promozione = promozione;
        creditoResiduo -= promozione.getCosto();
        rinnovoPromo = new Date();
        minuti = promozione.getMinutiMax();
        sms = promozione.getSmsMax();
        internet = promozione.getInternetMax();
    }

    /**
     *
     * @return tipo di promozione attivo
     */
    public Promozione getPromozione() {
        return promozione;
    }

    /**
     *
     * @return data del rinnovo della promozione
     */
    public Date getRinnovoPromo() {
        return rinnovoPromo;
    }

    /**
     * stampa la data del rinnovo promozione
     */
    public void stampaRinnovoPromo(){
        System.out.println(rinnovoPromo);
    }

    /**
     * aggiunge al registro chiamate i dati riguardanti la chiamata effettuata
     * e sottrae la durata dai minuti restanti della promozione
     * @param numeroComposto numero chiamato con la seguente Sim
     * @param durata durata della chiamata
     * @throws MinutiFiniti se i minuti della promozione sono <=0
     */
    public void chiamata(NumeroTelefonico numeroComposto, Time durata) throws MinutiFiniti{
        if(minuti.getTime()>0){
            registroChiamate.put(numeroComposto,durata);
            minuti.setTime(minuti.getTime() - durata.getTime());
        } else{
            throw new MinutiFiniti();
        }

    }

    /**
     *
     * @return il Set del registro chiamate <Numeri,Durata>
     */
    public Set getRegistroChiamate(){
        return registroChiamate.entrySet();
    }

    /**
     * crea una nuova HashMap contenente solo le chiamate a numero scelto
     * e ne ritorna il suo set
     * @param numeroScelto numero specifico a cui sono state effettuate chiamate
     * @return il set del registro chiamate del solo numero scelto
     * @throws NumeroMaiChiamato se il numero scelto non è mai stato chiamato
     */
    public Set getChiamateSpecifiche(NumeroTelefonico numeroScelto) throws NumeroMaiChiamato{
        HashMap<NumeroTelefonico,Time> registroSpecifico = null;

        if(!registroChiamate.containsKey(numeroScelto)){
            throw new NumeroMaiChiamato();
        }

        Set set = registroChiamate.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()){
            Map.Entry lista = (Map.Entry) it.next();
            if(lista.getKey().equals(numeroScelto)){
                registroSpecifico.put((NumeroTelefonico) lista.getKey(), (Time) lista.getValue());
            }
        }

        return registroSpecifico.entrySet();
    }

    /**
     *
     * @return i minuti restanti della promozione
     */
    public Time getMinuti(){
        return minuti;
    }

    /**
     *
     * @return la quantità di sms rimanenti
     */
    public int getSms() {
        return sms;
    }

    /**
     *
     * @return la quantità di byte traffico internet restanti
     */
    public Byte getInternet() {
        return internet;
    }
}

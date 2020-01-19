import java.sql.Time;

/**
 * classe per la gestione delle promozioni attivabili.
 * al momento della creazione la promozione è disattiva
 * e verrà attivata dal suo gestore
 */
public class Promozione {
    private String nome;
    private Double costo;
    private TipiPromozioni tipo;
    private Variazione aggiunte;
    private Time minutiMax;
    private int smsMax;
    private Byte internetMax;
    private boolean attiva;

    /**
     * Contructor
     * @param nome nome della promozione
     * @param costo costo mensile della promozione
     * @param tipo tipo di promozione
     */
    public Promozione(String nome, Double costo, TipiPromozioni tipo) {
        this.nome = nome;
        this.costo = costo;
        this.tipo = tipo;
        aggiunte = null;
        attiva = false;
    }

    /**
     * aggiunge le quantità massime di minuti, messaggi e internet in base al
     * tipo di promozione
     * @param minuti minuti
     * @param messaggi messaggi
     * @param trafficoDati internet
     */
    public void setQuantita(Time minuti, int messaggi, Byte trafficoDati){
        switch (tipo){
            case ALL:
                minutiMax=minuti;
                smsMax=messaggi;
                internetMax=trafficoDati;

            case MINUTI:
                minutiMax=minuti;

            case SMS:
                smsMax=messaggi;

            case INTERNT:
                internetMax=trafficoDati;
        }
    }

    /**
     * aggiunge delle variazioni alla promozione
     * @param aggiunte tipo di variazione da aggiungere
     */
    public void setAggiunte(Variazione aggiunte) {
        this.aggiunte = aggiunte;
        costo += aggiunte.getPrezzo();
    }

    /**
     *
     * @return nome della promozione
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return costo della promozione
     */
    public Double getCosto() {
        return costo;
    }

    /**
     *
     * @return tipo di promozione
     */
    public TipiPromozioni getTipo() {
        return tipo;
    }

    /**
     *
     * @return minuti massimi forniti dalla promozione
     */
    public Time getMinutiMax() {
        return minutiMax;
    }

    /**
     *
     * @return sms massimi forniti dalla promozione
     */
    public int getSmsMax() {
        return smsMax;
    }

    /**
     *
     * @return byte massimi forniti dalla promozione
     */
    public Byte getInternetMax() {
        return internetMax;
    }

    /**
     * attiva la promozione
     */
    public void Attiva(){
        attiva=true;
    }

    /**
     * disattiva la promozione
     */
    public void Disattiva(){
        attiva = false;
    }

}


/**
 * classe per le variazioni aggiungibili alle promozioni
 */
public class Variazione {
    private String nome;
    private Double prezzo;

    /**
     * Constructor
     * @param nome nome della variazione
     * @param prezzo prezzo aggiuntivo
     */
    public Variazione(String nome, Double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    /**
     *
     * @return nome variazione
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return costo aggiuntivo
     */
    public Double getPrezzo() {
        return prezzo;
    }
}


/**
 * Classe per i numeri telefonici da assegnare alle Sim
 */
public class NumeroTelefonico {
    private static final char simboloIniziale = '+';
    private CodiceNumericoPre prefisso;
    private CodiceNumericoSuf suffisso;

    /**
     * Crea un numero telefonico casuale
     */
    public NumeroTelefonico() {
        prefisso = new CodiceNumericoPre();
        suffisso = new CodiceNumericoSuf();
    }

    /**
     * Crea un nuovo numero dati prefisso e suffisso
     * @param prefisso prefisso del numero
     * @param suffisso suffisso del numero
     */
    public NumeroTelefonico(CodiceNumericoPre prefisso, CodiceNumericoSuf suffisso) {
        this.prefisso = prefisso;
        this.suffisso = suffisso;
    }

    /**
     *
     * @return simbolo iniziale
     */
    public static char getSimboloIniziale() {
        return simboloIniziale;
    }

    /**
     *
     * @return prefisso del numero
     */
    public CodiceNumericoPre getPrefisso() {
        return prefisso;
    }

    /**
     *
     * @return suffisso del numero
     */
    public CodiceNumericoSuf getSuffisso() {
        return suffisso;
    }

    /**
     * Verificare che due numeri telefonici siano uguali
     * @param daVerificare numero telefonico da verificare
     * @return true se uguali, false altrimenti
     */
    public boolean equals(NumeroTelefonico daVerificare){
        if(this.prefisso == daVerificare.getPrefisso() && this.suffisso == daVerificare.getSuffisso()){
            return true;
        }else{
            return false;
        }
    }
}

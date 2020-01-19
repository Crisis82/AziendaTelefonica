
/**
 * interfaccia per gestire codici numerici univoci
 */
public interface CodiceNumerico<T> {

    void nuovoNumero(CodiceNumerico<T> nuovo);
    void rimuoviNumero(CodiceNumerico<T> rimuovi);
    void controlla(CodiceNumerico<T> daVerificare);
}

import Eccezioni.PromozioneGiaAttiva;
import Eccezioni.PromozioneInesistente;

/**
 * interfaccia per la gestione
 * @param <T> tipo di gestore
 */
public interface Gestore<T> {

    void aggiungi(T daAggiungere) throws PromozioneGiaAttiva;
    void rimuovi(T daRimuovere) throws PromozioneInesistente;
    boolean presente(T daControllare);
}

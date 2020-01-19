import java.sql.Time;

public class CodiceNumericoPre implements CodiceNumerico<Prefisso> {
    private CodiceNumerico<Prefisso> codice;

    @Override
    public void nuovoNumero(CodiceNumerico<Prefisso> nuovo) {
        this.codice = nuovo;
    }

    @Override
    public void rimuoviNumero(CodiceNumerico<Prefisso> rimuovi) {

    }

    @Override
    public void controlla(CodiceNumerico<Prefisso> daVerificare) {

    }
}

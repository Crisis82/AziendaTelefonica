public class CodiceNumericoSuf implements CodiceNumerico<Suffisso> {
    private CodiceNumerico<Suffisso> codice;

    @Override
    public void nuovoNumero(CodiceNumerico<Suffisso> nuovo) {
        this.codice = nuovo;
    }

    @Override
    public void rimuoviNumero(CodiceNumerico<Suffisso> rimuovi) {

    }

    @Override
    public void controlla(CodiceNumerico<Suffisso> daVerificare) {

    }
}

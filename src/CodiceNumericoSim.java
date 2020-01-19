public class CodiceNumericoSim implements CodiceNumerico<SimCode> {
    private CodiceNumerico<SimCode> codice;

    @Override
    public void nuovoNumero(CodiceNumerico<SimCode> nuovo) {
        this.codice = nuovo;
    }

    @Override
    public void rimuoviNumero(CodiceNumerico<SimCode> rimuovi) {

    }

    @Override
    public void controlla(CodiceNumerico<SimCode> daVerificare) {

    }
}

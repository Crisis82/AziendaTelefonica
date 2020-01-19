import Eccezioni.PromozioneGiaAttiva;
import Eccezioni.PromozioneInesistente;

import java.util.List;

public class GestorePromozioni implements Gestore<Promozione> {
    private List<Promozione> promozioni;

    @Override
    public void aggiungi(Promozione daAggiungere) throws PromozioneGiaAttiva {
        if(presente(daAggiungere)){
            daAggiungere.Attiva();
            promozioni.add(daAggiungere);
        }else{
            throw new PromozioneGiaAttiva();
        }
    }

    @Override
    public void rimuovi(Promozione daRimuovere) throws PromozioneInesistente{
        if(presente(daRimuovere)){
            daRimuovere.Disattiva();
            promozioni.remove(daRimuovere);
        }else{
            throw new PromozioneInesistente();
        }
    }

    @Override
    public boolean presente(Promozione daControllare) {
        boolean presenza=false;
        for (Promozione promo:promozioni) {
            if(promo.equals(daControllare)){
                presenza=true;
                break;
            }
        }
        return presenza;
    }
}

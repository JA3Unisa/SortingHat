package Storage.Risposta;

import ApplicationLogic.Http.FormMapper;
import Storage.Discussione.Discussione;
import Storage.Utente.Utente;

import javax.servlet.http.HttpServletRequest;

/*

    private GregorianCalendar dataOra;

*/
public class RispostaFormMapper implements FormMapper<Risposta> {

    @Override
    public Risposta map(HttpServletRequest request, Boolean update) {
        Risposta risposta = new Risposta();
        Utente ut=new Utente();

        //ut.setIdUtente(Integer.parseInt(request.getParameter("idUtente")));
        ut.setIdUtente(0);
        risposta.setUtente(ut);

        Discussione discussione=new Discussione();
        discussione.setIdDiscussione(Integer.parseInt(request.getParameter("Discussione")));

        risposta.setDiscussione(discussione);
        //risposta.setDataOra(GregorianCalendar.getInstance());
        risposta.setCorpo(request.getParameter("Corpo"));
        if (update) {
            risposta.setIdRisposta(Integer.parseInt(request.getParameter("id")));
        }
        return risposta;

    }
}


package Model.Risposta;

import Controller.Http.FormMapper;
import Model.Categoria.Categoria;
import Model.Discussione.Discussione;
import Model.Utente.Utente;

import javax.servlet.http.HttpServletRequest;
import java.util.GregorianCalendar;
/*

    private GregorianCalendar dataOra;

*/
public class RispostaFormMapper implements FormMapper<Risposta> {

    @Override
    public Risposta map(HttpServletRequest request, Boolean update) {
        Risposta risposta = new Risposta();
        Utente ut=new Utente();
        ut.setIdUtente(Integer.parseInt(request.getParameter("IdUtente")));
        risposta.setUtente(ut);
        Discussione discussione=new Discussione();
        discussione.setIdDiscussione(Integer.parseInt(request.getParameter("IdDiscussione")));
        risposta.setDiscussione(discussione);
        //risposta.setDataOra((GregorianCalendar)request.getParameter("DataOra"));
        risposta.setCorpo(request.getParameter("Corpo"));
        if (update) {
            risposta.setIdRisposta(Integer.parseInt(request.getParameter("id")));
        }
        return risposta;

    }
}


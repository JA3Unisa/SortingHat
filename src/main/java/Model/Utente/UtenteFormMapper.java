package Model.Utente;

import javax.servlet.http.HttpServletRequest;

public class UtenteFormMapper {
    public Utente map(HttpServletRequest request, Boolean update)  {
        Utente utente=new Utente();
        utente.setEmail(request.getParameter("Mail"));
        //System.out.println(cliente.getEmail()+" "+request.getParameter("Mail"));
        utente.setNome(request.getParameter("Nome"));
        //System.out.println(cliente.getNome()+" "+request.getParameter("Nome"));
        utente.setCognome(request.getParameter("Cognome"));
        utente.setUniversitario(Boolean.valueOf(request.getParameter("univesitario")));
        utente.setRuolo(Integer.parseInt(request.getParameter("ruolo")));
        System.out.println(utente.getRuolo()+" "+request.getParameter("ruolo"));
        if(update){
            System.out.println();
            utente.setIdUtente(Integer.parseInt(request.getParameter("id")));
        }
        return utente;
    }
}

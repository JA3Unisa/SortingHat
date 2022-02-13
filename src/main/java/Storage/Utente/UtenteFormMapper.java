package Storage.Utente;

import javax.servlet.http.HttpServletRequest;

public class UtenteFormMapper {
    public Utente map(HttpServletRequest request, Boolean update)  {

        Utente utente=new Utente();
        utente.setEmail(request.getParameter("Email"));
        System.out.println(utente.getEmail()+" "+request.getParameter("Email"));
        utente.setNome(request.getParameter("Nome"));
        System.out.println(utente.getNome()+" "+request.getParameter("Nome"));
        utente.setCognome(request.getParameter("Cognome"));
        utente.setRuolo(Integer.parseInt(request.getParameter("Ruolo")));
        //CHECK


        String check = request.getParameter("Universitario");
        if (check.equalsIgnoreCase("false"))
            utente.setUniversitario(false);
        else
            utente.setUniversitario(true);

        if(update){

            utente.setIdUtente(Integer.parseInt(request.getParameter("id")));
        }
        return utente;
    }
}

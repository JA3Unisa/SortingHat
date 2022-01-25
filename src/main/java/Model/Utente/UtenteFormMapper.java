package Model.Utente;

import javax.servlet.http.HttpServletRequest;

public class UtenteFormMapper {
    public Utente map(HttpServletRequest request, Boolean update)  {
        Utente utente=new Utente();
        utente.setEmail(request.getParameter("Email"));
        //System.out.println(cliente.getEmail()+" "+request.getParameter("Mail"));
        utente.setNome(request.getParameter("Nome"));
        //System.out.println(cliente.getNome()+" "+request.getParameter("Nome"));
        utente.setCognome(request.getParameter("Cognome"));
        //CHECK
        String email=request.getParameter("Email");
        if(email.contains("Studenti.unisa.it")){
            utente.setUniversitario(true);
        }else utente.setUniversitario(false);
      //  utente.setUniversitario(Boolean.valueOf(request.getParameter("univesitario")));
        utente.setRuolo(3);

        if(update){
            System.out.println();
            utente.setIdUtente(Integer.parseInt(request.getParameter("id")));
        }
        return utente;
    }
}

package Model.Utente;

import Controller.Http.RequestValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;
/* this.idUtente=idUtente;
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.password=password;
        this.universitario=universitario;
        this.ruolo=ruolo;*/
public class UtenteValidator {
    public static RequestValidator validateForm(HttpServletRequest request, Boolean update){
        RequestValidator validator=new RequestValidator(request);

        validator.assertMatch("Nome", Pattern.compile("^.{2,20}$"),"Nome compreso tra i 2 e 20 caratteri");
        validator.assertMatch("Cognome", Pattern.compile("^.{2,20}$"),"Cognome compreso tra i 2 e 20 caratteri");
        validator.assertEmail("Email","Email non valida");
        if(update){
            validator.assertInt("id","Id deve essere una cifra");
        }
        System.out.println("ERRORI"+validator.getErrors());
        return validator;
    }

    public static RequestValidator validateSignin(HttpServletRequest request,Boolean update){
        RequestValidator validator=new RequestValidator(request);
        validator.assertEmail("Email", "Email non valida");

       validator.assertMatch("Password", Pattern.compile("^\\w{2,20}$"),"Password compresa tra i 2 e 20 caratteri");
        if(update){
            validator.assertInt("id","Id deve essere una cifra");
        }
        return validator;
    }
    public static RequestValidator validateDelete(HttpServletRequest request){
        RequestValidator validator=new RequestValidator(request);
        validator.assertInt("id","Id deve essere una cifra");
        return validator;
    }
}




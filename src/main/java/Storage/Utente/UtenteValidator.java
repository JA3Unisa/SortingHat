package Storage.Utente;

import ApplicationLogic.Http.RequestValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * Questo Validator si gestisce gli Utenti
 * @return
 */

public class UtenteValidator {
    public static RequestValidator validateForm(HttpServletRequest request, Boolean update){
        RequestValidator validator=new RequestValidator(request);

        validator.assertMatch("Nome", Pattern.compile("^.{2,20}$"),"Nome compreso tra i 2 e 20 caratteri");
        validator.assertMatch("Cognome", Pattern.compile("^.{2,20}$"),"Cognome compreso tra i 2 e 20 caratteri");
        validator.assertEmail("Email","Email non valida");
        if(update){
            validator.assertBoolean("Universitario","Formato Universitario non valido , Booleano richiesto");
            validator.assertInt("id","Id deve essere una cifra");
            validator.assertRuolo("Ruolo","Formato Ruolo non valido ,int richiesto e compreso tra 0 e 1");
        }else{
            validator.assertMatch("Password",Pattern.compile("^.{2,20}"),"Password non corretta,troppo lunga");
        }

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




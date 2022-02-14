package Storage.Risposta;

import ApplicationLogic.Http.RequestValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * Validator che ci permette di gestire le risposte
 */

public class RispostaValidator {
    public static RequestValidator validateForm(HttpServletRequest request, boolean update){
        RequestValidator validator=new RequestValidator(request);
System.out.println(request.getParameter("Corpo"));
        validator.assertMatch("Corpo", Pattern.compile("^.{1,500}$"),"Il corpo non deve essere vuoto e massimo con 500 caratteri");
        if(update){
            validator.assertInt("id","Id deve essere una cifra"); }
        System.out.println("ERRORI 1 "+validator.getErrors());
        return validator;
    }
    public static RequestValidator validateDelete(HttpServletRequest request){
        RequestValidator validator=new RequestValidator(request);
        validator.assertInt("id","Id deve essere una cifra"); return validator;
    }
}
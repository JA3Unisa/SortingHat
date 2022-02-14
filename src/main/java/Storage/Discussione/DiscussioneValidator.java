package Storage.Discussione;

import ApplicationLogic.Http.RequestValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * Questo è il validator di discussione
 */
public class DiscussioneValidator  {
    public static RequestValidator validateForm(HttpServletRequest request, boolean update){
        RequestValidator validator=new RequestValidator(request);
        validator.assertMatch("Titolo", Pattern.compile("^.{2,50}$"),"Titolo compresa tra i 2 e 50 caratteri");
        validator.assertMatch("Corpo", Pattern.compile("^.{2,10000}$"),"Corpo compresa tra i 2 e 10000 caratteri");
        if(update){
            validator.assertInt("id","Id deve essere una cifra"); }
        System.out.println("ERRORI 1 "+validator.getErrors());
        return validator;
    }
    public static RequestValidator validateDelete(HttpServletRequest request){
        RequestValidator validator=new RequestValidator(request);
        validator.assertInt("id","Id deve essere una cifra");
        return validator;
    }
}


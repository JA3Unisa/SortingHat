package Model.Risposta;

import Controller.Http.RequestValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class RispostaValidator {
    public static RequestValidator validateForm(HttpServletRequest request, boolean update){
        RequestValidator validator=new RequestValidator(request);
        validator.assertMatch("Corpo", Pattern.compile("^\\w{2,30}$"),"Nome compresa tra i 2 e 30 caratteri");
        if(update){
            validator.assertInt("id","Id deve essere una cifra"); }
        return validator;
    }
    public static RequestValidator validateDelete(HttpServletRequest request){
        RequestValidator validator=new RequestValidator(request);
        validator.assertInt("id","Id deve essere una cifra"); return validator;
    }
}
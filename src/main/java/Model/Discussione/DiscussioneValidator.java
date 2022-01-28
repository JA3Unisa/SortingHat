package Model.Discussione;

import Controller.Http.RequestValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class DiscussioneValidator  {
    public static RequestValidator validateForm(HttpServletRequest request, boolean update){
        RequestValidator validator=new RequestValidator(request);
        validator.assertMatch("Titolo", Pattern.compile("^\\w{2,50}$"),"Titolo compresa tra i 2 e 50 caratteri");
        validator.assertMatch("Corpo", Pattern.compile("^\\w{2,10000}$"),"Corpo compresa tra i 2 e 10000 caratteri");
        if(update){
            validator.assertInt("id","Id deve essere una cifra"); }
        return validator;
    }
    public static RequestValidator validateDelete(HttpServletRequest request){
        RequestValidator validator=new RequestValidator(request);
        validator.assertInt("id","Id deve essere una cifra");
        return validator;
    }
}

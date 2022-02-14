package Storage.Categoria;

import ApplicationLogic.Http.RequestValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * Questo è il validator che gestisce le categorie
 */
public class CategoriaValidator {
    public static RequestValidator validateForm(HttpServletRequest request, boolean update){
        RequestValidator validator=new RequestValidator(request);
        validator.assertMatch("Nome", Pattern.compile("^.{1,20}$"),"Nome non compreso tra i 2 e 30 caratteri");
        validator.assertMatch("Descrizione",Pattern.compile("^.{1,}"),"Impossibile inserire campo vuoto");
        validator.assertMatch("TitoloDescrizione",Pattern.compile("^.{1,45}"),"Titolo non compreso tra 1 e 45 caratteri");
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
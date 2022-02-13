package ApplicationLogic.Http;

import javax.servlet.http.HttpServletRequest;

public class CommonValidator {
    public static RequestValidator validatePage(HttpServletRequest request){
        RequestValidator validator=new RequestValidator(request);
        validator.assertInt("page","Il numero di pagina deve essere in un formato valido");
        return validator;
    }
    public static RequestValidator validateId(HttpServletRequest request){ //assert verifica id
        RequestValidator validator=new RequestValidator(request);
        validator.assertInt("id","L'id deve essere in un formato valido");
        return validator;
    }
}
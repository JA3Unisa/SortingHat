package Controller.Http;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
//Verifica

public class RequestValidator {
    private final List<String> errors;//lista errori
    private final HttpServletRequest request;
    private static final Pattern INT_PATTERN = Pattern.compile("^\\d+$");//1 o più cifre
    // private static final Pattern DOUBLE_PATTERN = Pattern.compile("^(-)?(0|[1-9]\\d+)\\.\\d+$");
    //- opzionale,0 o sequenza che parte da numero tra 1 e 9, . necessario, 1 o più cifre
    private static final Pattern DOUBLE_PATTERN=Pattern.compile("([0-9]*[.])?[0-9]+");
    //- opzionale numero.valore

    public RequestValidator(HttpServletRequest request) {
        this.errors = new ArrayList<>();
        this.request = request;
    }

    public boolean hasErrors() {//se vuota= no errori
        return !errors.isEmpty();
    }

    public List<String> getErrors() {
        return errors;
    }

    private boolean gatherError(boolean conditon, String message) {//add error
        if (conditon) {
            return true;
        } else
            errors.add(message);
        return false;
    }

    private boolean required(String value) {
        return value != null && !value.isBlank();
    }//controllo se campo non opzionale

    public boolean assertMatch(String value, Pattern regexp, String msg) {
        String param = request.getParameter(value);

        boolean condition = required(param) && regexp.matcher(param).matches();//non vuoto e match con espressioni

        return gatherError(condition, msg);
    }

    //Espressioni regolari
    public boolean assertInt(String value, String msg) {
        return assertMatch(value, INT_PATTERN, msg);
    }

    public boolean assertDouble(String value, String msg) {
        return assertMatch(value, DOUBLE_PATTERN, msg);
    }

    public boolean assertEmail(String value, String msg) {
        Pattern patter = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?_^'{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
        return assertMatch(value, patter, msg);
    }
//^[a-zA-Z0-9.!#$%&'*+/=?^_'{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$
//caratteri+@+caratteri+ .+ caratteri alfabeto o numero

    public boolean assertInts(String values,String msg){//controllo pattern per ogni carattere
        String[] params=request.getParameterValues(values);
        boolean allInt= Arrays.stream(params).allMatch(param->INT_PATTERN.matcher(param).matches());
        return gatherError(allInt,msg);
    }
    public boolean assertSize(String first,String second,String msg){//controllo size due liste
        String[] firsList=request.getParameterValues(first);
        String[] secList=request.getParameterValues(second);
        return gatherError(firsList.length==secList.length,msg);
    }

}



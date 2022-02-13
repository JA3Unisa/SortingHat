package ApplicationLogic.Http;

import java.util.List;

public class Alert {
    private final List<String> messaggi;
    private final String tipo;
    public Alert(List<String> messaggi,String tipo){
        this.messaggi=messaggi;
        this.tipo=tipo;

    }
    public List<String> getMessaggi(){
        return messaggi;}
    public String getTipo(){
        return tipo;}
}



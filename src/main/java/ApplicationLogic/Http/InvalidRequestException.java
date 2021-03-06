package ApplicationLogic.Http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class InvalidRequestException extends Exception {
        private final List<String> errori;
        private final int errorCode;
   public InvalidRequestException(String msg,List<String> errori,int errorCode){
            super(msg);
            this.errori=errori;
            this.errorCode=errorCode;
        }
        public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            System.out.println("ERRORE"+errorCode);
            switch (errorCode){
                case HttpServletResponse.SC_BAD_REQUEST:
System.out.println("SC_BAD");
                    request.setAttribute("alert",new Alert(errori,"danger"));

                    String backPath=(String)request.getAttribute("back");//attributo per ritorno se fallimento

System.out.println(backPath);
                    response.setStatus(errorCode);
                    System.out.println("LLLL"+errorCode);

                    request.getRequestDispatcher(backPath).forward(request,response);
                    break;
                default:
                    response.sendError(errorCode,errori.get(0));
            }
        }

    }



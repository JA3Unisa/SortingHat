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
            switch (errorCode){
                case HttpServletResponse.SC_BAD_REQUEST:
                    request.setAttribute("alert",new Alert(errori,"danger"));
                    String backPath=(String)request.getAttribute("back");//attributo per ritorno se fallimento
                    // String backPath=request.getParameter("back");
                    response.setStatus(errorCode);
                    request.getRequestDispatcher(backPath).forward(request,response);
                    break;
                default:
                    response.sendError(errorCode,errori.get(0));
            }
        }
        public List<String> getErrori(){return errori;}
    }



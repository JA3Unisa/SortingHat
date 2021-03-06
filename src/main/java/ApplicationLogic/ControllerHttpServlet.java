package ApplicationLogic;
import ApplicationLogic.Http.ErrorHandler;
import ApplicationLogic.Http.InvalidRequestException;
import ApplicationLogic.Http.RequestValidator;
import Storage.Utente.UtenteSession;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
//import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ControllerHttpServlet extends HttpServlet implements ErrorHandler {

    @Resource(name = "jdbc/sorting_hat_test")//Insert nome DB
    protected static DataSource source;
    protected String getPath(HttpServletRequest req) {
        return req.getPathInfo() != null ? req.getPathInfo() : "/";
    }
    protected List<String> errori=new ArrayList<>();
    protected String view(String viewPath) {
        String base = getServletContext().getInitParameter("basePath");
        String engine = getServletContext().getInitParameter("engine");
        return base + viewPath + engine;
    }


    protected void validate(RequestValidator validator) throws InvalidRequestException {//Verifica se ci sono errori
        if (validator.hasErrors()) {
            System.out.println("validatore ha errore" + validator.getErrors());

           setError(validator);
        }
    }
    protected void setError(RequestValidator validator){
        this.errori=validator.getErrors();
    }



    protected String back(HttpServletRequest request) {
        return request.getServletPath() + request.getPathInfo();
    }

    protected int parsePage(HttpServletRequest request) {

        return Integer.parseInt(request.getParameter("page"));
    }
}

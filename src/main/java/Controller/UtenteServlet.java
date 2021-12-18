package Controller;

import Controller.Http.InvalidRequestException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name= "UtenteServlet" , value="/utente/*")
public class UtenteServlet extends ControllerHttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                default:
                    notFound();
                    break;
            }
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                default:
                    notAllowed();
                    break;
            }
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        }
    }
}

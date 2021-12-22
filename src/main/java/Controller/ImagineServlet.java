package Controller;

import Controller.Http.InvalidRequestException;
import Model.Imagine.SqlImagineDAO;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name= "ImagineServlet" , value="/imagini/*")

public class ImagineServlet  extends ControllerHttpServlet{

    private SqlImagineDAO imagineDAO=new SqlImagineDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);

            switch (path) {
                //show
                //creo
                //rimozione?
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


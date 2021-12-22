package Controller;

import Controller.Http.InvalidRequestException;
import Model.Risposta.SqlRispostaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name= "RispostaServlet" , value="/risposte/*")
public class RispostaServlet extends ControllerHttpServlet {
    private SqlRispostaDAO rispostaDAO=new SqlRispostaDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                //visualizzo
                //creo
                //modifico
                //rimuovo(admin)

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


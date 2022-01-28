package Controller;


import Controller.Http.InvalidRequestException;
import Controller.Http.Paginator;
import Model.Categoria.Categoria;
import Model.Categoria.SqlCategoriaDAO;
import Model.Discussione.Discussione;
import Model.Discussione.SqlDiscussioneDAO;
import Model.Risposta.SqlRispostaDAO;
import Model.Utente.SqlUtenteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PageServlet", value = "/pages/*")
public class PageServlet extends ControllerHttpServlet {
    private SqlUtenteDAO utenteDao = new SqlUtenteDAO();
    private SqlDiscussioneDAO discussioneDao = new SqlDiscussioneDAO();
    private SqlRispostaDAO rispostaDao = new SqlRispostaDAO();
    private SqlCategoriaDAO categoriaDAO = new SqlCategoriaDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String path = getPath(request);
            System.out.println("in pages Servlet"+ path);
            switch (path) {

                case "/dashboard":

                    authorize(request.getSession(false));

                    request.setAttribute("back", view("crm/clienti"));

                    int utenti = utenteDao.countAllUtente();
                    request.setAttribute("utentiNum", utenti);

                    int risposte= rispostaDao.countAll();
                    request.setAttribute("risposteNum", risposte);

                    int discussioni = discussioneDao.countAll();
                    request.setAttribute("discussioniNum", discussioni);

                    request.getRequestDispatcher(view("user/adminDashboard")).forward(request, response);
                    break;
                case "/":
                    request.getRequestDispatcher(view("../../homepage")).forward(request, response);
                    //  request.getRequestDispatcher(view("site/home")).forward(request, response);
                    break;
                case "/questionarioUtente": //show Universiatrio
                    request.getRequestDispatcher(view("user/questionarioUtente")).forward(request, response);
                    break;
                case "/contribuisci": //show Universiatrio

                    request.getRequestDispatcher(view("user/questionarioUniversitario")).forward(request, response);
                    break;
                case "/politiche": //show politiche

                    request.getRequestDispatcher(view("documenti/politiche")).forward(request, response);
                    break;
                case "/forum": //a forum
                    System.out.println("Paginator Categorie");
                    Paginator paginatorCategoria = new Paginator(1,"CategoriaServlet");
                    System.out.println("Categorie");
                    List<Categoria> categorie = categoriaDAO.fetchCategories(paginatorCategoria);
                    request.setAttribute("categorie",categorie);
                    request.getRequestDispatcher(view("user/categorie")).forward(request, response);
                    break;

                case "/forum/esami": //a forum - categoria esami
                    Paginator paginatorCategoriaEsami = new Paginator(1,"CategoriaServlet");
                    Categoria categoriaEsami = categoriaDAO.fetchCategoriesByID(1).get();
                    List<Discussione> discussioniEsami = discussioneDao.fetchDiscussioniByCategoria(categoriaEsami,paginatorCategoriaEsami);
                    request.setAttribute("discussioni",discussioniEsami);
                    request.setAttribute("categoria",categoriaEsami);

                    request.getRequestDispatcher(view("user/discussione")).forward(request, response);
                    break;

                case "/forum/prove intercorso": //a forum - categoria esami
                    Paginator paginatorCategoriaProveIntercorso = new Paginator(1,"CategoriaServlet");
                    Categoria categoriaProveIntercorso = categoriaDAO.fetchCategoriesByID(2).get();
                    List<Discussione> discussioniProveIntercorso = discussioneDao.fetchDiscussioniByCategoria(categoriaProveIntercorso,paginatorCategoriaProveIntercorso);
                    request.setAttribute("discussioni",discussioniProveIntercorso);
                    request.setAttribute("categoria",categoriaProveIntercorso);

                    request.getRequestDispatcher(view("user/discussione")).forward(request, response);
                    break;

                case "/forum/appunti": //a forum - categoria esami
                    Paginator paginatorCategoriaAppunti = new Paginator(1,"CategoriaServlet");
                    Categoria categoriaAppunti = categoriaDAO.fetchCategoriesByID(3).get();
                    List<Discussione> discussioniAppunti = discussioneDao.fetchDiscussioniByCategoria(categoriaAppunti,paginatorCategoriaAppunti);
                    request.setAttribute("discussioni",discussioniAppunti);
                    request.setAttribute("categoria",categoriaAppunti);

                    request.getRequestDispatcher(view("user/discussione")).forward(request, response);
                    break;

                case "/aboutUs": //show info

                    request.getRequestDispatcher(view("documenti/aboutUs")).forward(request, response);
                    break;
                case "/login": // a login utente

                    request.getRequestDispatcher(view("user/login")).forward(request, response);
                    break;
                case "/registrazione": // a registrazione utente

                    request.getRequestDispatcher(view("user/registrazione")).forward(request, response);
                    break;
                default:
                    notFound();
            }
        } catch (InvalidRequestException ex) {
            log(ex.getMessage());
            ex.handle(request, response);
        }catch (SQLException s){
            s.printStackTrace();
        }
    }
}

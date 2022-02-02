package Controller;


import Controller.Http.InvalidRequestException;
import Controller.Http.Paginator;
import Model.Categoria.Categoria;
import Model.Categoria.SqlCategoriaDAO;
import Model.Discussione.Discussione;
import Model.Discussione.SqlDiscussioneDAO;
import Model.Risposta.Risposta;
import Model.Risposta.SqlRispostaDAO;
import Model.Utente.SqlUtenteDAO;
import Model.Utente.Utente;
import Model.Utente.UtenteSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

                    break;
                case "/questionarioUtente": //show Universiatrio

                    request.getRequestDispatcher(view("user/questionarioUtente")).forward(request, response);
                    break;
                case "/contribuisci": //show Universiatrio

                    if(request.getSession(false).getAttribute("utenteSession")== null){

                        request.getRequestDispatcher(view("user/login")).forward(request,response);
                    } else {
                        UtenteSession ut = (UtenteSession) request.getSession(false).getAttribute("utenteSession");
                        Optional<Utente> utente= utenteDao.findUtentebyID(ut.getId());
                        if(!utente.get().getUniversitario()){
                            System.out.println("NON Autorizzato");
                            response.sendRedirect("../pages/nonAutorizzato");
                        }else {

                            request.setAttribute("id", ut.getId());
                            request.getRequestDispatcher(view("user/questionarioUniversitario")).forward(request, response);
                        }
                    }  break;
                case "/politiche": //show politiche

                    request.getRequestDispatcher(view("documenti/politiche")).forward(request, response);
                    break;
                case "/forum": //a forum

                    Paginator paginatorCategoria = new Paginator(1,"CategoriaServlet");

                    List<Categoria> categorie = categoriaDAO.fetchCategories(paginatorCategoria);
                    request.setAttribute("categorie",categorie);
                    request.getRequestDispatcher(view("user/categorie")).forward(request, response);
                    break;

                case "/discussione":{
                    int id = Integer.parseInt(request.getParameter("id"));
                    Paginator paginator = new Paginator(1,"DiscussioneServlet");
                    Categoria categoria = categoriaDAO.fetchCategoriesByID(id).get();
                    List<Discussione> discussioniByCategoria = discussioneDao.fetchDiscussioniByCategoria(categoria,paginator);
                    request.setAttribute("discussioni",discussioniByCategoria);
                    request.setAttribute("categoria",categoria);
                    request.getRequestDispatcher(view("user/discussione")).forward(request, response);
                    break;
                }

                case "/post":{
                    System.out.println("Before Id");
                    int id = Integer.parseInt(request.getParameter("id"));
                    System.out.println("After Id");
                    Paginator paginator = new Paginator(1,"DiscussioneServlet");
                    System.out.println("After Paginator");
                    Discussione discussione = discussioneDao.fetchDiscussioniByID(id).get();
                    List<Risposta> risposteList = rispostaDao.fetchRispostaByIdDiscussione(id,paginator);
                    request.setAttribute("discussione",discussione);
                    request.setAttribute("risposte",risposteList);
                    request.getRequestDispatcher(view("user/post")).forward(request, response);
                    break;
                }
                case "/nonAutorizzato":
                    System.out.println("NON Autorizzato");
                    request.getRequestDispatcher(view("errors/unauthorized")).forward(request, response);
                    break;
                /*case "/forum/esami": //a forum - categoria esami
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

                case "/post": //post discussione
                    Discussione discussione ;
                    Categoria categoriaPost ;
                    List<Discussione> discussioniAppunti = discussioneDao.fetchDiscussioniByCategoria(categoriaAppunti,paginatorCategoriaAppunti);
                    request.setAttribute("discussioni",discussioniAppunti);
                    request.setAttribute("categoria",categoriaAppunti);

                    request.getRequestDispatcher(view("user/discussione")).forward(request, response);
                    break;*/

                case "/aboutUs": //show info

                    request.getRequestDispatcher(view("documenti/aboutUs")).forward(request, response);
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

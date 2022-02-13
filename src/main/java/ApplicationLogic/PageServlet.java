package ApplicationLogic;


import ApplicationLogic.Http.InvalidRequestException;
import ApplicationLogic.Http.Paginator;
import Storage.Categoria.Categoria;
import Storage.Categoria.SqlCategoriaDAO;
import Storage.Discussione.Discussione;
import Storage.Discussione.SqlDiscussioneDAO;
import Storage.Risposta.Risposta;
import Storage.Risposta.SqlRispostaDAO;
import Storage.Utente.SqlUtenteDAO;
import Storage.Utente.Utente;
import Storage.Utente.UtenteSession;

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

                    request.getRequestDispatcher(view("AutenticazioneGUI/adminDashboard")).forward(request, response);
                    break;
                case "/":
                    request.getRequestDispatcher(view("../../homepage")).forward(request, response);

                    break;
                case "/questionarioUtente": //show Universiatrio

                    request.getRequestDispatcher(view("AutenticazioneGUI/questionarioUtente")).forward(request, response);
                    break;
                case "/contribuisci": //show Universiatrio

                    if(request.getSession(false).getAttribute("utenteSession")== null){

                        request.getRequestDispatcher(view("AutenticazioneGUI/login")).forward(request,response);
                    } else {
                        UtenteSession ut = (UtenteSession) request.getSession(false).getAttribute("utenteSession");
                        Optional<Utente> utente= utenteDao.findUtentebyID(ut.getId());
                        if(!utente.get().getUniversitario()){

                            response.sendRedirect("../pages/nonAutorizzato");
                        }else {

                            request.setAttribute("id", ut.getId());
                            request.getRequestDispatcher(view("AutenticazioneGUI/questionarioUniversitario")).forward(request, response);
                        }
                    }  break;
                case "/politiche": //show politiche

                    request.getRequestDispatcher(view("documenti/politiche")).forward(request, response);
                    break;
                case "/forum": //a forum

                    Paginator paginatorCategoria = new Paginator(1,"CategoriaServlet");

                    List<Categoria> categorie = categoriaDAO.fetchCategories(paginatorCategoria);
                    request.setAttribute("categorie",categorie);
                    request.getRequestDispatcher(view("AutenticazioneGUI/categorie")).forward(request, response);
                    break;

                case "/discussione":{

                    int id = Integer.parseInt(request.getParameter("id"));
                    Paginator paginator = new Paginator(1,"DiscussioneServlet");
                    Categoria categoria = categoriaDAO.fetchCategoriesByID(id).get();
                    List<Discussione> discussioniByCategoria = discussioneDao.fetchDiscussioniByCategoria(categoria,paginator);
                    request.setAttribute("discussioni",discussioniByCategoria);
                    request.setAttribute("categoria",categoria);
                    request.getRequestDispatcher(view("AutenticazioneGUI/discussione")).forward(request, response);
                    break;
                }

                case "/post":{

                    int id = Integer.parseInt(request.getParameter("id"));

                    Paginator paginator = new Paginator(1,"DiscussioneServlet");

                    Discussione discussione = discussioneDao.fetchDiscussioniByID(id).get();
                    List<Risposta> risposteList = rispostaDao.fetchRispostaByIdDiscussione(id,paginator);
                    request.setAttribute("discussione",discussione);
                    request.setAttribute("risposte",risposteList);
                    request.getRequestDispatcher(view("AutenticazioneGUI/post")).forward(request, response);
                    break;
                }
                case "/nonAutorizzato":

                    request.getRequestDispatcher(view("errors/unauthorized")).forward(request, response);
                    break;

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

package ApplicationLogic;

import ApplicationLogic.Http.Alert;
import ApplicationLogic.Http.CommonValidator;
import ApplicationLogic.Http.InvalidRequestException;
import ApplicationLogic.Http.Paginator;


import Storage.Categoria.Categoria;
import Storage.Categoria.SqlCategoriaDAO;
import Storage.Discussione.Discussione;
import Storage.Discussione.DiscussioneFormMapper;
import Storage.Discussione.DiscussioneValidator;
import Storage.Discussione.SqlDiscussioneDAO;
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

@WebServlet(name= "DiscussioneServlet" , value="/discussioni/*")
public class DiscussioneServlet extends ControllerHttpServlet {
    private SqlDiscussioneDAO discussioneDAO=new SqlDiscussioneDAO();
    private SqlCategoriaDAO categoriaDAO=new SqlCategoriaDAO();

    public void deleteMethod(HttpServletRequest request, HttpServletResponse response) throws InvalidRequestException, SQLException, IOException {
        System.out.println("in Discussione Delete");
        authorize(request.getSession(false));
        request.setAttribute("back",view("AdminGUI/discussioneList"));/*MODIFICARE*/
        validate(DiscussioneValidator.validateDelete(request));
        String id2=request.getParameter("id");
        System.out.println("sto per cancellare "+ id2);
        if(discussioneDAO.deleteDiscussione(id2)) {
            //request.getRequestDispatcher(view("crm/categoria")).forward(request, response);
            // request.getRequestDispatcher(view("admin/delete")).forward(request,response);
            response.sendRedirect("../discussioni/?page=1");
        }else{internalError();}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String path = getPath(request);

            switch (path) {

                case "/":
                    System.out.println(" discussione pre");
                    authorize(request.getSession(false));

                    request.setAttribute("page",1);
                    validate(CommonValidator.validatePage(request));


                    int page = parsePage(request);

                    Paginator paginatore = new Paginator(page, "DiscussioneServlet");


                    int size = discussioneDAO.countAll();

                    List<Discussione> discussiones = discussioneDAO.fetchDiscussioni(paginatore);

                    request.setAttribute("discussioni", discussiones);
                    request.setAttribute("pages", paginatore.getPages(size));
                    request.getRequestDispatcher(view("AdminGUI/discussioneList")).forward(request, response);
                    break;

                case "/show"://show (admin)
                    authorize(request.getSession(false));
                    validate(CommonValidator.validatePage(request));
                    int id = Integer.parseInt(request.getParameter("id"));
                    Optional<Discussione> discussioneOptional = discussioneDAO.fetchDiscussioniByID(id);
                    if (discussioneOptional.isPresent()) {
                        request.setAttribute("categoria", discussioneOptional);           //modificare
                        request.getRequestDispatcher(view("crm/categoria")).forward(request, response);
                    } else {
                        notFound();
                    }
                    break;
                case "/create":
                    authorize(request.getSession(false));

                    List<Categoria>categoriaList1=categoriaDAO.fetchCategoriesAll();
                    request.setAttribute("categorie",categoriaList1);
                    request.getRequestDispatcher(view("DiscussioneGUI/DiscussioneCreate")).forward(request, response);
                    break;
                case "/createUtente":

                    if(request.getSession(false).getAttribute("utenteSession")== null){

                        request.getRequestDispatcher(view("AutenticazioneGUI/login")).forward(request,response);
                    } else {
                        UtenteSession ut1 = (UtenteSession) request.getSession(false).getAttribute("utenteSession");


                        List<Categoria> categoriaList2 = categoriaDAO.fetchCategoriesAll();
                        request.setAttribute("categorie", categoriaList2);
                        request.getRequestDispatcher(view("DiscussioneGUI/DiscussioneCreateUtente")).forward(request, response);

                    }
                    break;
                case "/update":
                    authorize(request.getSession(false));
                    int idUpd= Integer.parseInt(request.getParameter("id"));
                    Optional<Discussione> cl=discussioneDAO.fetchDiscussioniByID(idUpd);

                    List<Categoria>categoriaList=categoriaDAO.fetchCategoriesAll();
                    request.setAttribute("categorie",categoriaList);
                    request.setAttribute("discussione",cl.get());
                    request.getRequestDispatcher(view("DiscussioneGUI/DiscussioneUpdate")).forward(request, response);
                    break;

                case"/delete"://elimino(admin)
                    this.deleteMethod(request,response);
                    break;


                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Risorsa non trovata");



            }
        } catch (InvalidRequestException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                case"/create"://creo(admin)
                     authorize(request.getSession(false));

                    request.setAttribute("back",view("DiscussioneGUI/DiscussioneCreate"));
                    UtenteSession ut= (UtenteSession) request.getSession(true).getAttribute("utenteSession");
                    List<Categoria>categoriaList1=categoriaDAO.fetchCategoriesAll();
                    request.setAttribute("categorie",categoriaList1);
                    if(!errori.isEmpty()){
                        errori.clear();
                    }
                    validate(DiscussioneValidator.validateForm(request,false));
                    if(errori.isEmpty()) {
                        Discussione discussione = new DiscussioneFormMapper().map(request, false);

                        System.out.println("QUI");
                        Utente utente = new Utente();
                        utente.setIdUtente(ut.getId());
                        discussione.setUtente(utente);

                        if (discussioneDAO.createDiscussione(discussione)) {
                            System.out.println("creata");
                            request.setAttribute("discussione", discussione);
                            request.setAttribute("alert", new Alert(List.of("Discussione creata!"), "success"));
                            request.getRequestDispatcher(view("DiscussioneGUI/DiscussioneCreate")).forward(request, response);/*MODIFICARE*/
                        } else {
                            internalError();
                        }
                    }else{
                    InvalidRequestException invalidRequestException=new InvalidRequestException("ERRORE",errori,HttpServletResponse.SC_BAD_REQUEST);
                    invalidRequestException.handle(request,response);
                }
                    break;
                case "/createUtente"://creo utente
                    if(!errori.isEmpty()){
                        errori.clear();
                    }
                    authenticated(request.getSession(false));
                    request.setAttribute("back",view("DiscussioneGUI/DiscussioneCreateUtente"));
                    UtenteSession ut2= (UtenteSession) request.getSession(true).getAttribute("utenteSession");
                    List<Categoria>categoriaList2=categoriaDAO.fetchCategoriesAll();
                    request.setAttribute("categorie",categoriaList2);

                    validate(DiscussioneValidator.validateForm(request,false));


                    if(errori.isEmpty()) {
                        Discussione discussione2 = new DiscussioneFormMapper().map(request, false);
                        System.out.println("QUI");
                        Utente utente2 = new Utente();
                        utente2.setIdUtente(ut2.getId());
                        discussione2.setUtente(utente2);
                        int idU = discussioneDAO.createDiscussioneUtente(discussione2);
                        if (idU != 0) {

                            System.out.println("creata");
                            request.setAttribute("discussione", discussione2);
                            request.setAttribute("alert", new Alert(List.of("Discussione creata!"), "success"));
                            response.sendRedirect("../pages/post?id=" + idU);
                        }
                    }else{

                            List<Categoria> categoriaList = categoriaDAO.fetchCategoriesAll();
                            request.setAttribute("categorie", categoriaList);

                            InvalidRequestException invalidRequestException=new InvalidRequestException("ERRORE",errori,HttpServletResponse.SC_BAD_REQUEST);
                            invalidRequestException.handle(request,response);
                     }
                    break;
                case "/update": //aggiorno(admin)

                    authorize(request.getSession(false));
                    request.setAttribute("back",view("DiscussioneGUI/DiscussioneUpdate"));
                    if(!errori.isEmpty()){
                        errori.clear();
                    }
                    validate(DiscussioneValidator.validateForm(request,true));

                    int idUpd= Integer.parseInt(request.getParameter("id"));
                    Optional<Discussione> cl=discussioneDAO.fetchDiscussioniByID(idUpd);

                    List<Categoria>categoriaList=categoriaDAO.fetchCategoriesAll();
                    request.setAttribute("categorie",categoriaList);
                    request.setAttribute("discussione",cl.get());

                    if(errori.isEmpty()){
                    Discussione discussioneAgg=new DiscussioneFormMapper().map(request,true);

                    UtenteSession ut1= (UtenteSession) request.getSession(true).getAttribute("utenteSession");
                    Utente utente1=new Utente();
                    utente1.setIdUtente(ut1.getId());
                    discussioneAgg.setUtente(utente1);

                    if(discussioneDAO.updateDiscussione(discussioneAgg)) {

                        request.setAttribute("discussione", discussioneAgg);
                        request.setAttribute("alert", new Alert(List.of("Discussione Aggiornata!"), "success"));

                        request.getRequestDispatcher(view("DiscussioneGUI/DiscussioneUpdate")).forward(request, response);
                    }else internalError();
                    }else{
                        InvalidRequestException invalidRequestException=new InvalidRequestException("ERRORE",errori,HttpServletResponse.SC_BAD_REQUEST);
                        invalidRequestException.handle(request,response);

                    }
                    break;

                case"/delete"://elimino(admin)

                    authorize(request.getSession(false));
                    request.setAttribute("back",view("AdminGUI/discussioneList"));/*MODIFICARE*/
                    validate(DiscussioneValidator.validateDelete(request));
                    String id=request.getParameter("id");

                    if(discussioneDAO.deleteDiscussione(id)) {

                        request.setAttribute("alert", new Alert(List.of("Discussione Rimossa!"), "success"));
                         response.sendRedirect("../discussioni/?page=1");
                    }else{internalError();}
                    break;

                default:
                    notAllowed();
                    break;
            }
        } catch (InvalidRequestException | SQLException e) {
            e.printStackTrace();
        }
    }
}

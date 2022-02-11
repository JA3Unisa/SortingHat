package Controller;

import Controller.Http.Alert;
import Controller.Http.CommonValidator;
import Controller.Http.InvalidRequestException;
import Controller.Http.Paginator;


import Model.Categoria.Categoria;
import Model.Categoria.SqlCategoriaDAO;
import Model.Discussione.Discussione;
import Model.Discussione.DiscussioneFormMapper;
import Model.Discussione.DiscussioneValidator;
import Model.Discussione.SqlDiscussioneDAO;
import Model.Utente.Utente;
import Model.Utente.UtenteSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@WebServlet(name= "DiscussioneServlet" , value="/discussioni/*")
public class DiscussioneServlet extends ControllerHttpServlet {
    private SqlDiscussioneDAO discussioneDAO=new SqlDiscussioneDAO();
    private SqlCategoriaDAO categoriaDAO=new SqlCategoriaDAO();
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
                    request.getRequestDispatcher(view("admin/discussioneList")).forward(request, response);
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
                    //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                   // request.setAttribute("dataOra",timestamp);
                    List<Categoria>categoriaList1=categoriaDAO.fetchCategoriesAll();
                    request.setAttribute("categorie",categoriaList1);
                    request.getRequestDispatcher(view("Discussione/DiscussioneCreate")).forward(request, response);
                    break;
                case "/update":
                    authorize(request.getSession(false));
                    int idUpd= Integer.parseInt(request.getParameter("id"));
                    Optional<Discussione> cl=discussioneDAO.fetchDiscussioniByID(idUpd);

                    List<Categoria>categoriaList=categoriaDAO.fetchCategoriesAll();
                    request.setAttribute("categorie",categoriaList);
                    request.setAttribute("discussione",cl.get());
                    request.getRequestDispatcher(view("Discussione/DiscussioneUpdate")).forward(request, response);
                    break;

                case"/delete"://elimino(admin)
                    System.out.println("in Discussione Delete");
                    authorize(request.getSession(false));
                    request.setAttribute("back",view("admin/discussioneList"));/*MODIFICARE*/
                    validate(DiscussioneValidator.validateDelete(request));
                    String id2=request.getParameter("id");
                    System.out.println("sto per cancellare "+ id2);
                    if(discussioneDAO.deleteDiscussione(id2)) {
                        //request.getRequestDispatcher(view("crm/categoria")).forward(request, response);
                        // request.getRequestDispatcher(view("admin/delete")).forward(request,response);
                        response.sendRedirect("../discussioni/?page=1");
                    }else{internalError();}
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
                    request.setAttribute("back",view("Discussione/DiscussioneCreate"));
                    UtenteSession ut= (UtenteSession) request.getSession(true).getAttribute("utenteSession");


                    validate(DiscussioneValidator.validateForm(request,false));
                    Discussione discussione=new DiscussioneFormMapper().map(request,false);
                    System.out.println("QUI");
                    Utente utente=new Utente();
                    utente.setIdUtente(ut.getId());
                    discussione.setUtente(utente);

                    if(discussioneDAO.createDiscussione(discussione)){
                        System.out.println("creata");
                        request.setAttribute("discussione",discussione);
                        request.setAttribute("alert",new Alert(List.of("Discussione creata!"),"success"));
                        request.getRequestDispatcher(view("Discussione/DiscussioneCreate")).forward(request,response);/*MODIFICARE*/
                    }else{internalError();}
                    break;
                case "/createUtente"://creo(admin)
                    authenticated(request.getSession(false));
                    request.setAttribute("back",view("user/discussione"));
                    UtenteSession ut2= (UtenteSession) request.getSession(true).getAttribute("utenteSession");


                    validate(DiscussioneValidator.validateForm(request,false));
                    Discussione discussione2=new DiscussioneFormMapper().map(request,false);
                    System.out.println("QUI");
                    Utente utente2=new Utente();
                    utente2.setIdUtente(ut2.getId());
                    discussione2.setUtente(utente2);

                    if(discussioneDAO.createDiscussione(discussione2)){
                        System.out.println("creata");
                        request.setAttribute("discussione",discussione2);
                        request.setAttribute("alert",new Alert(List.of("Discussione creata!"),"success"));
                        request.getRequestDispatcher(view("user/post")).forward(request,response);/*MODIFICARE*/
                    }else{internalError();}
                    break;
                case "/update": //aggiorno(admin)

                    authorize(request.getSession(false));
                    request.setAttribute("back",view("Discussione/DiscussioneUpdate"));
                    validate(DiscussioneValidator.validateForm(request,true));
                    Discussione discussioneAgg=new DiscussioneFormMapper().map(request,true);

                    UtenteSession ut1= (UtenteSession) request.getSession(true).getAttribute("utenteSession");
                    Utente utente1=new Utente();
                    utente1.setIdUtente(ut1.getId());
                    discussioneAgg.setUtente(utente1);

                    if(discussioneDAO.updateDiscussione(discussioneAgg)) {

                        request.setAttribute("discussione",discussioneAgg);
                        request.setAttribute("alert", new Alert(List.of("Disposta Aggiornata!"), "success"));

                        request.getRequestDispatcher(view("Discussione/DiscussioneUpdate")).forward(request, response);
                    }else{
                        internalError();}
                    break;

                case"/delete"://elimino(admin)
                    System.out.println("in Discussione Delete");
                    authorize(request.getSession(false));
                    request.setAttribute("back",view("admin/discussioneList"));/*MODIFICARE*/
                    validate(DiscussioneValidator.validateDelete(request));
                    String id=request.getParameter("id");
                    System.out.println("sto per cancellare "+ id);
                    if(discussioneDAO.deleteDiscussione(id)) {

                        request.setAttribute("alert", new Alert(List.of("Discussione Rimossa!"), "success"));
                        //request.getRequestDispatcher(view("crm/categoria")).forward(request, response);
                       // request.getRequestDispatcher(view("admin/delete")).forward(request,response);
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

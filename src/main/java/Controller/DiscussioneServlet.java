package Controller;

import Controller.Http.Alert;
import Controller.Http.CommonValidator;
import Controller.Http.InvalidRequestException;
import Controller.Http.Paginator;



import Model.Discussione.Discussione;
import Model.Discussione.DiscussioneFormMapper;
import Model.Discussione.DiscussioneValidator;
import Model.Discussione.SqlDiscussioneDAO;

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

                case "/show"://show categoria(admin)
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
                    request.getRequestDispatcher(view("Discussione/DiscussioneCreate")).forward(request, response);
                    break;
                case "/update":
                    authorize(request.getSession(false));
                    int idUpd= Integer.parseInt(request.getParameter("id"));
                    Optional<Discussione> cl=discussioneDAO.fetchDiscussioniByID(idUpd);
                    request.setAttribute("discussione",cl.get());
                    request.getRequestDispatcher(view("Discussione/DiscussioneUpdate")).forward(request, response);
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

                    validate(DiscussioneValidator.validateForm(request,false));
                    Discussione discussione=new DiscussioneFormMapper().map(request,false);
                    if(discussioneDAO.createDiscussione(discussione)){
                        System.out.println("creata");
                        request.setAttribute("discussione",discussione);
                        request.setAttribute("alert",new Alert(List.of("Discussione creata!"),"success"));
                        request.getRequestDispatcher(view("Discussione/DiscussioneCreate")).forward(request,response);/*MODIFICARE*/
                    }else{internalError();}
                    break;
                case "/update": //aggiorno(admin)

                    authorize(request.getSession(false));
                    request.setAttribute("back",view("Discussione/DiscussioneUpdate"));
                    validate(DiscussioneValidator.validateForm(request,true));
                    Discussione discussioneAgg=new DiscussioneFormMapper().map(request,true);
                    System.out.println(discussioneAgg.getCategoria().getIdCategoria());

                    if(discussioneDAO.updateDiscussione(discussioneAgg)) {
                        request.setAttribute("discussione",discussioneAgg);
                        request.setAttribute("alert", new Alert(List.of("Discussione Aggiornata!"), "success"));
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
                        request.getRequestDispatcher(view("admin/delete")).forward(request,response);/*MODIFICARE*/
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

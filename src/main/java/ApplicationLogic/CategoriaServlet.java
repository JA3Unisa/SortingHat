package ApplicationLogic;

import ApplicationLogic.Http.Alert;
import ApplicationLogic.Http.CommonValidator;
import ApplicationLogic.Http.InvalidRequestException;
import ApplicationLogic.Http.Paginator;
import Storage.Categoria.Categoria;
import Storage.Categoria.CategoriaFormMapper;
import Storage.Categoria.CategoriaValidator;
import Storage.Categoria.SqlCategoriaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name= "CategoriaServlet" , value="/categorie/*")
public class CategoriaServlet extends ControllerHttpServlet {
    private SqlCategoriaDAO categoriaDAO=new SqlCategoriaDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                case "/"://show categorie(admin)

                    authorize(request.getSession(false));

                    request.setAttribute("page",1);
                    validate(CommonValidator.validatePage(request));


                    int page = parsePage(request);

                    Paginator paginatore = new Paginator(page, "CategoriaServlet");


                    int size = categoriaDAO.countAll();

                    List<Categoria> categorie = categoriaDAO.fetchCategories(paginatore);
                    request.setAttribute("categorie", categorie);
                    request.setAttribute("pages", paginatore.getPages(size));
                    request.getRequestDispatcher(view("AdminGUI/categoriaList")).forward(request, response);
                    break;

                case "/show"://show categoria(admin)
                    authorize(request.getSession(false));
                    validate(CommonValidator.validatePage(request));
                    int id = Integer.parseInt(request.getParameter("id"));
                    Optional<Categoria> categoriaOptional = categoriaDAO.fetchCategoriesByID(id);
                    if (categoriaOptional.isPresent()) {
                        request.setAttribute("categoria", categoriaOptional);
                        request.getRequestDispatcher(view("crm/categoria")).forward(request, response);
                    } else {
                        notFound();
                    }
                    break;
                case "/create":
                    authorize(request.getSession(false));
                    request.getRequestDispatcher(view("CategoriaGUI/CategoriaCreate")).forward(request, response);
                    break;
                case "/update":
                    authorize(request.getSession(false));
                    int idUpd= Integer.parseInt(request.getParameter("id"));
                    Optional<Categoria> cl=categoriaDAO.fetchCategoriesByID(idUpd);

                    request.setAttribute("categoria",cl.get());
                    request.getRequestDispatcher(view("CategoriaGUI/CategoriaUpdate")).forward(request, response);
                    break;

                case "/delete"://elimino(admin)
                    System.out.println("in categorie Delete");
                    authorize(request.getSession(false));
                    request.setAttribute("back",view("AdminGUI/categoriaList"));
                    validate(CategoriaValidator.validateDelete(request));
                    String idDelete=request.getParameter("id");
                    System.out.println(idDelete);
                    if(categoriaDAO.deleteCategoria(idDelete)) {

                       // request.setAttribute("alert", new Alert(List.of("Categoria Rimossa!"), "success"));
                        //request.getRequestDispatcher(view("crm/categoria")).forward(request, response);
                      //  request.getRequestDispatcher(view("admin/delete")).forward(request,response);
                         response.sendRedirect("../categorie/?page=1");

                    }else{internalError();}
                    break;



                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Risorsa non trovata");

            }
        } catch (SQLException throwables) {
            log(throwables.getMessage());
        }catch (InvalidRequestException ex){
            log(ex.getMessage());
            ex.handle(request,response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                case"/create"://creo(admin)
                    authorize(request.getSession(false));
                    if(!errori.isEmpty()){
                        errori.clear();
                    }
                    request.setAttribute("back",view("CategoriaGUI/CategoriaCreate"));

                    validate(CategoriaValidator.validateForm(request,false));
                    if(errori.isEmpty()) {
                    Categoria categoria=new CategoriaFormMapper().map(request,false);

                    if(categoriaDAO.createCategoria(categoria)){
                       System.out.println(categoria.getNome());
                        request.setAttribute("categoria",categoria);
                        request.setAttribute("alert",new Alert(List.of("Categoria creata!"),"success"));
                        request.getRequestDispatcher(view("CategoriaGUI/CategoriaCreate")).forward(request,response);/*MODIFICARE*/
                    } else {
                        internalError();
                    }
                    }else{
                        InvalidRequestException invalidRequestException=new InvalidRequestException("ERRORE",errori,HttpServletResponse.SC_BAD_REQUEST);
                        invalidRequestException.handle(request,response);
                    }
                    break;
                case "/update": //aggiorno(admin)

                    authorize(request.getSession(false));
                    if(!errori.isEmpty()){
                        errori.clear();
                    }
                    int idUpd= Integer.parseInt(request.getParameter("id"));
                    Optional<Categoria> cl=categoriaDAO.fetchCategoriesByID(idUpd);

                    request.setAttribute("categoria",cl.get());

                    request.setAttribute("back",view("CategoriaGUI/CategoriaUpdate"));
                    validate(CategoriaValidator.validateForm(request,true));

                    if(errori.isEmpty()){
                    Categoria categoriaAgg=new CategoriaFormMapper().map(request,true);


                    if(categoriaDAO.updateCategoria(categoriaAgg)) {
                        request.setAttribute("categoria",categoriaAgg);
                        request.setAttribute("alert", new Alert(List.of("Categoria Aggiornata!"), "success"));
                        request.getRequestDispatcher(view("CategoriaGUI/CategoriaUpdate")).forward(request, response);
                    }else{
                        internalError();}}
                    else{
                        InvalidRequestException invalidRequestException=new InvalidRequestException("ERRORE",errori,HttpServletResponse.SC_BAD_REQUEST);
                        invalidRequestException.handle(request,response);
                        }
                    break;

                case"/delete"://elimino(admin) ATTIVA

                    authorize(request.getSession(false));
                    request.setAttribute("back",view("AdminGUI/categoriaList"));
                    validate(CategoriaValidator.validateDelete(request));
                    String id=request.getParameter("id");
                    System.out.println("sto per cancellare "+ id);
                    if(categoriaDAO.deleteCategoria(id)) {


                        response.sendRedirect("../categorie/?page=1");
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



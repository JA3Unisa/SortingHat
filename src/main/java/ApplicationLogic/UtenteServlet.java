package ApplicationLogic;

import ApplicationLogic.Http.Alert;
import ApplicationLogic.Http.CommonValidator;
import ApplicationLogic.Http.InvalidRequestException;
import ApplicationLogic.Http.Paginator;
import Storage.Utente.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@WebServlet(name= "UtenteServlet" , value="/utenti/*")
public class UtenteServlet extends ControllerHttpServlet {

   private SqlUtenteDAO utenteDAO=new SqlUtenteDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
                switch (path) {
                    case "/"://lista account(admin)
                        authorize(request.getSession());
                        request.setAttribute("back", view("AdminGUI/utenteList"));

                        validate(CommonValidator.validatePage(request));
                        int page = parsePage(request);
                        Paginator paginatore = new Paginator(page, "UtenteServlet");
                        int size = utenteDAO.countAllUtente();
                        request.setAttribute("pages", paginatore.getPages(size));

                        List<Utente> utenti = utenteDAO.fetchAccounts(paginatore);

                        request.setAttribute("utenti", utenti);
                        request.getRequestDispatcher(view("AdminGUI/utenteList")).forward(request, response);
                        break;

                    /*case "/create"://creo cliente(admin)
                        authorize(request.getSession(false));
                        request.getRequestDispatcher(view("AdminGUI/UtenteCreate")).forward(request, response);
                        break;*/
                    case "/update"://modifico utente(admin)
                        authorize(request.getSession(false));
                        int idCl = Integer.parseInt(request.getParameter("id"));
                        Optional<Utente> cl = utenteDAO.findUtentebyID(idCl);
                        request.setAttribute("utente", cl.get());
                        request.getRequestDispatcher(view("AdminGUI/UtenteUpdate")).forward(request, response);
                        break;

                    case "/modificoCliente"://modifico cliente(cliente)

                        //int idProfiloCliente = getUtenteSessione(request.getSession(false)).getId();
                        UtenteSession ut= (UtenteSession) request.getSession(true).getAttribute("utenteSession");

                       Utente profiloClienteUp = utenteDAO.findUtentebyID(ut.getId()).get();

                        request.setAttribute("utente", profiloClienteUp);

                        if (profiloClienteUp.getRuolo()==1)

                            request.getRequestDispatcher(view("AdminGUI/UtenteUpdate")).forward(request, response);       //admin

                        else
                        request.getRequestDispatcher(view("AutenticazioneGUI/UtenteProfiloForm")).forward(request, response);      //utente

                        break;

                    case "/show"://cliente info update(admin)
                        authorize(request.getSession(false));
                        validate(CommonValidator.validateId(request));
                        int id = Integer.parseInt(request.getParameter("id"));
                        Optional<Utente> utenteOpt = utenteDAO.findUtentebyID(id);
                        if (utenteOpt.isPresent()) {
                            System.out.println(" in present show");
                            request.setAttribute("utente", utenteOpt);
                            request.getRequestDispatcher(view("crm/utente")).forward(request, response);/*MODIFICARE*/
                        } else
                            notFound();
                        break;
                    case "/secret"://login pagina

                        request.getRequestDispatcher(view("pages/login")).forward(request, response);
                             break;


                    case "/signup"://registro cliente
                        request.getRequestDispatcher(view("AutenticazioneGUI/registrazione")).forward(request, response);
                        break;

                    case "/profilo": //show profilo utente
                        System.out.println("Profilo");
                        UtenteSession ut1= (UtenteSession) request.getSession(true).getAttribute("utenteSession");


                        Utente profilo=utenteDAO.findUtentebyID(ut1.getId()).get();

                        request.setAttribute("utente", profilo);
                        request.getRequestDispatcher(view("AutenticazioneGUI/profilo")).forward(request, response);


                        break;

                    case "/logout"://logout

                        HttpSession session = request.getSession(false);//sessione falsa per non crearla(se log-out allora già log-in)
                        authenticated(session);
                        UtenteSession utenteSession = (UtenteSession) session.getAttribute("utenteSession");

                        String redirect = "../utenti/login";
                        session.removeAttribute("utenteSession");
                        session.invalidate();
                        response.sendRedirect(redirect);
                        break;
                    case "/login": // a login utente

                        request.getRequestDispatcher(view("AutenticazioneGUI/login")).forward(request, response);
                        break;
                    case "/registrazione": // a registrazione utente
                        request.getRequestDispatcher(view("AutenticazioneGUI/registrazione")).forward(request, response);
                        break;
                    case "/delete": //delete cliente

                        authorize(request.getSession(false));

                        request.setAttribute("back", view("AdminGUI/utenteList"));/*MODIFICARE*/
                        validate(UtenteValidator.validateDelete(request));
                        //   Cliente clienteDel=new ClienteFormMapper().map(request,true);
                        int id2=Integer.parseInt(request.getParameter("id"));

                        if(utenteDAO.deleteUtente(id2)){
                            System.out.println("cancellato");
                            //request.getRequestDispatcher(view("admin/delete")).forward(request,response);
                            response.sendRedirect("../utenti/?page=1");
                        }else
                        {internalError();}
                        break;

                    default:
                        notFound();

                }


        }catch (SQLException throwables) {
                throwables.printStackTrace();
            }catch (InvalidRequestException ex) {
                log(ex.getMessage());
                ex.handle(request, response);
            }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //1 admin 0 utente
            String path = getPath(request);
            switch (path) {


                case "/create"://creo cliente
                    authorize(request.getSession(false));
                    request.setAttribute("back", view("AdminGUI/utenteList"));/*per tornare indietro*/

                    validate(UtenteValidator.validateForm(request, false));
                    request.setAttribute("ruolo",false);
                    Utente utente = new UtenteFormMapper().map(request, false);

                    utente.setPassword(request.getParameter("password"));
                    //   System.out.println(cliente.getPassword());
                    if (utenteDAO.createUtente(utente)) {

                        request.setAttribute("utente",utente);
                        request.setAttribute("alert", new Alert(List.of("Cliente creato"), "success"));
                        request.getRequestDispatcher(view("crm/cliente")).forward(request, response);

                    } else {
                        internalError();
                    }
                    break;
                case "/update": //aggiorno utente (ADMIN)
                    authorize(request.getSession(false));
                    request.setAttribute("back", view("AdminGUI/UtenteUpdate"));
                    validate(UtenteValidator.validateForm(request, true));
                    int idCl = Integer.parseInt(request.getParameter("id"));
                    Optional<Utente> cl = utenteDAO.findUtentebyID(idCl);
                    request.setAttribute("utente", cl.get());
                    if(errori.isEmpty()){
                    Utente utenteAggiornato=new UtenteFormMapper().map(request,true);
                    request.setAttribute("cliente",utenteAggiornato);
                    if(utenteDAO.updateUtente(utenteAggiornato)){
                        request.setAttribute("utente",utenteAggiornato);
                        request.setAttribute("alert",new Alert(List.of("Utente Aggiornato!"),"success"));
                        request.getRequestDispatcher(view("AdminGUI/UtenteUpdate")).forward(request, response);
                    }else{internalError();}
                    }else{

                        InvalidRequestException invalidRequestException=new InvalidRequestException("ERRORE",errori,HttpServletResponse.SC_BAD_REQUEST);
                        invalidRequestException.handle(request,response);

                    }
                    break;
                case "/modificoUtente": //aggiorno cliente

                    authenticated(request.getSession(false));
                    request.setAttribute("back", view("AdminGUI/UtenteUpdate"));
                    validate(UtenteValidator.validateForm(request, true));

                    Utente u=new Utente();
                    u.setIdUtente(Integer.parseInt(request.getParameter("id")));
                    u.setNome(request.getParameter("Nome"));
                    u.setCognome(request.getParameter("Cognome"));
                    u.setEmail(request.getParameter("Email"));

                    request.setAttribute("utente",u);
                    if(utenteDAO.updateUser(u)){

                        request.setAttribute("utente",u);
                        request.setAttribute("alert",new Alert(List.of("Utente Aggiornato!"),"success"));
                        response.sendRedirect("../utenti/profilo");
                    }else{internalError();}
                    break;
                case "/delete": //delete cliente

                    authorize(request.getSession(false));

                    request.setAttribute("back", view("AdminGUI/utenteList"));/*MODIFICARE*/
                    validate(UtenteValidator.validateDelete(request));

                    int id=Integer.parseInt(request.getParameter("id"));

                    if(utenteDAO.deleteUtente(id)){

                        System.out.println("cancellato");
                        request.setAttribute("alert",new Alert(List.of("Utente Eliminato!"),"success"));

                        //request.getRequestDispatcher(view("admin/delete")).forward(request,response);
                        response.sendRedirect("../utenti/?page=1");
                    }else
                    {internalError();}
                    break;


                case "/signupUtente"://registrazione cliente

                    request.setAttribute("back", view("AutenticazioneGUI/registrazione"));
                    validate(UtenteValidator.validateForm(request,false));
                    if(errori.isEmpty()){
                    Utente utenteSign=new UtenteFormMapper().map(request,false);

                    utenteSign.setRuolo(0);
                    utenteSign.setPassword(request.getParameter("Password"));

                    if(utenteDAO.createUtente(utenteSign)){


                        request.getRequestDispatcher(view("user/login")).forward(request, response);

                    }else internalError();
                    }else{
                        InvalidRequestException invalidRequestException=new InvalidRequestException("ERRORE",errori,HttpServletResponse.SC_BAD_REQUEST);
                        invalidRequestException.handle(request,response);

                    }
                    break;


                case "/secret"://login

                    request.setAttribute("back", view("AutenticazioneGUI/login"));
                    validate(UtenteValidator.validateSignin(request,false));

                    Utente tmpUtente = new Utente();
                    tmpUtente.setEmail(request.getParameter("Email"));
                    tmpUtente.setPassword(request.getParameter("Password"));

                    Optional<Utente> optionalUtente=utenteDAO.findUtente(tmpUtente.getEmail(), tmpUtente.getPassword());

                    if(optionalUtente.isPresent() && optionalUtente.get().getNome()!=null){

                        if(optionalUtente.get().getRuolo()==1){
                            //ADMIN

                            System.out.println("ADMIN VERIFICATO");
                            UtenteSession utenteSession = new UtenteSession(optionalUtente.get()); //Meno info cliente=meno info sensibili

                            request.getSession(true).setAttribute("utenteSession", utenteSession);
                            response.sendRedirect("../pages/dashboard");/*ADMIN HOME*/
                        }
                        if(optionalUtente.get().getRuolo()==0) {
                           UtenteSession utenteSession = new UtenteSession(optionalUtente.get());
                            request.getSession(true).setAttribute("utenteSession", utenteSession);
                            response.sendRedirect("../utenti/profilo");/* UTENTE HOME*/
                        }
                         }
                    else {

                            //VERIFICA SE ERRORE IN PASS SqlUtenteDAO.findByEmail(tmpUtente.getEmail())WORD
                            Optional<Utente>  optionalUtente1=SqlUtenteDAO.findByEmail(tmpUtente.getEmail());
                            if(optionalUtente1.isPresent() && optionalUtente1.get().getNome()!=null){
                                request.setAttribute("alert",new Alert(List.of("Password non valida"),"errore"));
                            }else {
                                System.out.println("NON VALIDA");
                                request.setAttribute("alert",new Alert(List.of("E-mail non valida"),"errore"));}


                        request.getRequestDispatcher(view("AutenticazioneGUI/login")).forward(request,response);


                    }
                        break;
                default:
                    notAllowed();
                    break;
            }
        } catch (InvalidRequestException | NoSuchAlgorithmException | SQLException e) {
            e.printStackTrace();
        }
    }
}

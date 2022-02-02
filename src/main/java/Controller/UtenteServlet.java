package Controller;

import Controller.Http.Alert;
import Controller.Http.CommonValidator;
import Controller.Http.InvalidRequestException;
import Controller.Http.Paginator;
import Model.Utente.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;
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
                        request.setAttribute("back", view("admin/utenteList"));

                        validate(CommonValidator.validatePage(request));
                        int page = parsePage(request);
                        Paginator paginatore = new Paginator(page, "UtenteServlet");
                        int size = utenteDAO.countAllUtente();
                        request.setAttribute("pages", paginatore.getPages(size));

                        List<Utente> utenti = utenteDAO.fetchAccounts(paginatore);

                        request.setAttribute("utenti", utenti);
                        request.getRequestDispatcher(view("admin/utenteList")).forward(request, response);
                        break;

                    case "/create"://creo cliente(admin)
                        authorize(request.getSession(false));
                        request.getRequestDispatcher(view("Utente/UtenteCreate")).forward(request, response);
                        break;
                    case "/update"://modifico utente(admin)
                        authorize(request.getSession(false));
                        int idCl = Integer.parseInt(request.getParameter("id"));
                        Optional<Utente> cl = utenteDAO.findUtentebyID(idCl);
                        request.setAttribute("utente", cl.get());
                        request.getRequestDispatcher(view("Utente/UtenteUpdate")).forward(request, response);
                        break;

                    case "/modificoCliente"://modifico cliente(cliente)
                         System.out.println("modifico cliente");
                        //int idProfiloCliente = getUtenteSessione(request.getSession(false)).getId();
                        UtenteSession ut= (UtenteSession) request.getSession(true).getAttribute("utenteSession");
                        System.out.println(ut);
                       Utente profiloClienteUp = utenteDAO.findUtentebyID(ut.getId()).get();
                        System.out.println(profiloClienteUp.getNome()+ profiloClienteUp.getPassword());
                        request.setAttribute("utente", profiloClienteUp);

                        if (profiloClienteUp.getRuolo()==1)

                            request.getRequestDispatcher(view("Utente/UtenteUpdate")).forward(request, response);       //admin

                        else
                        request.getRequestDispatcher(view("Utente/UtenteProfiloForm")).forward(request, response);      //utente

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
                        System.out.println("in secret");
                        request.getRequestDispatcher(view("pages/login")).forward(request, response);
                        // request.getRequestDispatcher("/WEB-INF/views/crm/secret.jsp").forward(request,response);
                        break;


                    case "/signup"://registro cliente
                        request.getRequestDispatcher(view("user/registrazione")).forward(request, response);
                        break;

                    case "/profilo": //show profilo utente
                        System.out.println("Profilo");
                        UtenteSession ut1= (UtenteSession) request.getSession(true).getAttribute("utenteSession");


                        Utente profilo=utenteDAO.findUtentebyID(ut1.getId()).get();

                        request.setAttribute("utente", profilo);
                        request.getRequestDispatcher(view("user/profilo")).forward(request, response);


                        break;
                /*    case "/profiloAd": //show profilo admin
                        int profiloAD = getUtenteSessione(request.getSession(false)).getId();
                        Optional<Utente> profiloAdmin = utenteDAO.findUtentebyID(profiloAD);
                        System.out.println("in profilo Ad");
                        if (profiloAdmin.isPresent()) {

                            request.setAttribute("utente", profiloAdmin.get());
                            request.getRequestDispatcher(view("utenti/profilo")).forward(request, response);
                        } else
                            notFound();

                        break;*/
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

                        request.getRequestDispatcher(view("user/login")).forward(request, response);
                        break;
                    case "/registrazione": // a registrazione utente
                        request.getRequestDispatcher(view("user/registrazione")).forward(request, response);
                        break;
                    case "/delete": //delete cliente

                        authorize(request.getSession(false));

                        request.setAttribute("back", view("admin/utenteList"));/*MODIFICARE*/
                        validate(UtenteValidator.validateDelete(request));
                        //   Cliente clienteDel=new ClienteFormMapper().map(request,true);
                        int id2=Integer.parseInt(request.getParameter("id"));
                        System.out.println("in delete "+id2);
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
                    request.setAttribute("back", view("admin/utenteList"));/*per tornare indietro*/

                    validate(UtenteValidator.validateForm(request, false));
                    request.setAttribute("ruolo",false);
                    Utente utente = new UtenteFormMapper().map(request, false);

                    utente.setPassword(request.getParameter("password"));
                    //   System.out.println(cliente.getPassword());
                    if (utenteDAO.createUtente(utente)) {
                      //  System.out.println(cliente.getIdCliente());
                        request.setAttribute("utente",utente);
                        request.setAttribute("alert", new Alert(List.of("Cliente creato"), "success"));
                        request.getRequestDispatcher(view("crm/cliente")).forward(request, response);
                        // response.sendRedirect("../accounts/");
                    } else {
                        internalError();
                    }
                    break;
                case "/update": //aggiorno cliente

                    authorize(request.getSession(false));
                    request.setAttribute("back", view("Utente/UtenteUpdate"));
                    validate(UtenteValidator.validateForm(request, true));
                   Utente utenteAggiornato=new UtenteFormMapper().map(request,true);

                    request.setAttribute("cliente",utenteAggiornato);
                    if(utenteDAO.updateUtente(utenteAggiornato)){

                        request.setAttribute("utente",utenteAggiornato);
                        request.setAttribute("alert",new Alert(List.of("Utente Aggiornato!"),"success"));
                        // response.sendRedirect("../accounts/");
                        request.getRequestDispatcher(view("Utente/UtenteUpdate")).forward(request, response);

                    }else{internalError();}
                    break;
                case "/modificoUtente": //aggiorno cliente

                    authenticated(request.getSession(false));
                    request.setAttribute("back", view("Utente/UtenteUpdate"));
                    validate(UtenteValidator.validateForm(request, true));

                    Utente utenteAggiornato1=new UtenteFormMapper().map(request,true);
                    String password = request.getParameter("password");
                    utenteAggiornato1.obtainPassword(password);
                    request.setAttribute("utente",utenteAggiornato1);
                    if(utenteDAO.updateUser(utenteAggiornato1)){

                        request.setAttribute("utente",utenteAggiornato1);
                        request.setAttribute("alert",new Alert(List.of("Utente Aggiornato!"),"success"));
                        // response.sendRedirect("../accounts/");
                      //  request.getRequestDispatcher(view("utenti/updateCliente")).forward(request, response);
                        response.sendRedirect("../utenti/profilo");
                    }else{internalError();}
                    break;
                case "/delete": //delete cliente

                    authorize(request.getSession(false));

                    request.setAttribute("back", view("admin/utenteList"));/*MODIFICARE*/
                    validate(UtenteValidator.validateDelete(request));
                    //   Cliente clienteDel=new ClienteFormMapper().map(request,true);
                    int id=Integer.parseInt(request.getParameter("id"));
                    System.out.println("in delete "+id);
                    if(utenteDAO.deleteUtente(id)){

                        System.out.println("cancellato");
                        request.setAttribute("alert",new Alert(List.of("Utente Eliminato!"),"success"));

                        //request.getRequestDispatcher(view("admin/delete")).forward(request,response);
                        response.sendRedirect("../utenti/?page=1");
                    }else
                    {internalError();}
                    break;


                case "/signupUtente"://registrazione cliente
                    System.out.println("PRE VALIDATE");
                    request.setAttribute("back", view("user/registrazione"));
                    validate(UtenteValidator.validateForm(request,false));
                    System.out.println("POST VALIDATE");
                    Utente utenteSign=new UtenteFormMapper().map(request,false);
                    System.out.println("POST FORM");
                    utenteSign.setRuolo(0);
                    utenteSign.setPassword(request.getParameter("Password"));
                    System.out.println(utenteSign.getPassword());
                    if(utenteDAO.createUtente(utenteSign)){
                        System.out.println("creato");
                        response.sendRedirect("../pages/");/*MODIFICARE*/
                    }else{internalError();}
                    break;

              /*  case "/signin"://login cliente (ricerca nel DB)

                    request.setAttribute("back", view("crm/secret"));

                    validate(UtenteValidator.validateSignin(request,false));
                    Cliente clienteTmp=new Cliente();
                    clienteTmp.setEmail(request.getParameter("Mail"));
                    clienteTmp.setPassword(request.getParameter("password"));
                    Optional<Cliente> clienteOpt=clienteDao.findAccount(clienteTmp.getEmail(),clienteTmp.getPassword(),false);


                    if(clienteOpt.isPresent() && clienteOpt.get().getNome()!=null){
                        ClienteSession clienteSession=new ClienteSession(clienteOpt.get());
                        // request.setAttribute("alert",new Alert(List.of("Cliente trovato!"),"success"));
                        request.getSession(true).setAttribute("clienteSession", clienteSession);
                        System.out.println("creata sessione");
                        response.sendRedirect("../accounts/profilo");//
                    }else{
                        throw new InvalidRequestException("Credenziali non valide", List.of("Credenziali non valide"),
                                HttpServletResponse.SC_BAD_REQUEST);
                    }
                    break;
                case "/secret"://login admin (ricerca nel DB)
                    // System.out.println("ADMIN");
                    request.setAttribute("back", view("crm/secret"));
                    validate(ClienteValidator.validateSignin(request,false));
                    //  System.out.println("creo tmp");
                    Cliente tmpCliente = new Cliente();
                    tmpCliente.setEmail(request.getParameter("Mail"));
                    tmpCliente.setPassword(request.getParameter("password"));
                    // System.out.println("\n"+tmpCliente.getEmail()+" "+tmpCliente.getPassword()+" "+request.getParameter("password"));
                    Optional<Cliente> optionalCliente=clienteDao.findAccount(tmpCliente.getEmail(), tmpCliente.getPassword(), true);
                    //   System.out.println("tornato"+""+optionalCliente.get().getNome());
                    if (optionalCliente.isPresent() && optionalCliente.get().getNome()!=null) {

                        ClienteSession clienteSession = new ClienteSession(optionalCliente.get()); //Meno info cliente=meno info sensibili
                        request.getSession(true).setAttribute("clienteSession", clienteSession);
                        response.sendRedirect("../pages/dashboard");
                    } else {
                        throw new InvalidRequestException("Credenziali non valide", List.of("Credenziali non valide"),
                                HttpServletResponse.SC_BAD_REQUEST);

                    }
                    break;*/
                case "/secret"://login
                    System.out.println("Verifico login");
                    request.setAttribute("back", view("pages/login"));
                    System.out.println(request.getAttribute("back"));

                    validate(UtenteValidator.validateSignin(request,false));

                    Utente tmpUtente = new Utente();
                    tmpUtente.setEmail(request.getParameter("Email"));
                    tmpUtente.setPassword(request.getParameter("Password"));

                    Optional<Utente> optionalUtente=utenteDAO.findUtente(tmpUtente.getEmail(), tmpUtente.getPassword());
                    System.out.println(optionalUtente.get().getNome());
                    if(optionalUtente.isPresent() && optionalUtente.get().getNome()!=null){
                        System.out.println("sono qui");
                        System.out.println(optionalUtente.get().getRuolo());
                        if(optionalUtente.get().getRuolo()==1){
                            //ADMIN

                            System.out.println("ADMIN VERIFICATO");
                            UtenteSession utenteSession = new UtenteSession(optionalUtente.get()); //Meno info cliente=meno info sensibili

                            request.getSession(true).setAttribute("utenteSession", utenteSession);
                            response.sendRedirect("../pages/dashboard");/*ADMIN HOMEP*/
                        }
                        if(optionalUtente.get().getRuolo()==0) {
                           UtenteSession utenteSession = new UtenteSession(optionalUtente.get());
                            request.getSession(true).setAttribute("utenteSession", utenteSession);
                            response.sendRedirect("../utenti/profilo");/*HOME CLIENTE*/
                        }
                         }
                    else {
                        System.out.println("sono qui purtroppo");
                        response.sendRedirect("../pages/login");
                        throw new InvalidRequestException("Credenziali non valide", List.of("Credenziali non valide"),
                                HttpServletResponse.SC_BAD_REQUEST);

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

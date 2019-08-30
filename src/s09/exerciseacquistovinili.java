package s09;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s09/exerciseacquistovinili")
public class exerciseacquistovinili extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    //@Override
    //protected void doGet(HttpServletRequest request, HttpServletResponse response)
            //throws ServletException, IOException {
    	
//}
//}
//public class CarrelloServlet extends HttpServlet {
//private static final long serialVersionUID = 1L;
@EJB
CarrelloLocal carrello;
@EJB
DettaglioLocal dettaglio;
public CarrelloServlet() {
super();
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// ...
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getParameter("azione").equals("dettaglio")){
request.getSession().setAttribute("dettaglio", dettaglio.getDettaglio(Integer.parseInt(request.getParameter("id"))));
response.sendRedirect("/web-carrello/dettaglio.jsp");
} else {
if (request.getParameter("azione").equals("aggiungi")) {
Oggetto oggetto = new Oggetto();
oggetto.setId(Integer.parseInt(request.getParameter("id")));
oggetto.setNome(request.getParameter("nome"));
carrello.aggiungi(oggetto);
} else if (request.getParameter("azione").equals("rimuovi")) {
carrello.rimuovi(Integer.parseInt(request.getParameter("indice")));
}
request.getSession().setAttribute("carrello", carrello.getOggettiCarrello());
response.sendRedirect("/web-carrello");
}
}
}
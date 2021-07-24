package servlet;

import com.google.gson.Gson;
import model.Cliente;
import model.Indirizzo;
import model.IndirizzoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/IndirizzoServlet")
public class IndirizzoServlet {
        private static final long serialVersionUID = 1L;


        public IndirizzoDAO dao;


        @SuppressWarnings("unchecked")
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            dao=new IndirizzoDAO();
            try {
                int op = Integer.parseInt(request.getParameter("operation"));
                Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
                java.util.Map<Integer, Indirizzo> ad = (java.util.Map<Integer,Indirizzo>)request.getSession().getAttribute("address");
                if (op == 0 && cliente != null) {
                    //operazione di visualizzazione
                    request.getSession().setAttribute("address", dao.doRetrieveAll(cliente.getUsername()));
                } else if (op == 1 && cliente != null) {
                    //operazione di inserimento
                    Indirizzo indirizzo = new Indirizzo();
                    indirizzo.setCAP(Integer.parseInt(request.getParameter("cap")));
                    indirizzo.setCitta(request.getParameter("citta"));
                    indirizzo.setNazione(request.getParameter("stato"));
                    indirizzo.setnCv(Integer.parseInt(request.getParameter("ncv")));
                    indirizzo.setProvincia(request.getParameter("provincia"));
                    indirizzo.setVia(request.getParameter("via"));
                    indirizzo.setCodice(dao.doSave(indirizzo, cliente));

                    if (ad != null) {
                        ad.put(indirizzo.getCodice(), indirizzo);
                        request.getSession().setAttribute("address", ad);
                    }
                    if (request.getHeader("x-requested-with") != null) {
                        response.setContentType("application/json");
                        response.getWriter().write(new Gson().toJson(indirizzo));
                    }
                } else if (op == 2 && cliente != null) {
                    //operazione di modifica
                   Indirizzo indirizzo = new Indirizzo ();

                    indirizzo.setCAP(Integer.parseInt(request.getParameter("cap")));
                    indirizzo.setCitta(request.getParameter("citta"));
                    indirizzo.setNazione(request.getParameter("stato"));
                    indirizzo.setnCv(Integer.parseInt(request.getParameter("ncv")));
                    indirizzo.setProvincia(request.getParameter("provincia"));
                    indirizzo.setVia(request.getParameter("via"));

                    dao.doModify(Integer.parseInt(request.getParameter("code")), indirizzo);
                } else if (op == 3 && cliente != null) {
                    //operazione di cancellazione
                    dao.doDelete(Integer.parseInt(request.getParameter("code")));
                } else if (op == 4 && cliente != null) {
                    //operazione di verifica

                }
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
                response.sendRedirect(response.encodeURL("error.jsp"));
            }
            catch (Exception e) {
                response.sendRedirect(response.encodeURL("error.jsp"));
            }
        }


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
            doGet(request, response);
        }

    }


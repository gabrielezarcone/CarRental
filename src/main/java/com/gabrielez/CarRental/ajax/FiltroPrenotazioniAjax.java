package com.gabrielez.CarRental.ajax;

import com.gabrielez.CarRental.dao.AutoDao;
import com.gabrielez.CarRental.entity.Auto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FiltroPrenotazioniAjax", value = "/FiltroPrenotazioniAjax")
public class FiltroPrenotazioniAjax extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Tutorial: https://www.baeldung.com/servlet-json-response
        List<Auto> autoList =AutoDao.getAutoList();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        StringBuilder sb = new StringBuilder("[");
        // Da implementare con parser JSON
        String prefix = "";
        for (Auto auto:autoList) {
            sb.append(prefix);
            prefix = ",";
            sb.append("{");
            sb.append("\"id\":\""+auto.getId()+"\",");
            sb.append("\"costruttore\":\""+auto.getCostruttore()+"\",");
            sb.append("\"modello\":\""+auto.getModello()+"\",");
            sb.append("\"targa\":\""+auto.getTarga()+"\",");
            sb.append("\"tipologia\":\""+auto.getTipologia()+"\",");
            sb.append("\"immatricolazione\":\""+auto.getImmatricolazione()+"\"");
            sb.append("}");
        }
        sb.append("]");
        out.print(sb.toString());
        out.flush();
    }
}

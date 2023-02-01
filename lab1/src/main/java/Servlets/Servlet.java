package Servlets;

import Entities.Entity;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Entity entity = new Entity("assets/Terrier-LT-79.jpg", "TERRIER LT-79", 1000);
        // String entityJson = new Gson().toJson(entity);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
       // out.print(entityJson);
       // out.flush();
        out.println("["+entity+"]");
    }
}


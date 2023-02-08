package Servlets;

import Crud.CrudInterface;
import Entities.EntityCar;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cars")
public class ServletCar extends HttpServlet {
    ServletCarConfigInterface servletCarConfig; //fills crud
    CrudInterface crud;

    public ServletCar() {
        super();
        this.servletCarConfig = new ServletCarConfig();
        this.crud = servletCarConfig.getCrud();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      // EntityCar car = new EntityCar("assets/Terrier-LT-79.jpg", "TERRIER LT-79", 1000);
      // cars.add(car);
        ArrayList<EntityCar> cars = new ArrayList<EntityCar>();
        cars.add(crud.readEntity());
        String carsJson = new Gson().toJson(cars);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(carsJson);
        out.flush();
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String img = request.getParameter("img");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price")); //converting string data from request into integer value
        crud.updateEntity(new EntityCar(img, name, price));
    }
}


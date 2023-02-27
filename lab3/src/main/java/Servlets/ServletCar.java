package Servlets;

import Crud.CrudInterface;
import Entities.CarList;
import Entities.EntityCar;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/cars/*")
public class ServletCar extends HttpServlet {
    private List<EntityCar> cars = new CarList().getCarList();
    ServletCarConfigInterface servletCarConfig; //fills crud
    CrudInterface crud;

    public ServletCar() {
        super();
        this.servletCarConfig = new ServletCarConfig();
        this.crud = servletCarConfig.getCrud();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String carsJson = new Gson().toJson(cars);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        out.print(carsJson);
        out.flush();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EntityCar car = crud.carParse(request);
        car.setId(crud.getNextId(cars));
        cars.add(car);
        doGet(request, response);
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        /*  String img = request.getParameter("img");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price")); //converting string data from request into integer value
        crud.updateEntity(new EntityCar(img, name, price)); */

        EntityCar car = crud.carParse(request);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        int index = crud.getIndexByCarId(id, cars); //list index to store entity
        cars.set(index, car);
        doGet(request, response);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        int index = crud.getIndexByCarId(id, cars); //list index to store entity
        cars.remove(index);
        doGet(request, response);
    }
}


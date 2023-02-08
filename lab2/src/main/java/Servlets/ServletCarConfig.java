package Servlets;

import Crud.CrudInterface;
import Crud.FileCrud;

public class ServletCarConfig implements ServletCarConfigInterface {

    CrudInterface ci;

    public ServletCarConfig() {
        this.ci = new FileCrud();
    }

    public void setCi(CrudInterface ci) {
        this.ci = ci;
    }

    @Override
    public CrudInterface getCrud() {
        return ci;
    }
}

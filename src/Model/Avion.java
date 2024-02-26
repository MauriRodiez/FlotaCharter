package Model;

import java.util.Date;

public class Avion {

    private int id;
    private String marca;
    private String modelo;
    private String matricula;
    private Date fechaEntradaServicio;

    public Avion(){

    }

    public Avion(int id, String marca, String modelo, String matricula, Date fechaEntradaServicio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.fechaEntradaServicio = fechaEntradaServicio;
    }

    public Avion(String marca, String modelo, String matricula, Date fechaEntradaServicio) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.fechaEntradaServicio = fechaEntradaServicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getFechaEntradaServicio() {
        return fechaEntradaServicio;
    }

    public void setFechaEntradaServicio(Date fechaEntradaServicio) {
        this.fechaEntradaServicio = fechaEntradaServicio;
    }
}

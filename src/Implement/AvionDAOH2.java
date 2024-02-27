package Implement;

import DB.Conect;
import Model.Avion;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AvionDAOH2 implements IDao<Avion> {

    private static final String SQL_INSERT_AVION = "INSERT INTO AVIONES (MARCA, MODELO, MATRICULA, FECHA_DE_ENTRADA_EN_SERVICIO) " +
            "VALUES(?,?,?,?)";
    private static final String SQL_BUSCAR_ID = "SELECT * FROM AVIONES WHERE ID = ?";
    private static final String SQL_DELETE = "DELETE FROM AVIONES WHERE ID = ?";
    private static final String SQL_BUSCAR_TODOS = "SELECT * FROM AVIONES";

    private static final Logger LOGGER = Logger.getLogger(AvionDAOH2.class);
    //Conexion
    Connection connection = null;

    @Override
    public Avion registrar(Avion avion) {

        try {
            connection = Conect.getConnection();

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT_AVION, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, avion.getMarca());
            psInsert.setString(2, avion.getModelo());
            psInsert.setString(3, avion.getMatricula());
            psInsert.setDate(4, Date.valueOf(avion.getFechaEntradaServicio()));

            psInsert.execute();

            LOGGER.info("Se ha insertado un nuevo avion");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return avion;
    }

    @Override
    public Avion buscar(int id) {
        Avion avion = null;

        try {
            connection = Conect.getConnection();

            PreparedStatement psBuscarXID = connection.prepareStatement(SQL_BUSCAR_ID);
            psBuscarXID.setInt(1,id);

            ResultSet rsBuscar = psBuscarXID.executeQuery();
            while (rsBuscar.next()){
                int ident = rsBuscar.getInt("id");
                String marca = rsBuscar.getNString("Marca");
                String modelo = rsBuscar.getString("Modelo");
                String matricula = rsBuscar.getString("Matricula");
                LocalDate fechaEnt = rsBuscar.getDate("FECHA_DE_ENTRADA_EN_SERVICIO").toLocalDate();
                avion = new Avion(ident,marca,modelo,matricula,fechaEnt);
                System.out.println(
                        "ID: " +avion.getId() + "\n" +
                        "Marca: " + avion.getMarca() + "\n" +
                        "Modelo: " + avion.getModelo() + "\n" +
                        "Matricula: " + avion.getMatricula() + "\n" +
                        "Fecha de entrada: " + avion.getFechaEntradaServicio()
                        );
            }
            LOGGER.info("Se ha encontrado el avion");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return avion;
    }

    @Override
    public void eliminar(int id) {

        try {
            connection = Conect.getConnection();

            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1, id);

            psDelete.executeUpdate();

            LOGGER.info("Se elimino el avion de la BD");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Avion> buscarTodos() {

        List<Avion> listadoAviones = new ArrayList<>();

        try {
            connection = Conect.getConnection();

            PreparedStatement psBuscarTodos = connection.prepareStatement(SQL_BUSCAR_TODOS);

            ResultSet rsBuscar = psBuscarTodos.executeQuery();

            while (rsBuscar.next()){
                int ident = rsBuscar.getInt("id");
                String marca = rsBuscar.getNString("Marca");
                String modelo = rsBuscar.getString("Modelo");
                String matricula = rsBuscar.getString("Matricula");
                LocalDate fechaEnt = rsBuscar.getDate("FECHA_DE_ENTRADA_EN_SERVICIO").toLocalDate();
                listadoAviones.add(new Avion(ident,marca,modelo,matricula,fechaEnt));
                System.out.println(
                        "ID: " + ident + "\n" +
                                "Marca: " + marca + "\n" +
                                "Modelo: " + modelo + "\n" +
                                "Matricula: " + matricula + "\n" +
                                "Fecha de entrada: " + fechaEnt
                );
            }

            LOGGER.info("Hay cargados en la BD de aviones: " + listadoAviones.size() + " aviones");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

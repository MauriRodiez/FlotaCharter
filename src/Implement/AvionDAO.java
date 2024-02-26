package Implement;

import DB.Conect;
import Model.Avion;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class AvionDAO implements IDao<Avion> {

    private static final String SQL_INSERT_AVION = "INSERT INTO AVIONES (MARCA, MODELO, MATRICULA, FECHA_DE_ENTRADA_EN_SERVICIO) " +
            "VALUES(?,?,?,?)";
    private static final String SQL_BUSCAR_ID = "SELECT * FROM AVIONES WHERE ID = ?";
    private static final String SQL_DELETE = "DELETE FROM AVIONES WHERE ID = ?";
    private static final String sql_buscar_todos = "SELECT * FROM AVIONES";

    private static final Logger LOGGER = Logger.getLogger(AvionDAO.class);
    @Override
    public Avion registrar(Avion avion) {

        Connection connection = null;

        try {
            connection = Conect.getConnection();

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT_AVION, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, avion.getMarca());
            psInsert.setString(2, avion.getModelo());
            psInsert.setString(3, avion.getMatricula());
            psInsert.setDate(4, (Date) avion.getFechaEntradaServicio());

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
    public Avion buscar(Avion avion) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public List<Avion> buscarTodos() {
        return null;
    }
}

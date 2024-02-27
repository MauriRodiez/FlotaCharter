package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conect {

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS AVIONES;" +
            "CREATE TABLE AVIONES(" +
            "ID INT AUTO_INCREMENT PRIMARY KEY," +
            "MARCA VARCHAR(120)," +
            "MODELO VARCHAR(120)," +
            "MATRICULA VARCHAR(50)," +
            "FECHA_DE_ENTRADA_EN_SERVICIO DATE)";

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./FlotaCharter", "sa", "sa");
    }

    public static void createTable(){
        Connection connection = null;

        try {

            connection = getConnection();

            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

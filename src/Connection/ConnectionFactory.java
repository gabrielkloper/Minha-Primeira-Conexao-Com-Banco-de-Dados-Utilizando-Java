 package Connection;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.sql.Connection;

public class ConnectionFactory {

    //nome do usuario MySQL
    private static final String user = "root";

    //senha
    private static final String password = "";

    //Caminho para o banco de dados, nome do DB
    private static final String URL = "jdbc:mysql://localhost:3306/api";


    //Conexao com banco de dados
    public static Connection createConnectionToMySQL() throws Exception {

        //criando a conexão
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/api", "root", "");

            return connection;
    }

    public static void main(String[] args) throws Exception {
        //recuperar conexao com banco de dados
        Connection con = createConnectionToMySQL();


        // Testar se a conexão é nula
        if (con!=null) {
            System.out.println("Conexão obtida com sucesso");
            con.close();
        }
    }
}


/*
OUTA MANEIRA DE ABRIR CONEXÃO


        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/api", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from cursos");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("nomeCurso"));
            }

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            }
        }
 */
package Dao;

import CursosModel.Cursos;
import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursosDAO {

    //CRUD - CREATE - READ - UPDATE - DELETE

    public void addCurso( Cursos cursos) {
        String sql = "INSERT INTO cursos(nomeCurso, valorCurso) VALUES (?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            //criar uma PreparedStatement, para executar uma query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //adicionar os valores esperados
            pstm.setString(1, cursos.getNomeCurso());
            pstm.setInt(2, cursos.getValorCurso());

            //Executar a query
            pstm.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {

            //fechar as conexões
            try {
                if (pstm!=null) {
                    pstm.close();
                }
                if (conn!=null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    public void updateCurso(Cursos curso) {
        String sql = "UPDATE cursos SET nomeCurso = ?, valorCurso = ? " + " WHERE idCurso = ? ";

        Connection conn=null;
        PreparedStatement pstm=null;

        try{
            //Criar conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Criar a classe para executar a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //Adicionar os valores para atualizar
            pstm.setString(1, curso.getNomeCurso());
            pstm.setInt(2, curso.getValorCurso());

            //Qual o ID do registro que deseja atualizar
            pstm.setInt(3, curso.getIdCurso());


            //Executar a query
            pstm.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    public void deleteByID(int idCurso){

        String sql = "DELETE FROM cursos WHERE idCurso = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, idCurso);

            pstm.execute();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstm!=null) {
                    pstm.close();
                }
                if(conn!=null) {
                    conn.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }





    public static List<Cursos> listarCursos(){

        String sql = "SELECT * FROM cursos ";

        List<Cursos> cursos = new ArrayList<Cursos>();

        Connection conn = null;
        PreparedStatement pstm = null;

        //Classe que vai recuperar os dados do banco. **SELECT**
        ResultSet rst = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rst = pstm.executeQuery();


            while (rst.next()) {
                Cursos curso = new Cursos();

                //Recuperar id
                curso.setIdCurso(rst.getInt("idCurso"));

                //Recuperar nome
                curso.setNomeCurso(rst.getString("nomeCurso"));

                //Recuperar valor
                curso.setValorCurso(rst.getInt("valorCurso"));

                cursos.add(curso);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rst != null) {
                    rst.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();


            }

        }
     return cursos;
    }
}

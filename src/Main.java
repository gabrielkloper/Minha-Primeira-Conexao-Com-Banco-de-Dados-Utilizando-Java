import CursosModel.Cursos;
import Dao.CursosDAO;

public class Main {
    public static void main(String[] args) {



        //Criar objeto DAO no Main
        CursosDAO cursosDAO = new CursosDAO();
        //Criar objeto Curso no Main
        Cursos curso = new Cursos();

        //Setar as propriedades da tabela
        curso.setNomeCurso("Integração de Database");
        curso.setValorCurso(500);
        //Adicionar as informações no banco de dados
        cursosDAO.addCurso(curso);





        //Setar as propriedades da tabela
        Cursos c1 = new Cursos();
        c1.setNomeCurso("Java");
        c1.setValorCurso(15);
        // Escolher o id onde será feita a modificação no DB
        c1.setIdCurso(4);
        //Editar as informações no Banco de Dados
        cursosDAO.updateCurso(c1);


        //Deletar o Curso por numero de ID
        cursosDAO.deleteByID(12);







        //Visualização dos registros do banco de dados TODOS
        for (Cursos c: CursosDAO.listarCursos()){
            System.out.println("Cursos:" + c.getNomeCurso());
        }

    }
}
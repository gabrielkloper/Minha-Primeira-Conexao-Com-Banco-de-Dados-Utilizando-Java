package CursosModel;

public class Cursos {
    private int idCurso;
    private String nomeCurso;
    private int valorCurso;

    public Cursos() {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.valorCurso = valorCurso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getValorCurso() {
        return valorCurso;
    }

    public void setValorCurso(int valorCurso) {
        this.valorCurso = valorCurso;
    }

    @Override
    public String toString() {
        return "Cursos{" +
                "idCurso=" + idCurso +
                ", nomeCurso='" + nomeCurso + '\'' +
                ", valorCurso=" + valorCurso +
                '}';
    }
}

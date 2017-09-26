package trabalho_m1;

public class Avaliacao {
    
    private static Avaliacao instancia;
    
    private String nome;
    private String disciplina;
    private Double peso;
    private char[]media = new char[2];
    private Double nota;
    private int identificadorNoArquivo;
    
    public static Avaliacao obterInstancia(){
        if(Avaliacao.instancia == null){
            Avaliacao.instancia = new Avaliacao();
        }
        return Avaliacao.instancia;
    }
    
}

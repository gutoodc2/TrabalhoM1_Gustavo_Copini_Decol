package trabalho_m1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Avaliacao {
    
    private String nome;
    private String disciplina;
    private Double peso;
    private char[]media = new char[2];
    private Double nota;
    private int identificadorNoArquivo;
    
    public void salvar(){
        
       File arquivo = new File("listadeavaliacoes.csv");
        try {
            FileWriter dado = new FileWriter(arquivo,true);
            String dados = disciplina + "," + media + "," + nome + "," + peso + "\n";
            dado.write(dados);
            dado.close(); 
        } catch (IOException ex) {
            Logger.getLogger(Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        
    }
    
    public void atualizar(){
    
    }
    
    /*static public void ArrayList<Avaliacao> obterListaAvaliacoes(){
        
    }
    
    static public void calculaMediaDaDisciplina(){
        
    }*/

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(char[] media) {
        this.media = media;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(Double nota) {
        this.nota = nota;
    }

    /**
     * @param identificadorNoArquivo the identificadorNoArquivo to set
     */
    public void setIdentificadorNoArquivo(int identificadorNoArquivo) {
        this.identificadorNoArquivo = identificadorNoArquivo;
    }
}

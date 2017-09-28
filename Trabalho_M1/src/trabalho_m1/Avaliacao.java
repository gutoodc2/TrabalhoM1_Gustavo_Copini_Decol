package trabalho_m1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Avaliacao {

    private String nome;
    private String disciplina;
    private Double peso;
    private String media;
    private Double nota;
    private int identificadorNoArquivo;

    public void salvar() {

        File arquivo = new File("listadeavaliacoes.csv");
        try {
            FileWriter dado = new FileWriter(arquivo, true);
            //setNota(0.0);
            String dados = getDisciplina() + "," + getMedia() + "," + getNome() + "," + getPeso() + ",0" + "\n";
            dado.write(dados);
            dado.close();
        } catch (IOException ex) {
            Logger.getLogger(Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Atualiza os dados da tabela quando inserir nota
    public void atualizar() {
        /*File arquivo = new File("listadeavaliacoes.csv");
        try {
            FileWriter dado = new FileWriter(arquivo);
            String dados = getDisciplina() + "," + getMedia() + "," + getNome() + "," + getPeso() + "," + getNota() + "\n";
            dado.write(dados);
            dado.close();
        } catch (IOException ex) {
            Logger.getLogger(Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
    }

    //Joga os dados na tabela
    // nomedisciplina, media, nome atividade, peso, nota
    static public ArrayList<Avaliacao> obterListaAvaliacoes() {

        ArrayList<Avaliacao> avaliacoes = new ArrayList();
        try {
            FileReader arq = new FileReader("listadeavaliacoes.csv");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha;
            int i = 0;

            //Laço para popular o arraylist com as avaliações
            while ((linha = lerArq.readLine()) != null) {
                if (linha.trim().equals("")) {
                    continue;
                }
                Avaliacao ava = new Avaliacao();
                String array[] = linha.split(",");
                ava.setDisciplina(array[0]);
                ava.setMedia(array[1]);
                ava.setNome(array[2]);
                double peso = Double.parseDouble(array[3]);
                ava.setPeso(peso);
                ava.setIdentificadorNoArquivo(i);
                System.out.println(array[3]);
                double nota = Double.parseDouble(array[4]);
                ava.setNota(nota);
                avaliacoes.add(ava);
                i++;

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return avaliacoes;
    }

    /*public void calculaMediaDaDisciplina(){
        
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
    public void setMedia(String media) {
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

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the disciplina
     */
    public String getDisciplina() {
        return disciplina;
    }

    /**
     * @return the peso
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * @return the media
     */
    public String getMedia() {
        return media;
    }

    /**
     * @return the nota
     */
    public Double getNota() {
        return nota;
    }

    /**
     * @return the identificadorNoArquivo
     */
    public int getIdentificadorNoArquivo() {
        return identificadorNoArquivo;
    }
}

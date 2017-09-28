/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_m1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class InformarNotaController extends InterfaceUsuario {

    public InformarNotaController() {
        super("InformarNota.fxml");
    }

    private int index;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtDisciplina;

    @FXML
    private TextField txtMedia;

    @FXML
    private TextField txtNota;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            FileReader arq = new FileReader("listadeavaliacoes.csv");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha;
            int i = 0;

            while ((linha = lerArq.readLine()) != null) {
                if (linha.trim().equals("")) {
                    continue;
                }
                if (i == index) {
                    String array[] = linha.split(",");
                    txtDisciplina.setText(array[0]);
                    txtMedia.setText(array[1]);
                    txtNome.setText(array[2]);
                }
                i++;

            }
            arq.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void voltarAvaliacoes(ActionEvent evento) {
        GerenciadorJanela.obterInstancia().voltar();
    }

    @FXML
    public void salvarNota(ActionEvent evento) {

        ArrayList<String> listaAvaliacoes = new ArrayList();
        try {
            FileReader arq = new FileReader("listadeavaliacoes.csv");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha;

            while ((linha = lerArq.readLine()) != null) {
                if (linha.trim().equals("")) {
                    continue;
                }
                listaAvaliacoes.add(linha);
            }
            
            String linhaMod = listaAvaliacoes.get(index);
            double nota = Double.parseDouble(txtNota.getText());
            linhaMod = linhaMod + nota + "\n";
            listaAvaliacoes.set(index, linhaMod);
            
            FileWriter novArq = new FileWriter("listadeavaliacoes.csv");
              
            for(int j=0; j<listaAvaliacoes.size();j++){
                
                novArq.write(listaAvaliacoes.get(j) + "\n");
                
            }
            novArq.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Avaliacao voltar = new Avaliacao();
        voltar.atualizar();

    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_m1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author gusta
 */
public class AdicionarNovaAvaliacaoController extends InterfaceUsuario {

    public AdicionarNovaAvaliacaoController(){
        super("AdicionarNovaAvaliacao.fxml");
    }
    
    //Criando uma coleção dos itens para colocar nos combos box
    ObservableList<String> disciplinasList = FXCollections
                            .observableArrayList("Arquitetura de Computadores II",
                                                "Programação Orientada a Obejtos");
    ObservableList<String> mediaList = FXCollections
                            .observableArrayList("M1","M2","M3");
    
    @FXML
    private ComboBox disciplinasBox;
    
    @FXML
    private ComboBox mediaBox;
    
    @FXML
    private TextField nomeAvaliacao;
    
    @FXML
    private TextField pesoAvaliacao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Adicionar Nova Avaliação aberta");
        disciplinasBox.setValue("Selecione a Disciplina");
        disciplinasBox.setItems(disciplinasList);
        mediaBox.setValue("Selecione a Média");
        mediaBox.setItems(mediaList);
    }
    
    @FXML
    public void voltarAvaliacoes(ActionEvent evento){
        GerenciadorJanela.obterInstancia().voltar();
        //System.out.println(disciplinasBox.getValue());
    }
    
    @FXML
    public void salvarAvaliacao(ActionEvent evento){
        System.out.println("Entrou aqui");
        Avaliacao ava = new Avaliacao();
        ava.setNome(nomeAvaliacao.getText());
        double peso = Double.parseDouble(pesoAvaliacao.getText());
        ava.setPeso(peso);
        ava.setDisciplina((String) disciplinasBox.getValue());
        ava.setMedia((String)mediaBox.getValue());
        ava.salvar();
        GerenciadorJanela.obterInstancia().voltar();
    }
    
}

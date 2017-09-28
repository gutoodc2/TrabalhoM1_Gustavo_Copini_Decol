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


public class MeuDesempenhoController extends InterfaceUsuario {

    public MeuDesempenhoController(){
        super("MeuDesempenho.fxml");
    }
    
    @FXML
    private ComboBox disciplinasBox;
    
    ObservableList<String> disciplinasList = FXCollections
                          .observableArrayList("Arquitetura de Computadores II",
                                                "Programação Orientada a Obejtos");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        disciplinasBox.setValue("Selecione a Disciplina");
        disciplinasBox.setItems(disciplinasList);
    }
    
    @FXML
    public void mostrarDesempenho(ActionEvent evento){
        
        
        
    }
    
    //Voltando para a primeira tela
    @FXML
    public void voltarTelaInicial(ActionEvent evento){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
}

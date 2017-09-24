/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_m1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class InformarNotaController extends InterfaceUsuario {

    public InformarNotaController(){
        super("InformarNota.fxml");
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Janela de informar notas aberta");
    }    
    
    @FXML
    public void voltarAvaliacoes(ActionEvent evento){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
}

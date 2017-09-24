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


public class MeuDesempenhoController extends InterfaceUsuario {

    public MeuDesempenhoController(){
        super("MeuDesempenho.fxml");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Desempenho aberto");
    }
    
    //Voltando para a primeira tela
    @FXML
    public void voltarTelaInicial(ActionEvent evento){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
}

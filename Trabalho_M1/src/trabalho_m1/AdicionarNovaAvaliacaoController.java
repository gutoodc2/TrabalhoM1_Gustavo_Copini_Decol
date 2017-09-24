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

/**
 * FXML Controller class
 *
 * @author gusta
 */
public class AdicionarNovaAvaliacaoController extends InterfaceUsuario {

    public AdicionarNovaAvaliacaoController(){
        super("AdicionarNovaAvaliacao.fxml");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Adicionar Nova Avaliação aberta");
    }
    
    @FXML
    public void voltarAvaliacoes(ActionEvent evento){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
}

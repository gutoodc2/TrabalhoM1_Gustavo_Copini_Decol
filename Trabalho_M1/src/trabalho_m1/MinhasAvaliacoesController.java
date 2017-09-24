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


public class MinhasAvaliacoesController extends InterfaceUsuario{

    public MinhasAvaliacoesController(){
        super("MinhasAvaliacoes.fxml");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Minhas Avaliações aberto");
    }
    
    @FXML
    public void informarNota(ActionEvent evento){
        InformarNotaController telaInformar = new InformarNotaController();
        GerenciadorJanela.obterInstancia().abreJanela(telaInformar);
    }
 
    @FXML
    public void adicionarNovaAvaliacao(ActionEvent evento){
        AdicionarNovaAvaliacaoController telaAdicionar = new AdicionarNovaAvaliacaoController();
        GerenciadorJanela.obterInstancia().abreJanela(telaAdicionar);
    }
    
    @FXML
    public void voltarJanelaInicial(ActionEvent evento){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
}

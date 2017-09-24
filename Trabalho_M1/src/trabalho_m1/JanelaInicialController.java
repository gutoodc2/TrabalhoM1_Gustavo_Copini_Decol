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


public class JanelaInicialController extends InterfaceUsuario {

    //Criando construtor para o nosso controlador da janela principal, chamando ela mesma
    public JanelaInicialController(){
        super("JanelaInicial.fxml");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    //Ação para o primeiro botão que leva para as avaliações
    @FXML
    public void minhasAvaliacoes(ActionEvent evento){
        MinhasAvaliacoesController telaAvaliacoes = new MinhasAvaliacoesController();
        GerenciadorJanela.obterInstancia().abreJanela(telaAvaliacoes);
    }
    
    //Ação para o segundo botão que leva para o desempenho
    @FXML
    public void meuDesempenho(ActionEvent evento){
        MeuDesempenhoController telaDesempenho = new MeuDesempenhoController();
        GerenciadorJanela.obterInstancia().abreJanela(telaDesempenho);
    }
    
}

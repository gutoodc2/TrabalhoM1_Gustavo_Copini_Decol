/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_m1;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author gusta
 */
public class Trabalho_M1 extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    //Inicializando o programa pela janela principal
    public void start(Stage primaryStage)  {
        JanelaInicialController telaInicial = new JanelaInicialController();
        GerenciadorJanela.obterInstancia().inicializaPalco(primaryStage, telaInicial);
    }
    
}

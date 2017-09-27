/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_m1;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class MinhasAvaliacoesController extends InterfaceUsuario{
    
        
    //Declarando a tabela
    @FXML
    TableView<Avaliacao> tabela;
    @FXML
    TableColumn<Avaliacao, String> nome;
    @FXML
    TableColumn<Avaliacao, String> disciplina;
    @FXML
    TableColumn<Avaliacao, Double> peso;
    @FXML
    TableColumn<Avaliacao, String> media;
    @FXML
    TableColumn<Avaliacao, Double> nota;
    
    /*private ObservableList informacoes;
    
    private ObservableList inserirTabela(){
        
        Avaliacao ava = new Avaliacao();
        ArrayList <Avaliacao> avaliacoes = ava.obterListaAvaliacoes();
        
        ObservableList dado = FXCollections.observableList(avaliacoes);
        
        return dado;
    }*/

    public MinhasAvaliacoesController(){
        super("MinhasAvaliacoes.fxml");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        System.out.println("Minhas Avaliações aberto");
//        Avaliacao ava = new Avaliacao();
        ArrayList <Avaliacao> avaliacoes = Avaliacao.obterListaAvaliacoes();
        
        ObservableList<Avaliacao> listaObservavel = FXCollections.observableArrayList(avaliacoes);
        
        
        nome.setCellValueFactory(new PropertyValueFactory<Avaliacao, String>("nome"));
        disciplina.setCellValueFactory(new PropertyValueFactory<Avaliacao, String>("disciplina"));
        tabela.setItems(listaObservavel);
        
//        for(int i=0;i<avaliacoes.size();i++){
//        
            
//        
//        }
        /*this.informacoes = inserirTabela();
        tabela.setItems(informacoes);
        
        disciplina.setCellValueFactory(new PropertyValueFactory("nome"));*/
        
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

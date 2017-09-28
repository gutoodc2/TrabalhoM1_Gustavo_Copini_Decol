/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_m1;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MinhasAvaliacoesController extends InterfaceUsuario {

    //Declarando a tabela
    @FXML
    TableView<Avaliacao> tabelaid;
    @FXML
    TableColumn<Avaliacao, String> nomeTabela;
    @FXML
    TableColumn<Avaliacao, String> disciplinaTabela;
    @FXML
    TableColumn<Avaliacao, Double> pesoTabela;
    @FXML
    TableColumn<Avaliacao, String> mediaTabela;
    @FXML
    TableColumn<Avaliacao, Double> notaTabela;

    public MinhasAvaliacoesController() {
        super("MinhasAvaliacoes.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ArrayList<Avaliacao> listaObservadora = Avaliacao.obterListaAvaliacoes();
        ObservableList<Avaliacao> listaObservavel = FXCollections.observableArrayList();
        int i=0;
        while(i<listaObservadora.size()){
            listaObservavel.add(listaObservadora.get(i));
            i++;
        }

        nomeTabela.setCellValueFactory(new PropertyValueFactory<Avaliacao, String>("nome"));
        disciplinaTabela.setCellValueFactory(new PropertyValueFactory<Avaliacao, String>("disciplina"));
        mediaTabela.setCellValueFactory(new PropertyValueFactory<Avaliacao, String>("media"));
        pesoTabela.setCellValueFactory(new PropertyValueFactory<Avaliacao, Double>("peso"));
        notaTabela.setCellValueFactory(new PropertyValueFactory<Avaliacao, Double>("nota"));
        tabelaid.setItems(listaObservavel);
        
    }

    @FXML
    public void informarNota(ActionEvent evento) {
        InformarNotaController telaInformar = new InformarNotaController();
        telaInformar.setIndex(tabelaid.getSelectionModel().getSelectedItem().getIdentificadorNoArquivo());
        GerenciadorJanela.obterInstancia().abreJanela(telaInformar);
    }

    @FXML
    public void adicionarNovaAvaliacao(ActionEvent evento) {
        AdicionarNovaAvaliacaoController telaAdicionar = new AdicionarNovaAvaliacaoController();
        GerenciadorJanela.obterInstancia().abreJanela(telaAdicionar);
    }

    @FXML
    public void voltarJanelaInicial(ActionEvent evento) {
        GerenciadorJanela.obterInstancia().voltar();
    }

}

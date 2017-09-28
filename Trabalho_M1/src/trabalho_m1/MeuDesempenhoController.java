/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_m1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;

public class MeuDesempenhoController extends InterfaceUsuario {

    public MeuDesempenhoController() {
        super("MeuDesempenho.fxml");
    }

    @FXML
    private ComboBox disciplinasBox;

    @FXML
    private BarChart<?, ?> grafico;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    ObservableList<String> disciplinasList = FXCollections
            .observableArrayList("Arquitetura de Computadores II",
                    "Programação Orientada a Obejtos");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        disciplinasBox.setValue("Selecione a Disciplina");
        disciplinasBox.setItems(disciplinasList);
    }

    @FXML
    public void mostrarDesempenho(ActionEvent evento) {

        ArrayList<String> salva = new ArrayList();
        try {
            FileReader arq = new FileReader("listadeavaliacoes.csv");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                salva.add(linha);
                linha = lerArq.readLine();
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        String dado = new String();
        Double m1 = 0.0;
        Double m2 = 0.0;
        Double m3 = 0.0;
        Double pesoTotalM1 = 0.0;
        Double pesoTotalM2 = 0.0;
        Double pesoTotalM3 = 0.0;
        int i = 0;
        while (i < salva.size()) {
            String[] separa = salva.get(i).split(",");

            if (separa[0].equals(disciplinasBox.getValue()) && separa[1].equals("M1")) {
                m1 += Double.parseDouble(separa[4]) * Double.parseDouble(separa[3]);
                pesoTotalM1 += Double.parseDouble(separa[3]);
            }

            if (separa[0].equals(disciplinasBox.getValue()) && separa[1].equals("M2")) {
                m2 += Double.parseDouble(separa[4]) * Double.parseDouble(separa[3]);
                pesoTotalM2 += Double.parseDouble(separa[3]);
            }

            if (separa[0].equals(disciplinasBox.getValue()) && separa[1].equals("M3")) {
                m3 += Double.parseDouble(separa[4]) * Double.parseDouble(separa[3]);
                pesoTotalM3 += Double.parseDouble(separa[3]);
            }
            i++;
        }
        if (pesoTotalM1 != 0) {
            m1 = m1 / pesoTotalM1;
        }
        if (pesoTotalM2 != 0) {
            m2 = m2 / pesoTotalM2;
        }
        if (pesoTotalM3 != 0) {
            m3 = m3 / pesoTotalM3;
        }

        Double mf = Avaliacao.calculaMediaDaDisciplina(m1, m2, m3);
        XYChart.Series setTira = new XYChart.Series();
        setTira.getData().add(new XYChart.Data("M1", m1));
        setTira.getData().add(new XYChart.Data("M2", m2));
        setTira.getData().add(new XYChart.Data("M3", m3));
        setTira.getData().add(new XYChart.Data("MF", mf));
        grafico.getData().addAll(setTira);

    }

    //Voltando para a primeira tela
    @FXML
    public void voltarTelaInicial(ActionEvent evento) {
        GerenciadorJanela.obterInstancia().voltar();
    }

}

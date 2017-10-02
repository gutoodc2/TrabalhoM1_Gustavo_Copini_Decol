/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_m1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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

    //Declarando as variaveis do FXML
    @FXML
    private ComboBox disciplinasBox;

    @FXML
    private BarChart<?, ?> grafico;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    //Criando uma coleção dos itens para colocar nos combos box
    ObservableList<String> disciplinasList = FXCollections
            .observableArrayList("MATEMÁTICA COMPUTACIONAL",
                    "ALGORITMOS E PROGRAMAÇÃO", "ÁLGEBRA", "INTRODUÇÃO AO CÁLCULO", "INICIAÇÃO TÉCNICO-CIENTÍFICA",
                    "INTRODUÇÃO A ENGENHARIA DE COMPUTAÇÃO", "INTRODUÇÃO À FÍSICA", "CÁLCULO", "ALGORITMOS E PROGRAMAÇÃO II",
                    "CIRCUITOS DIGITAIS", "DESENHO TÉCNICO", "FÍSICA GERAL", "ÁLGEBRA", "CÁLCULO II", "ESTRUTURAS DE DADOS",
                    "PROGRAMAÇÃO ORIENTADA A OBJETOS", "ARQUITETURA DE COMPUTADORES", "FÍSICA III", "QUÍMICA",
                    "ARQUITETURA DE COMPUTADORES II", "PROGRAMAÇÃO ORIENTADA A OBJETOS II", "CÁLCULO III", "ANÁLISE DE CIRCUITOS ELÉTRICOS",
                    "QUÍMICA II", "ÓTICA E FÍSICA PARA SEMICONDUTORES", "RESISTÊNCIA DOS MATERIAIS", "BANCO DE DADOS",
                    "SISTEMAS OPERACIONAIS", "MATEMÁTICA APLICADA À ENGENHARIA", "ENGENHARIA DE SOFTWARE", "PROBABILIDADE E ESTATÍSTICA",
                    "ELETRÔNICA BÁSICA", "INTERFACE HUMANO - COMPUTADOR", "ENGENHARIA DE SOFTWARE II", "REDES DE COMPUTADORES",
                    "CÁLCULO NUMERICO", "LINGUAGENS FORMAIS", "ELETRÔNICA APLICADA", "ANÁLISE E CONTROLE DE PROCESSOS",
                    "ENGENHARIA ECONÔMICA", "REDES DE COMPUTADORES II", "GRAFOS", "CONTROLE LÓGICO DE SISTEMAS", "MICROCONTROLADORES",
                    "PROJETO DE SISTEMAS DIGITAIS", "INTELIGÊNCIA ARTIFICIAL", "TRABALHO TÉC.-CIENTÍF.DE CONCLUSÃO DE CURSO",
                    "PROJETO DE SISTEMAS EMBARCADOS", "SISTEMAS EM TEMPO REAL", "COMUNICAÇÃO DIGITAL", "PROCESSADOR DIGITAL DE SINAIS",
                    "SISTEMAS ROBÓTICOS", "SIMULAÇÃO DISCRETA", "GERÊNCIA DE PROJETOS", "TÓPICOS ESPECIAIS EM ENGENHARIA DE COMPUTAÇÃO",
                    "TÓPICOS ESPECIAIS EM HARDWARE", "TRABALHO TÉC-CIENTÍF. DE CONCLUSÃO DE CURSO II",
                    "ADMINISTRAÇÃO DE NEGÓCIOS DE BASE TECNOLÓGICA", "TÓP. ESPECIAIS EM INTEGRAÇÃO SOFTWARE HARDWARE",
                    "TRABALHO TÉC-CIENTÍFICO DE CONCLUSÃO DE CURSO III", "SISTEMAS DISTRIBUÍDOS");

    //Initialize responsavel por colocar a coleção na comboBox e colocar um texto inicial no mesmo
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        disciplinasBox.setValue("ÉTICA EM INFORMÁTICA");
        disciplinasBox.setItems(disciplinasList);
    }

    //Botão responsavel por carregar todas as notas da disciplina selecionada na comboBox pelo usuário,
    //e calcular a média adicionando tudo no gráfico para ser analisado
    @FXML
    public void mostrarDesempenho(ActionEvent evento) {

        //Primeiro coloco todo o arquivo de avaliações em um arraylist
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

        //Atribuo valores iniciais para as variaveis utilizadas posteriormente
        String dado = new String();
        Double m1 = 0.0;
        Double m2 = 0.0;
        Double m3 = 0.0;
        Double pesoTotalM1 = 0.0;
        Double pesoTotalM2 = 0.0;
        Double pesoTotalM3 = 0.0;
        int i = 0;
        //Laço om varios if's dentro que verificam todas as posições do vetor, atras das notas,
        //da disciplina escolhida pelo usuário no comboBox
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
        //Condição para que existam os pesos necessarios para serem calculadas as m's,
        //evitam uma divisão por 0 da nota...
        if (pesoTotalM1 != 0) {
            m1 = m1 / pesoTotalM1;
        }
        if (pesoTotalM2 != 0) {
            m2 = m2 / pesoTotalM2;
        }
        if (pesoTotalM3 != 0) {
            m3 = m3 / pesoTotalM3;
        }
        //Calcula a média final e insire todos os dados adquiridos no gráfico
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

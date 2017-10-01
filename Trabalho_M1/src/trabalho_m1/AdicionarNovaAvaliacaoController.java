/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_m1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author gusta
 */
public class AdicionarNovaAvaliacaoController extends InterfaceUsuario {

    public AdicionarNovaAvaliacaoController(){
        super("AdicionarNovaAvaliacao.fxml");
    }
    
    //Criando uma coleção dos itens para colocar nos combos box
    ObservableList<String> disciplinasList = FXCollections
                            .observableArrayList("ÉTICA EM INFORMÁTICA","MATEMÁTICA COMPUTACIONAL",
    "ALGORITMOS E PROGRAMAÇÃO","ÁLGEBRA","INTRODUÇÃO AO CÁLCULO","INICIAÇÃO TÉCNICO-CIENTÍFICA",
    "INTRODUÇÃO A ENGENHARIA DE COMPUTAÇÃO","INTRODUÇÃO À FÍSICA","CÁLCULO","ALGORITMOS E PROGRAMAÇÃO II",
    "CIRCUITOS DIGITAIS","DESENHO TÉCNICO","FÍSICA GERAL","ÁLGEBRA","CÁLCULO II","ESTRUTURAS DE DADOS",
    "PROGRAMAÇÃO ORIENTADA A OBJETOS","ARQUITETURA DE COMPUTADORES","FÍSICA III","QUÍMICA",
    "ARQUITETURA DE COMPUTADORES II","PROGRAMAÇÃO ORIENTADA A OBJETOS II","CÁLCULO III","ANÁLISE DE CIRCUITOS ELÉTRICOS",
    "QUÍMICA II","ÓTICA E FÍSICA PARA SEMICONDUTORES","RESISTÊNCIA DOS MATERIAIS","BANCO DE DADOS",
    "SISTEMAS OPERACIONAIS","MATEMÁTICA APLICADA À ENGENHARIA","ENGENHARIA DE SOFTWARE","PROBABILIDADE E ESTATÍSTICA",
    "ELETRÔNICA BÁSICA","INTERFACE HUMANO - COMPUTADOR","ENGENHARIA DE SOFTWARE II","REDES DE COMPUTADORES",
    "CÁLCULO NUMERICO","LINGUAGENS FORMAIS","ELETRÔNICA APLICADA","ANÁLISE E CONTROLE DE PROCESSOS",
    "ENGENHARIA ECONÔMICA","REDES DE COMPUTADORES II","GRAFOS","CONTROLE LÓGICO DE SISTEMAS","MICROCONTROLADORES",
    "PROJETO DE SISTEMAS DIGITAIS","INTELIGÊNCIA ARTIFICIAL","TRABALHO TÉC.-CIENTÍF.DE CONCLUSÃO DE CURSO",
    "PROJETO DE SISTEMAS EMBARCADOS","SISTEMAS EM TEMPO REAL","COMUNICAÇÃO DIGITAL","PROCESSADOR DIGITAL DE SINAIS",
    "SISTEMAS ROBÓTICOS","SIMULAÇÃO DISCRETA","GERÊNCIA DE PROJETOS","TÓPICOS ESPECIAIS EM ENGENHARIA DE COMPUTAÇÃO",
    "TÓPICOS ESPECIAIS EM HARDWARE","TRABALHO TÉC-CIENTÍF. DE CONCLUSÃO DE CURSO II",
    "ADMINISTRAÇÃO DE NEGÓCIOS DE BASE TECNOLÓGICA","TÓP. ESPECIAIS EM INTEGRAÇÃO SOFTWARE HARDWARE",
    "TRABALHO TÉC-CIENTÍFICO DE CONCLUSÃO DE CURSO III","SISTEMAS DISTRIBUÍDOS");
    
    //Criando uma coleção dos itens para colocar nos combos box
    ObservableList<String> mediaList = FXCollections
                            .observableArrayList("M1","M2","M3");
    
    //Declarando as variaveis do FXML
    @FXML
    private ComboBox disciplinasBox;
    
    @FXML
    private ComboBox mediaBox;
    
    @FXML
    private TextField nomeAvaliacao;
    
    @FXML
    private TextField pesoAvaliacao;
    
    
    //Initialize coloca as coleções criadas anteriormente nas devidas comboBox e também coloca
    //uma mensagem nas mesmas indicando que devem ser selecionadas
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        disciplinasBox.setValue("Selecione a Disciplina");
        disciplinasBox.setItems(disciplinasList);
        mediaBox.setValue("Selecione a Média");
        mediaBox.setItems(mediaList);
    }
    
    //Botão para voltar para a janela das avaliações
    @FXML
    public void voltarAvaliacoes(ActionEvent evento){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    //Botão responsavel por pegar os dados da avaliação criada pelo usuario, colocar em um objeto e passar
    //o mesmo para a função salvar na classe avaliação, que ira salvar o mesmo em um arquivo.csv
    @FXML
    public void salvarAvaliacao(ActionEvent evento){
        Avaliacao ava = new Avaliacao();
        ava.setNome(nomeAvaliacao.getText());
        double peso = Double.parseDouble(pesoAvaliacao.getText());
        ava.setPeso(peso);
        ava.setDisciplina((String) disciplinasBox.getValue());
        ava.setMedia((String)mediaBox.getValue());
        ava.salvar();
        ava.atualizar();
    }
    
}

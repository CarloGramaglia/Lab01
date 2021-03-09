package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private TextArea txtTempo;
    
    @FXML
    void doInsert(ActionEvent event) {
    	long tempoInizio = System.nanoTime();
    	
    	if(txtParola.getText().equals("")) {
    		txtResult.appendText("Inserire una parola per cortesia!");
    		return;
    	}
    	else
    		elenco.addParola(txtParola.getText());
    	
    	txtResult.setText(elenco.stampaElenco());
    	txtParola.clear();
    	long tempoFine = System.nanoTime();
    	txtTempo.appendText("Tempo impiegato: "+(tempoFine-tempoInizio)+"ns\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	long tempoInizio = System.nanoTime();
    	elenco.reset();
    	txtResult.clear();
    	long tempoFine = System.nanoTime();
    	txtTempo.appendText("Tempo impiegato: "+(tempoFine-tempoInizio)+"ns\n");
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	long tempoInizio = System.nanoTime();
    	if(!txtParola.getText().equals("")) {
    		elenco.cancella(txtParola.getText());
    	}
    	else
    		txtResult.appendText("Inserire una parola da cancellare per cortesia!");
    	
    	txtResult.setText(elenco.stampaElenco());
    	txtParola.clear();
    	long tempoFine = System.nanoTime();
    	txtTempo.appendText("Tempo impiegato: "+(tempoFine-tempoInizio)+"ns\n");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}

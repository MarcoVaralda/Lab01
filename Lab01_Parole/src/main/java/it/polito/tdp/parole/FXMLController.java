package it.polito.tdp.parole;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.parole.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Parole elenco ;
	LinkedList<String> listaParole;

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
    private TextField txtTempoLinkedList;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	double start;
    	double stop;
    	
    	start=System.nanoTime();
    	
    	String parolaInserita = txtParola.getText();
    	if(elenco.contiene(parolaInserita)) {
    		txtParola.setText("");
    		return;
    	}
    	elenco.addParola(parolaInserita);

    	listaParole = new LinkedList<String>(elenco.getElenco());    	
    	String risultato = "";
    	for(String s : listaParole) {
    		risultato = risultato + s+"\n";
    	}

    	txtResult.setText(risultato);
    	txtParola.setText("");
    	
    	stop=System.nanoTime();    	
    	txtTempoLinkedList.setText((stop-start)+" nanosecondi");
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	double start;
    	double stop;
    	
    	start=System.nanoTime();
    	
    	txtResult.setText("");
    	elenco.reset();
    	listaParole.clear();
    	
    	stop=System.nanoTime();    	
    	txtTempoLinkedList.setText((stop-start)+" nanosecondi");
    }
    
    @FXML
    void handleCancella(ActionEvent event) {
    	
    	double start;
    	double stop;
    	
    	start=System.nanoTime();
    	
    	String daCancellare = txtResult.getSelectedText();
    	
    	if(listaParole.contains(daCancellare))
    		elenco.cancellaParola(daCancellare);
    	
    	listaParole = new LinkedList<String>(elenco.getElenco());
    	String risultato = "";
    	for(String s : listaParole) {
    		risultato = risultato + s+"\n";
    	}

    	txtResult.setText(risultato);
    	txtParola.setText("");
    	
    	stop=System.nanoTime();    	
    	txtTempoLinkedList.setText((stop-start)+" nanosecondi");
    }

    @FXML
    void initialize() {
    	assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempoLinkedList != null : "fx:id=\"txtTempoLinkedList\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}

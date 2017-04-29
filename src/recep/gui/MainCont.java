package recep.gui;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import recep.dao.DAO;
import recep.entity.HangiKurs;
 
public class MainCont  implements Initializable {
	private DAO dao = new DAO();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
 
	@FXML
	public void onClickKayit(){
		Stage primaryStage = new Stage(); 
		try {
			primaryStage.setTitle("Personel Kay�t Program�");
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("KayitGir.fxml"));
			Scene scene = new Scene(root,370,520);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onClickSorgula(){
		Stage primaryStage = new Stage(); 
		try {
			primaryStage.setTitle("Personel Kay�t Program�");
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Sorgula.fxml"));
			Scene scene = new Scene(root,753,518);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onClickKursEkle(){
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Personel Kay�t Program�");
		dialog.setHeaderText("Eklenecek Kursu Yaz�n�z");
		dialog.setContentText("Kurs ad�:");
		
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    HangiKurs hangiKurs = new HangiKurs(result.get());
		    dao.addValue(hangiKurs);
		}
	}
	
	@FXML
	public void onClickKursSil(){
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Personel Kay�t Program�");
		dialog.setHeaderText("Silinecek Kursu Yaz�n�z");
		dialog.setContentText("Kurs ad�:");
		
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    HangiKurs hangiKurs = new HangiKurs(result.get());
		    
		    dao.deleteValue(hangiKurs);
		}
	}
       
}
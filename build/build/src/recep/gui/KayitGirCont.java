package recep.gui;

import java.net.URL;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import recep.dao.DAO;
import recep.entity.HangiKurs;
import recep.entity.Person;

public class KayitGirCont implements Initializable {
	private DAO dao = new DAO();
	
	@FXML private TextField txtAd;
	@FXML private TextField txtSoyad;
	@FXML private TextField txtTel;
	@FXML private TextField txtEmail;
	@FXML private TextArea txtMesaj;
	
	@FXML private RadioButton radioTel;
	@FXML private RadioButton radioYuz;
	
	@FXML private ComboBox<String> comboHagiKurs;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ToggleGroup group = new ToggleGroup();
		radioTel.setSelected(true);
		radioTel.setToggleGroup(group);
		radioYuz.setToggleGroup(group);	
		
		
		List<HangiKurs> myList = dao.getHangiKursList();
		String[] kursAd = new String[myList.size()];
		for(int i=0 ; i < myList.size() ; i ++ ){
			kursAd[i] = dao.getHangiKursList().get(i).getKursAdi();
		}
		
		ObservableList<String> data = FXCollections.observableArrayList(kursAd);
		comboHagiKurs.setItems(data);
		
	}
	
	@FXML
	public void onClickKaydet(){
		int gorusmeTipi;
		if(radioTel.isSelected()){
			gorusmeTipi=1;
		} else {
			gorusmeTipi=2;
		}
		
		Person person = new Person(txtAd.getText(), txtSoyad.getText(), txtTel.getText(), txtEmail.getText(),
				comboHagiKurs.getValue(), gorusmeTipi, txtMesaj.getText(), Calendar.getInstance().getTime());
		
		dao.addValue(person);
		
	}

}

package recep.gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import recep.dao.DAO;
import recep.entity.HangiKurs;
import recep.entity.Person;
import recep.entity.SorgulaEntity;

public class SorgulaCont implements Initializable {
	private DAO dao = new DAO();

	@FXML
	private TextField txtAd;
	@FXML
	private TextField txtSoyad;

	@FXML
	private DatePicker dateBas;
	@FXML
	private DatePicker dateSon;

	@FXML
	private RadioButton radioTel;
	@FXML
	private RadioButton radioYuz;

	@FXML
	private ComboBox<String> comboHagiKurs;

	@FXML
	private TableView<Person> tableList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ToggleGroup group = new ToggleGroup();
		radioTel.setSelected(true);
		radioTel.setToggleGroup(group);
		radioYuz.setToggleGroup(group);

		List<HangiKurs> myList = dao.getHangiKursList();
		String[] kursAd = new String[myList.size()];
		for (int i = 0; i < myList.size(); i++) {
			kursAd[i] = dao.getHangiKursList().get(i).getKursAdi();
		}

		ObservableList<String> data = FXCollections.observableArrayList(kursAd);
		comboHagiKurs.setAccessibleText("Android");
		comboHagiKurs.setItems(data);

		TableColumn adtc = new TableColumn("Adý");
		adtc.setCellValueFactory(new PropertyValueFactory<Person, String>("ad"));

		TableColumn soyadýtc = new TableColumn("Soyadý");
		soyadýtc.setCellValueFactory(new PropertyValueFactory<Person, String>("soyad"));

		TableColumn teltc = new TableColumn("Telefon nu");
		teltc.setMinWidth(150);
		teltc.setCellValueFactory(new PropertyValueFactory<Person, String>("telefon"));

		TableColumn mailtc = new TableColumn("E-mail");
		mailtc.setMinWidth(150);
		mailtc.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));

		TableColumn mesajtc = new TableColumn("Mesaj");
		mesajtc.setMinWidth(150);
		mesajtc.setCellValueFactory(new PropertyValueFactory<Person, String>("mesaj"));

		TableColumn timetc = new TableColumn("Görüþme Zamaný");
		timetc.setMinWidth(150);
		timetc.setCellValueFactory(new PropertyValueFactory<Person, String>("gorusmeZamani"));

		tableList.getColumns().addAll(adtc, soyadýtc, teltc, mailtc, timetc, mesajtc);
	}

	@FXML
	public void onClickSorgula() {
		String ad = null, soyad = null, hangiKurs = null;
		Date date1 = null, date2 = null;
		int gorusmeTipi = 0;
		LocalDate ld;
		Calendar c;
		if (radioTel.isSelected()) {
			gorusmeTipi = 1;
		} else {
			gorusmeTipi = 2;
		}

		if (this.txtAd.getText().length() > 0) {
			ad = this.txtAd.getText();
		}
		if (this.txtSoyad.getText().length() > 0) {
			soyad = this.txtSoyad.getText();
		}
		if (this.comboHagiKurs.getValue() != null) {
			hangiKurs = this.comboHagiKurs.getValue();
		}

		if (this.dateBas.getValue() != null) {

			 ld = dateBas.getValue();
			 c = Calendar.getInstance();
			 c.set(ld.getYear(), ld.getMonthValue()-1, ld.getDayOfMonth());
			 date1 = c.getTime();

			//date1= new Date(dateBas.getValue().toEpochDay());
		}

		if (this.dateSon.getValue() != null) {
			
			ld = dateSon.getValue();
			c = Calendar.getInstance();
			c.set(ld.getYear(), ld.getMonthValue()-1, ld.getDayOfMonth());
			date2 = c.getTime();
			
			//date2 = new Date(dateSon.getValue().toEpochDay());
		}

		SorgulaEntity sorgulaEntity = new SorgulaEntity(ad, soyad, date1, date2, hangiKurs, gorusmeTipi);

		List<Person> list = dao.sorgula(sorgulaEntity);

		ObservableList<Person> data = FXCollections.observableArrayList(list);
		tableList.setItems(data);
		// table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

	}

}

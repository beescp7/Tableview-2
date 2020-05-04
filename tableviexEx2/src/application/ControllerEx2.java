package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ControllerEx2  implements Initializable{

    @FXML
    private TableView<Personel> tableex2;

    @FXML
    private TableColumn<Personel, String> tc_ad;

    @FXML
    private TableColumn<Personel, String> tc_sehir;

    @FXML
    private TableColumn<Personel, String> tc_cinsiyet;

    @FXML
    private TableColumn<Personel, String> tc_durum;
    @FXML
    private TableColumn<Personel, Double> tc_maas;

    @FXML
    private TextField txt_ad;

    @FXML
    private ComboBox<String> cmbx_sehir;

    @FXML
    private RadioButton rb_erkek;

    @FXML
    private ToggleGroup cinsiyet;

    @FXML
    private RadioButton rb_kadin;

    @FXML
    private CheckBox chk_durum;

    @FXML
    private Button btn_goster;

    @FXML
    private Button btn_ekle;
    @FXML
    private Slider slider1;

    @FXML
    private Label lbl_maas;

    @FXML
    void event_ekle(ActionEvent event) {
   ObservableList<Personel> veriler=FXCollections.observableArrayList();
    	 
    	 String ad1=txt_ad.getText();
    	 String sehir1=cmbx_sehir.getSelectionModel().getSelectedItem();
    	 String cinsiyet1=null;
    	 if(rb_erkek.isSelected())
    	 {
    		 cinsiyet1="erkek";
    	 }
    	 if(rb_kadin.isSelected())
    	 {
    		 cinsiyet1="kadin";
    	 }
    	 String durum1=null;
    	 if(chk_durum.isSelected())
    	 {
    		 durum1="calisiyor";
    	 }
    	 else
    	 {
    		 durum1="calismiyor";
    	 }
    	 Double maas1=Double.parseDouble(lbl_maas.getText());
    	 veriler.add(new Personel(ad1,sehir1, cinsiyet1,durum1,maas1));
    	 tableex2.getItems().addAll(veriler);
    	 txt_ad.setText("");
    	 
    	 System.out.println("sýkýntýsýz calýstý");
        
    }
    

    @FXML
    void event_goster(ActionEvent event) {
     
    }
    @FXML
    void event_clk(MouseEvent event) {
    	Personel kayit = new Personel();
		kayit = (Personel) tableex2.getItems().get(tableex2.getSelectionModel().getSelectedIndex());
		txt_ad.setText(kayit.getAd());
		cmbx_sehir.setValue(kayit.getSehir());
		if(kayit.getCinsiyet().equals("erkek"))
		{
			rb_erkek.setSelected(true);
		}
		if(kayit.getCinsiyet().equals("kadin"))
		{
			rb_kadin.setSelected(true);
		}
		
		if(kayit.getDurum().equals("calisiyor"))
		{
			chk_durum.setSelected(true);
		}
		else
		{
			chk_durum.setSelected(false);
		}
		slider1.setValue(kayit.getMaas());
		lbl_maas.setText(kayit.getMaas().toString());

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tc_ad.setCellValueFactory(new PropertyValueFactory<>("ad"));
		tc_sehir.setCellValueFactory(new PropertyValueFactory<>("sehir"));
		tc_cinsiyet.setCellValueFactory(new PropertyValueFactory<>("cinsiyet"));
		tc_durum.setCellValueFactory(new PropertyValueFactory<>("durum"));
		tc_maas.setCellValueFactory(new PropertyValueFactory<>("maas"));
		cmbx_sehir.getItems().addAll("Bursa", "Ankara", "Istanbul", "Ýzmir", "Adana");
		slider1.valueProperty().addListener((obs, OldValue, newValue) -> {

			lbl_maas.setText(newValue.toString());
		});
		
	}

}

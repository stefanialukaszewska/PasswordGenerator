import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;


public class AppController {
    @FXML
    public Label title;
    @FXML
    public TextField password;
    @FXML
    public Slider slider;
    @FXML
    public Label passwordLength;

    int length;
    public void initialize(){
        title.setText("Generate random password");
        length=10;
        password.setText(Generator.GeneratePassword(length));
        setSlider();
        passwordLength.setText("Password length: "+length);
    }

    public void setSlider(){
        slider.setValue(length);
        slider.setMax(50);
        slider.setMin(0);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(10);
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                length = (int) slider.getValue();
                passwordLength.setText("Password length: "+length);
                password.setText(Generator.GeneratePassword(length));

            }
        });


    }


}

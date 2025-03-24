import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;


public class AppController {
    public VBox root;
    public Label title;
    public TextField password;
    public Slider slider;
    public Label passwordLength;
    public Button copyButton;
    public Button refreshButton;
    public Button minus;
    public Button plus;
    public Label customize;
    public RadioButton upperChars;
    public RadioButton lowerChars;
    public RadioButton numbers;
    public RadioButton symbols;
    public Label howStrong;

    int length;
    public void initialize(){
        password.setEditable(false);
        title.setText("Generate random password");
        length=10;
        radioButtonSelected();
        generator();
        setSlider();
        passwordLength.setText("Password length: "+length);
        customize.setText("Customize your password");
        radioButtonSelected();
        bindFontSizeToRootWidth();


    }

    public void setSlider(){
        slider.setValue(length);
        slider.setMax(50);
        slider.setMin(0);
        slider.setMajorTickUnit(10);
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                length = (int) slider.getValue();
                passwordLength.setText("Password length: "+length);
                generator();
            }
        });


    }


    public void copyPassword(ActionEvent actionEvent) {
        StringSelection stringSelection = new StringSelection(password.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public void refreshPassword(ActionEvent actionEvent) {
        generator();
    }

    public void minusPassword(ActionEvent actionEvent) {
        slider.setValue(slider.getValue()-1);
    }

    public void plusPassword(ActionEvent actionEvent) {
        slider.setValue(slider.getValue()+1);
    }

    private void bindFontSizeToRootWidth() {
        title.styleProperty().bind(
                root.widthProperty().divide(15).asString("-fx-font-size: %.0fpx;")
        );

        customize.styleProperty().bind(
                root.widthProperty().divide(20).asString("-fx-font-size: %.0fpx;")
        );
        passwordLength.styleProperty().bind(
                root.widthProperty().divide(30).asString("-fx-font-size: %.0fpx;")
        );

    }

    public void radioButtonSelected(){
        upperChars.setSelected(true);
        lowerChars.setSelected(true);
        numbers.setSelected(true);
        symbols.setSelected(true);
    }

    public boolean useUpperChars (){
        return upperChars.isSelected();
    }
    public boolean useLowerChars(){
        return lowerChars.isSelected();
    }
    public boolean useNumbers(){
        return numbers.isSelected();
    }
    public boolean useSigns(){
        return symbols.isSelected();
    }

    public void radioButtonAction(ActionEvent actionEvent) {
       generator();
    }

    public void setHowStrong() {
        if(password.getText().length()<7){
            howStrong.setText("WEAK");
            howStrong.setStyle("-fx-background-color: #e48080");
        } else if(password.getText().length()<10){
            howStrong.setText("GOOD");
            howStrong.setStyle("-fx-background-color: #efb766");
        } else if(password.getText().length()<13){
            howStrong.setText("STRONG");
            howStrong.setStyle("-fx-background-color: #85d185");
        } else {
            howStrong.setText("VERY STRONG");
            howStrong.setStyle("-fx-background-color: #7bc6df");
        }
    }

    public void generator(){
        password.setText(Generator.GeneratePassword(length,useLowerChars(),useUpperChars(),useNumbers(),useSigns()));
        setHowStrong();
    }
}

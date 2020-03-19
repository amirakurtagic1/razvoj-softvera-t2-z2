package ba.unsa.etf.tutorijal2;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    public TextField UneseniBroj;
    public TextArea NizBrojeva;

    public static int SumaCifara(int broj){

            int suma = 0, x;

           while(broj > 0){
                x = broj % 10;
                suma = suma + x;
                broj = broj / 10;
           }
           return suma;
    }

    public void OnClick(ActionEvent actionEvent) {

        if (UneseniBroj.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Niste unijeli broj!");
            alert.setContentText("Ponovite unos!");

            alert.showAndWait();
        } else {
            String s = new String();
            String newLine = System.getProperty("line.separator");
            s = UneseniBroj.getText();
            int broj = Integer.parseInt(s);
            String br = new String();

            for (int i = 1; i < broj; i++) {
                if (i % SumaCifara(i) == 0) {

                    br = br + String.format("%d", i) + newLine;
                }
            }

            NizBrojeva.setText("Svi brojevi koji se nalaze između 1 i n," + newLine + "a koji su djeljivi sa sumom svojih cifara su: " + newLine + br);

        }
    }
}

package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


import java.io.FileNotFoundException;

import java.net.URL;
import java.util.ResourceBundle;

public class Controllers implements Initializable
{
    @FXML
    private Button btnq1;

    @FXML
    private Button btnq2;

    @FXML
    private Button btnabout;

    @FXML
    private Button btnvalid;

    @FXML
    private Button btnDFA;

    @FXML
    private Button btnCFG;

    @FXML
    private AnchorPane pnlstatus;

    @FXML
    private Label lblstatus;

    @FXML
    private Label lblclose;

    @FXML
    private Label lblab;

    @FXML
    private TextField txtq1;

    public Controllers() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void handleClicks(ActionEvent event) throws FileNotFoundException
    {
        if(event.getSource() == btnq1)
        {
            lblstatus.setText("Regular Expression 1");
            lblab.setText("( bab + bbb ) a* b* ( a* + b* ) ( ba )* ( aba ) ( bab + aba )* bb ( a + b )* ( bab + aba ) ( a + b )*");
            pnlstatus.setBackground((new Background(new BackgroundFill(Color.rgb(255,255,255), CornerRadii.EMPTY, Insets.EMPTY))));
        }
        else if(event.getSource() == btnq2)
        {
            lblstatus.setText("Regular Expression 2");
            lblab.setText("( 1 + 0 )* 1* 0* ( 101 + 01 + 000 ) ( 1 + 0 )* ( 101 + 00 )* ( 111 + 00 + 101 ) ( 1 + 0 )*");
            pnlstatus.setBackground((new Background(new BackgroundFill(Color.rgb(255,255,255), CornerRadii.EMPTY, Insets.EMPTY))));
        }

        else if(event.getSource() == btnvalid)
        {
            TextField txtq1 = new TextField();
            String inputText = txtq1.getText();

            validity automata = new validity();
            automata.UserInputProcessor(inputText);
        }
    }

    @FXML
    private void handleclose(MouseEvent event)
    {
        if(event.getSource() == lblclose)
            System.exit(0);

    }
}

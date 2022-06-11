package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sourceFiles.*;

import java.text.SimpleDateFormat;
import java.text.Format;
import java.time.Year;
import java.time.YearMonth;

import javafx.scene.control.TextField;
import java.io.IOException;

public class BalanceController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private UserAccount user;
    private UserInstance holder;
    private Bank bank;
    private BankInstance bankholder;
    @FXML Label ba;
    @FXML Label nm;
    @FXML Label id;
    @FXML Label cn;
    @FXML Label cvc;
    @FXML Label exp;

    @FXML public void initialize(){
        holder=UserInstance.getInstance();
        user=holder.getUser();
        bankholder=BankInstance.getInstance();
        bank=bankholder.getBank();
        ba.setText(String.valueOf(user.checkBalance()));
        nm.setText(user.getFirstName());
        id.setText(user.getUserName());
        if(user.hasCard()){
            cn.setText(String.valueOf(user.getCard().getCardNumber()));
            cvc.setText(String.valueOf(user.getCard().getCVC()));
            Format f = new SimpleDateFormat("MM/yy");
            exp.setText(f.format(user.getCard().getExpiryDate()));
        }
    }
    public void getCard(ActionEvent event)throws Exception{
        holder = UserInstance.getInstance();
         user=holder.getUser();
         user.getCard();
         bank.updateAccount(user);
         bank.serializeDataOut();
         bankholder.setBank(bank);
        cn.setText(String.valueOf(user.getCard().getCardNumber()));
        cvc.setText(String.valueOf(user.getCard().getCVC()));
        Format f = new SimpleDateFormat("MM/yy");
        exp.setText(f.format(user.getCard().getExpiryDate()));
    }
    public void goToDashboard(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("AccountDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
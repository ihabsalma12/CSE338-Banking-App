package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sourceFiles.*;

import java.text.SimpleDateFormat;
import java.text.Format;
import java.time.Year;
import java.time.YearMonth;

import java.io.IOException;
import java.util.Date;

public class BankStatementController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private UserAccount user;
    private UserInstance holder;
    private Bank bank;
    private BankInstance bankholder;
    @FXML TableView<Transaction> table;
    @FXML TableColumn<Transaction,Date> date;
    @FXML TableColumn<Transaction,String>des;
    @FXML TableColumn<Transaction, Transaction.TransactionType>type;
    @FXML TableColumn<Transaction,Double>amount;
    @FXML TableColumn<Transaction,Double>balance;

    private ObservableList<Transaction> getCharacters() {
        ObservableList<Transaction> characters = FXCollections.observableArrayList();
        for (int i = 0; i < user.getStatement().size(); i++) {
            characters.add(user.getStatement().get(i));
        }
        return characters;
    }

    @FXML public void initialize() {
        holder = UserInstance.getInstance();
        user = holder.getUser();
        bankholder = BankInstance.getInstance();
        bank = bankholder.getBank();
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        des.setCellValueFactory(new PropertyValueFactory<>("description"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        balance.setCellValueFactory(new PropertyValueFactory<>("balance"));
        table.setItems(getCharacters());

    }
    public void goToDashboard(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("AccountDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

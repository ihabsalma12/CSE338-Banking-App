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

import javafx.scene.control.TextField;
import java.io.IOException;

public class MainController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Bank bank;
    private BankInstance bankholder;
    private UserAccount user;
    private UserInstance holder;
public MainController() throws Exception {
bank=new Bank();
}


    public void goToSignUpOrLogIn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SignUpOrLogIn.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToSignUp(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML TextField firstn;
    @FXML TextField secondn;
    @FXML TextField un;
    @FXML TextField email;
    @FXML TextField psw;
    public void SignUp(ActionEvent event) throws IOException {
        if(firstn.getText()==null || firstn.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("FirstName required");
            alert.showAndWait();
        }
        else if(secondn.getText()==null || secondn.getText().length()==0)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Second Name required");
            alert.showAndWait();
        }
        else if(un.getText()==null || un.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Username Required");
            alert.showAndWait();
        }
        else if(psw.getText()==null || psw.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("password required");
            alert.showAndWait();
        }
        else{
            bankholder = BankInstance.getInstance();
            bank = bankholder.getBank();
            user = new UserAccount();
            user.setFirstName(firstn.getText());
            user.setLastName(secondn.getText());
            user.setUserName(un.getText());
            user.setPassword(psw.getText());
            if(bank.getAccount(un.getText())!=null){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("Username Already exists");
                alert.showAndWait();
            }
            bank.addAccount(user);
            bank.serializeDataOut();

            bankholder.setBank(bank);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Success");
            alert.setHeaderText("Sign up Done!");
            alert.showAndWait();

            root = FXMLLoader.load(getClass().getResource("Log.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void goToLogIn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Log.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML TextField usrnm;
    @FXML TextField pw;
    public void Login(ActionEvent event) throws Exception{
        bankholder=BankInstance.getInstance();
        bank=bankholder.getBank();
        bank.serializeDataIn();
        if(bank.getUserList().containsKey(usrnm.getText())){
            if(bank.getAccount(usrnm.getText()).getPassword().equals(pw.getText())){
                user=bank.getAccount(usrnm.getText());
                holder = UserInstance.getInstance();
                holder.setUser(user);
                root = FXMLLoader.load(getClass().getResource("AccountDashboard.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Password");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Username");
            alert.showAndWait();
        }
    }
    public void goToDashboard(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("AccountDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToBalance(ActionEvent event) throws IOException {
        holder = UserInstance.getInstance();
        user =holder.getUser();
        root = FXMLLoader.load(getClass().getResource("Balance.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    public void goToBankStatement(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("BankStatement.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goToTransactions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Transactions.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML TextField id;
    @FXML TextField am;
    @FXML TextField bname;
    @FXML TextField bamount;
    public void Transfer(ActionEvent event) throws IOException {
        bankholder= BankInstance.getInstance();
        bank=bankholder.getBank();
        holder = UserInstance.getInstance();
        user=holder.getUser();
        System.out.println(user.getUserName());
        if(id.getText()==null ||id.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Must Enter Account ID");
            alert.showAndWait();
        }else if(am.getText()==null || am.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Must enter Amount");
            alert.showAndWait();
        }
        else{
            if(bank.getAccount(id.getText())!=null){
                user.transferMoney(bank,id.getText(),Double.parseDouble(am.getText()));
                bank.updateAccount(user);
                bank.updateAccount(bank.getAccount(id.getText()));
                bank.serializeDataOut();
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Success");
                alert.setHeaderText("Transfer Has been Done");
                alert.showAndWait();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Account ID");
                alert.showAndWait();
            }

        }

    }
    public void payBills(ActionEvent event) throws IOException {
        bankholder= BankInstance.getInstance();
        bank=bankholder.getBank();
        holder = UserInstance.getInstance();
        user=holder.getUser();
        System.out.println(user.getUserName());
        if(bname.getText()==null ||bname.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Must Enter Bill Name");
            alert.showAndWait();
        }else if(bamount.getText()==null || bamount.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Must enter Amount");
            alert.showAndWait();
        }
        else{
            if(user.checkBalance()>=Double.parseDouble(bamount.getText())){
                user.payBill(bname.getText(),Double.parseDouble(bamount.getText()));
                bank.updateAccount(user);
                bank.serializeDataOut();
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Success");
                alert.setHeaderText("Bill has been paid for:"+bamount.getText()+"EGP");
                alert.showAndWait();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("Insufficient Balance");
                alert.showAndWait();
            }

        }
    }
    public void goToDOW(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("DepositOrWithdraw.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goToFirst(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("First.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goToStore(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Store.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML TextField mo;
    @FXML TextField mi;
    public void DepositWithdraw(ActionEvent event) throws IOException {
        bankholder = BankInstance.getInstance();
        bank = bankholder.getBank();
        holder = UserInstance.getInstance();
        user=holder.getUser();
        if(mo.getText().length()!=0 && mi.getText().length()!=0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("One operation at a time");
            alert.showAndWait();
        }else if(mo.getText()==null ||mo.getText().length()==0){
            if(mi.getText()==null || mi.getText().length()==0){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("Operation required");
                alert.showAndWait();
            }
            user.withdraw(Double.parseDouble(mi.getText()));
            System.out.print(user.checkBalance());
            bank.updateAccount(user);
            bank.serializeDataOut();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Success");
            alert.setHeaderText("Withdraw done for Amount: "+ mo.getText()+"EGP");
            alert.showAndWait();

        }
        else {
            System.out.println(user.getUserName());
            user.deposit(Double.parseDouble(mo.getText()));
            bank.updateAccount(user);
            bank.serializeDataOut();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Deposit done for Amount: "+ mi.getText()+"EGP");
            alert.showAndWait();


        }
    }
}

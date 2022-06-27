package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import system.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ModifyPwController {

    @FXML
    private Text modAlert;

    @FXML
    private Button modModButton;

    @FXML
    private TextField modPasswardField;

    @FXML
    private TextField modPasswardField2;

    @FXML
    private TextField modPasswordField1;

    @FXML
    void modModify(ActionEvent event) throws IOException {          //修改密码功能
        File file=new File("info.txt");
        Scanner input = new Scanner(file);
        String user=input.next();
        String passward = input.next();
        System.out.println(passward);
        System.out.println(user);
        String OrigingPassward=modPasswardField.getText();
        String passward1=modPasswordField1.getText();
        String passward2 =modPasswardField2.getText();
        if (passward.equals(OrigingPassward))           //判断输入的密码是否与原密码一致
            if(passward1.equals(passward2)) {           //判断两次密码是否一致
                FileWriter fw = new FileWriter(file);
                fw.write(user+" ");
                fw.write(passward1);
                fw.close();
                Stage stage = (Stage) modPasswardField.getScene().getWindow();
                stage.close();
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("教职工管理系统");
                stage.setScene(scene);
                stage.show();
            }
            else modAlert.setText("两次密码不一致");
        else
            modAlert.setText("原密码错误");
    }

}

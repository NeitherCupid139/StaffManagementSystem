package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import system.Main;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class LoginController {

    @FXML
    private Text lgAlert;

    @FXML
    private CheckBox lgCheckbox;

    @FXML
    private Button lgFebkButton;

    @FXML
    private Button lgLgButton;

    @FXML
    private Button lgModButton;

    @FXML
    private PasswordField lgPasswardField;

    @FXML
    private Button lgRegButton;

    @FXML
    private TextField lgUserField;

    @FXML
    void lgFeedback(ActionEvent event) throws URISyntaxException, IOException {     //反馈功能
        Desktop.getDesktop().browse(new URI("https://docs.qq.com/form/page/DSVNTS1J5YUNnVGZV#/fill"));      //点击按钮打开超链接
    }

    @FXML
    void lgModify(ActionEvent event) throws IOException {       //修改密码功能
        Stage preStage = (Stage)lgUserField.getScene().getWindow();
        preStage.close();
        Stage stage= new Stage();
        FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("modifyPw.fxml"));         //打开修改密码的FXML
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("教职工管理系统");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void lgRegsiter(ActionEvent event) throws IOException {         //注册功能
        Stage preStage = (Stage)lgUserField.getScene().getWindow();
        preStage.close();
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("register.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("教职工管理系统");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void lgLogin(ActionEvent event) throws IOException {        //登录功能
        String username=lgUserField.getText();
        String password =lgPasswardField.getText();
        File file=new File("account.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        Scanner input = new Scanner(file);          //从文件中读取账号信息
        String userDef=input.next();
        String passwordDef = input.next();
        if(lgCheckbox.isSelected()) {           //检查CheckBox是否勾选
            if (username.equals(userDef) && password.equals(passwordDef)) {         //如果账号和密码均符合，则跳转到菜单界面
                lgAlert.setText("");
                Stage preStage = (Stage)lgLgButton.getScene().getWindow();
                preStage.close();
                Stage stage= new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("教职工管理系统");
                stage.setScene(scene);
                stage.show();
            } else {
                lgAlert.setText("账号或密码错误");
            }
        }
        else lgAlert.setText("请先同意协议");
    }

}

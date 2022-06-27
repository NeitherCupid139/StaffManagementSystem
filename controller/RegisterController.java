package controller;
import system.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterController {

    @FXML
    private Text regAlert;

    @FXML
    private TextField regPasswordField1;

    @FXML
    private TextField regPasswordField2;

    @FXML
    private Button regRegButton;

    @FXML
    private TextField regUserField;

    @FXML
    void regRegsiter(ActionEvent event) throws IOException {            //注册功能
        String userDefault=new String(regUserField.getText());
        if (regPasswordField1.getText().equals(regPasswordField2.getText())) {          //判断输入的两次密码是否一致
            String passwordDefault=new String(regPasswordField1.getText());
            System.out.println(userDefault);
            System.out.println(passwordDefault);
            File file = new File("account.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            fw.write(userDefault+" ");
            fw.write(passwordDefault);          //将账号和密码写入文件中
            fw.close();
            Stage stage = (Stage) regUserField.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("教职工管理系统");
            stage.setScene(scene);
            stage.show();
        }
        else regAlert.setText("两次密码不一致");
    }
}

package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import system.Main;

import java.io.IOException;

public class menu {

    @FXML
    private Button displayButton;

    @FXML
    private Button home;

    @FXML
    private Button inputButton;

    @FXML
    private Button modifyButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button searchButton;

    @FXML
    void display(ActionEvent event) throws IOException {            //显示信息页面
        Stage preStage = (Stage)home.getScene().getWindow();
        preStage.close();
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("display.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("教职工管理系统");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void search(ActionEvent event) throws IOException {             //搜索页面
        Stage preStage = (Stage)home.getScene().getWindow();
        preStage.close();
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("search.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("教职工管理系统");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void modify(ActionEvent event) throws IOException {                 //修改页面
        Stage preStage = (Stage)home.getScene().getWindow();
        preStage.close();
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("modifyInfo.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("教职工管理系统");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void input(ActionEvent event) throws IOException {                  //输入信息页面
        Stage preStage = (Stage)home.getScene().getWindow();
        preStage.close();
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("input.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("教职工管理系统");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void remove(ActionEvent event) throws IOException {             //删除信息页面
        Stage preStage = (Stage)home.getScene().getWindow();
        preStage.close();
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("remove.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("教职工管理系统");
        stage.setScene(scene);
        stage.show();
    }

}

package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import system.Main;
import system.employee;

import java.io.IOException;

import static controller.FileIO.readFile;
import static controller.InputController.employeeList;

public class SearchController {

    @FXML
    private Text alert;

    @FXML
    private TableColumn<employee,String> dateCol;
    @FXML
    private TableColumn<employee,String> dateCol1;

    @FXML
    private TableColumn<employee,String> dateCol2;

    @FXML
    private TableColumn<employee,String> dateCol3;
    @FXML
    private TableColumn<employee,String> genderCol;

    @FXML
    private Button home;

    @FXML
    private TableColumn<employee,String> idCol;

    @FXML
    private TableColumn<employee,String> jobCol;

    @FXML
    private TableColumn<employee,String> nameCol;

    @FXML
    private TableColumn<employee,String> numCol;

    @FXML
    private TableColumn<employee,String> partCol;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<employee> tableView;

    @FXML
    private TableColumn<employee,String> telCol;

    ObservableList<employee> data = FXCollections.observableArrayList();
    @FXML
    void search(ActionEvent event) throws IOException {             //搜索功能
        employeeList.clear();                           //清空employeeList的元素
        readFile();                                         //从文件中读取信息。
        tableView.setItems(null);
        data.clear();
        boolean isFind = false;
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateCol1.setCellValueFactory(new PropertyValueFactory<>("year"));
        dateCol2.setCellValueFactory(new PropertyValueFactory<>("month"));
        dateCol3.setCellValueFactory(new PropertyValueFactory<>("day"));
        numCol.setCellValueFactory(new PropertyValueFactory<>("num"));
        telCol.setCellValueFactory(new PropertyValueFactory<>("tel"));
        jobCol.setCellValueFactory(new PropertyValueFactory<>("job"));
        partCol.setCellValueFactory(new PropertyValueFactory<>("part"));
        String searched = searchField.getText();

        for (int i = 0; i < employeeList.size();i++) {
            if(searched.equals(employeeList.get(i).getNum())||searched.equals(employeeList.get(i).getPart())||searched.equals(employeeList.get(i).getName())){      //遍历employeeList,查找是否有匹配的数据
                alert.setText("查询到该学生");
                data.add(new employee(employeeList.get(i).getName(),employeeList.get(i).getGender(),employeeList.get(i).getId(),employeeList.get(i).getYear(),employeeList.get(i).getMonth(),employeeList.get(i).getDay(),employeeList.get(i).getNum(),employeeList.get(i).getTel(),employeeList.get(i).getJob(),employeeList.get(i).getPart()));
//添加一个可观测的列表显示
                isFind =true;         //搜索信息如果找到，isFind为true
            }
        }
        tableView.setItems(data);
        if(!isFind){
            alert.setText("抱歉，没有找到");
        }
    }
    @FXML
    void menu(ActionEvent event) throws IOException {               //返回主菜单
        Stage preStage = (Stage)searchButton.getScene().getWindow();
        preStage.close();
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("教职工管理系统");
        stage.setScene(scene);
        stage.show();
    }
}

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

import java.io.IOException;
import java.util.ArrayList;

import static controller.FileIO.*;
import static controller.InputController.employeeList;
import static controller.InputController.employeeList;

public class RemoveController {

    @FXML
    private Text alert;
    @FXML
    private TextField dateField;

    @FXML
    private TextField dateField1;

    @FXML
    private TextField dateField2;

    @FXML
    private TextField genderField;

    @FXML
    private Button homeButton;

    @FXML
    private TextField idField;

    @FXML
    private TextField jobField;

    @FXML
    private TextField nameField;

    @FXML
    private Button nextButton;

    @FXML
    private TextField numField;

    @FXML
    private TextField partField;

    @FXML
    private Button removeButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchField;

    @FXML
    private TextField telField;


    ArrayList<Integer> sameInfo = new ArrayList<Integer>();
    int tag=1;
    @FXML
    void next(ActionEvent event) {                  //显示下一个职工的信息
        int j=sameInfo.get(tag);                    //从sameinfo[1]开始遍历
        nameField.clear();                           //清空文本框
        genderField.clear();
        idField.clear();
        dateField.clear();
        dateField1.clear();dateField2.clear();
        numField.clear();
        telField.clear();
        jobField.clear();
        partField.clear();
        nameField.setText(employeeList.get(j).getName());
        genderField.setText(employeeList.get(j).getGender());
        idField.setText(String.valueOf(employeeList.get(j).getId()));
        dateField.setText(String.valueOf(employeeList.get(j).getYear()));
        dateField1.setText(String.valueOf(employeeList.get(j).getMonth()));
        dateField2.setText(String.valueOf(employeeList.get(j).getDay()));
        numField.setText(String.valueOf(employeeList.get(j).getNum()));
        telField.setText(String.valueOf(employeeList.get(j).getTel()));
        jobField.setText(employeeList.get(j).getJob());
        partField.setText(employeeList.get(j).getPart());
        tag++;
    }

    @FXML
    void remove(ActionEvent event) throws IOException {     //删除Employee.get(i)的元素
        String searched = searchField.getText();
        for (int i = 0; i < employeeList.size();i++) {
            if(searched.equals(employeeList.get(i).getNum())||searched.equals(employeeList.get(i).getName())||searched.equals(employeeList.get(i).getId())){
                employeeList.remove(i);
                alert.setText("删除成功!!!");
            }
        }
        saveFile_clear();
    }

    @FXML
    void search(ActionEvent event) throws IOException {         //搜索功能
        employeeList.clear();
        readFile();
        sameInfo.clear();
        alert.setText("");
        boolean isFind = false;
        String searched = searchField.getText();
        for (int i = 0; i < employeeList.size();i++) {
            if(searched.equals(employeeList.get(i).getNum())||searched.equals(employeeList.get(i).getName())||searched.equals(employeeList.get(i).getId())){             //遍历employeeList,查找是否有匹配的数据
                isFind =true;             //搜索信息如果找到，isFind为true
                sameInfo.add(i);
            }
        }
        if(!isFind){
            alert.setText("没有找到相关信息");
        }
        int first=sameInfo.get(0);
        nameField.setText(employeeList.get(first).getName());
        genderField.setText(employeeList.get(first).getGender());
        idField.setText(String.valueOf(employeeList.get(first).getId()));
        dateField.setText(String.valueOf(employeeList.get(first).getYear()));
        dateField1.setText(String.valueOf(employeeList.get(first).getMonth()));
        dateField2.setText(String.valueOf(employeeList.get(first).getDay()));
        numField.setText(String.valueOf(employeeList.get(first).getNum()));
        telField.setText(String.valueOf(employeeList.get(first).getTel()));
        jobField.setText(employeeList.get(first).getJob());
        partField.setText(employeeList.get(first).getPart());

    }
    @FXML
    void menu(ActionEvent event) throws IOException {       //返回主菜单
        Stage preStage = (Stage)removeButton.getScene().getWindow();
        preStage.close();
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("教职工管理系统");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void clear(ActionEvent event) throws IOException {      //清空employeelist
        employeeList.clear();
        saveFile_clear();
    }

}



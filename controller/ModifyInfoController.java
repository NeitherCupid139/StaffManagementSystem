package controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import system.Main;
import system.employee;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static controller.FileIO.readFile;
import static controller.FileIO.saveFile_clear;
import static controller.InputController.employeeList;

public class ModifyInfoController {
    @FXML
    private Text alert;

    @FXML
    private TextField dateField;

    @FXML
    private TextField dateField1;

    @FXML
    private TextField dateField2;

    @FXML
    private Button displayInfo;

    @FXML
    private TextField genderField;

    @FXML
    private TextField idField;

    @FXML
    private Button inputPage;

    @FXML
    private TextField jobField;

    @FXML
    private Button modifyButton;

    @FXML
    private Button modifyInfo;

    @FXML
    private TextField nameField;

    @FXML
    private Button nextButton;

    @FXML
    private TextField numField;

    @FXML
    private TextField partField;

    @FXML
    private Button removeInfo;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchField;

    @FXML
    private Button searchInfo;

    @FXML
    private Button homeButton;
    @FXML
    private TextField telField;
    @FXML
    void modifyPage(ActionEvent event) {

    }
    ArrayList<Integer> sameInfo = new ArrayList<Integer>();     //存储相同姓名不同信息的list
    int tag=1;
    @FXML
    void next(ActionEvent event) {      //显示下一个职工的信息
        int j=sameInfo.get(tag);        //从sameinfo[1]开始遍历
        nameField.clear();              //清空文本框
        genderField.clear();            //清空文本框
        idField.clear();                //清空文本框
        dateField.clear();              //清空文本框
        dateField1.clear();             //清空文本框
        dateField2.clear();             //清空文本框
        numField.clear();               //清空文本框
        telField.clear();               //清空文本框
        jobField.clear();               //清空文本框
        partField.clear();              //清空文本框
        nameField.setText(employeeList.get(j).getName());                       //显示姓名
        genderField.setText(employeeList.get(j).getGender());                   //显示性别
        idField.setText(String.valueOf(employeeList.get(j).getId()));           //显示身份证号码
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
    void search(ActionEvent event) throws IOException {             //搜索功能
        employeeList.clear();                                       //清空employeeList的元素
        readFile();                                                 //从文件中读取信息。
        sameInfo.clear();                                           //清空sameInfo的元素
        alert.setText("");                                          //清空文本框
        boolean isFind = false;
        String searched = searchField.getText();                    //搜索信息如果找到，就把它添加进sameInfo当中，并且isFind为true
        for (int i = 0; i < employeeList.size();i++) {
            if(searched.equals(employeeList.get(i).getNum())||searched.equals(employeeList.get(i).getName())||searched.equals(employeeList.get(i).getId())){
                isFind =true;
                sameInfo.add(i);
            }
        }
        if(!isFind){                                                //没有搜索到信息
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
    void modify(ActionEvent event) throws IOException {                 //修改功能
        boolean isFind = false;
        String searched = searchField.getText();
        for (int i = 0; i <employeeList.size(); i++) {                  //如果找到，就将employeeList中元素的信息设置为新的信息
            if(searched.equals(employeeList.get(i).getNum())||searched.equals(employeeList.get(i).getName())||searched.equals(employeeList.get(i).getId())){
                employeeList.get(i).setName(nameField.getText());
                employeeList.get(i).setGender(genderField.getText());
                employeeList.get(i).setId(idField.getText());
                employeeList.get(i).setYear(Integer.parseInt(dateField.getText()));
                employeeList.get(i).setMonth(Integer.parseInt(dateField1.getText()));
                employeeList.get(i).setDay(Integer.parseInt(dateField2.getText()));
                employeeList.get(i).setNum(numField.getText());
                employeeList.get(i).setTel(telField.getText());
                employeeList.get(i).setJob(jobField.getText());
                employeeList.get(i).setPart(partField.getText());
            }
        }
        saveFile_clear();                       //保存进文件当中
    }
    @FXML
    void menu(ActionEvent event) throws IOException {           //返回到主菜单
        Stage preStage = (Stage)modifyButton.getScene().getWindow();
        preStage.close();                       //关闭当前页面
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));            //加载主菜单页面的FXML
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("教职工管理系统");
        stage.setScene(scene);
        stage.show();
    }
}



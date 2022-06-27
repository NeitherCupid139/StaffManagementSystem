package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import system.Main;
import system.employee;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static controller.FileIO.*;

public class InputController {

    @FXML
    private Text alert;
    @FXML
    private DatePicker dateField;

    @FXML
    private TextField genderField;

    @FXML
    private TextField idField;

    @FXML
    private Button inputButton;

    @FXML
    private TextField jobField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField numField;

    @FXML
    private TextField partField;

    @FXML
    private TextField telField;
    @FXML
    private Button home;
    public static ArrayList<employee> employeeList = new ArrayList<employee>();//创建职工的ArrayList

    @FXML
    void input(ActionEvent event) throws IOException {          //输入功能
        employeeList.clear();                                   //清空employeeList的元素
        readFile();                                             //从文件中读取信息
        alert.setText("");
        String name = nameField.getText();
        String gender = genderField.getText();
        String id = idField.getText();
        LocalDate date = dateField.getValue();
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        String num = numField.getText();
        String tel = telField.getText();
        String job = jobField.getText();
        String part = partField.getText();
        if (id.matches("\\d{17}[\\d|x]|\\d{15}"))               //判断身份证是否正确
            if (tel.matches("0?(13|14|15|17|18)[0-9]{9}")) {                //判断电话号码是否正确
                if (job.equals("助教")||job.equals("讲师")||job.equals("副教授")||job.equals("教授")) {          //判断职称是否正确
                    if (gender.equals("男")||gender.equals("女")) {         //判断性别是否正确
                        employeeList.add(new employee(name, gender, id, year, month, day, num, tel, job, part));
                    }
                    else{
                        alert.setText("性别错误");
                    }
                }
                else{
                    alert.setText("请输入正确的职位");
                }
            }
        else {
            alert.setText("请输入正确格式的电话号码");
            }
        else alert.setText("请输入正确格式的身份证号码");
        saveFile_clear();
        nameField.clear();
        genderField.clear();
        idField.clear();
        dateField.setValue(null);
        numField.clear();
        telField.clear();
        jobField.clear();
        partField.clear();
        employeeList.clear();
    }
    @FXML
    void menu(ActionEvent event) throws IOException {           //返回到主菜单
        Stage preStage = (Stage)home.getScene().getWindow();
        preStage.close();            //关闭当前页面
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));            //加载主菜单页面的FXML
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("教职工管理系统");
        stage.setScene(scene);
        stage.show();
    }
}


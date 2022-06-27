package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import system.Main;
import system.employee;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import static controller.FileIO.readFile;
import static controller.FileIO.saveFile_clear;
import static controller.InputController.employeeList;

public class DisplayController {
    @FXML
    private Button sortButton;
    @FXML
    private Button sortButton1;
    @FXML
    private Button displayButton;
    @FXML
    private Button home;
    @FXML
    private Button clearButton;
    @FXML
    private TableView<employee> tableView;          //一个数据为employee的tableView
    @FXML
    private TableColumn<employee,String> telCol;
    @FXML
    private TableColumn<employee,String> nameCol;
    @FXML
    private TableColumn<employee,String> jobCol;
    @FXML
    private TableColumn<employee,String> genderCol;

    @FXML
    private TableColumn<employee,String> idCol;
    @FXML
    private TableColumn<employee,String> dateCol;
    @FXML
    private TableColumn<employee,String> dateCol1;

    @FXML
    private TableColumn<employee,String> dateCol2;

    @FXML
    private TableColumn<employee,String> dateCol3;
    @FXML
    private TableColumn<employee,String> numCol;

    @FXML
    private TableColumn<employee,String> partCol;
    ObservableList<employee> data = FXCollections.observableArrayList();            //数据为employee的ObservableList的观察者列表
    @FXML
    private Text assistant;

    @FXML
    private Text assprofessor;
    @FXML
    private Text lecturer;
    @FXML
    private Text professor;
    @FXML
    void display(ActionEvent event) throws IOException {                //显示信息
        data.clear();                                                   //清空观察者列表中的元素
        tableView.setItems(null);                                       //清空tableView中的元素
        employeeList.clear();                                           //清空 employeeList中的元素
        readFile();                                                     //从文件中读取
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
        int assistantNum = 0,lecturerNum = 0,assprofessorNum = 0,professorNum = 0;
        for (int i = 0; i<employeeList.size(); i++) {               //统计各职称的人数
            switch (employeeList.get(i).getJob()) {
                case "助教": assistantNum++;break;
                case "讲师": lecturerNum++;break;
                case "副教授": assprofessorNum++;break;
                case "教授": professorNum++;break;
            }
        }
        assistant.setText(String.valueOf(assistantNum));
        lecturer.setText(String.valueOf(lecturerNum));
        assprofessor.setText(String.valueOf(assprofessorNum));
        professor.setText(String.valueOf(professorNum));

        for (int i = 0; i < employeeList.size(); i++) {
            data.add(new employee(employeeList.get(i).getName(),employeeList.get(i).getGender(),employeeList.get(i).getId(),employeeList.get(i).getYear(),employeeList.get(i).getMonth(),employeeList.get(i).getDay(),employeeList.get(i).getNum(),employeeList.get(i).getTel(),employeeList.get(i).getJob(),employeeList.get(i).getPart()));

        }
        tableView.setItems(data);
        saveFile_clear();
    }


    public static int getOrder(String job){             //给对应的职称赋予相应的值，以方便进行职称排序
        if (job.equals("助教")) {
            return 1;
        }
        else if (job.equals("讲师")) {
            return 2;
        }
        else if (job.equals("副教授")) {
            return 3;
        }
        else if (job.equals("教授")) {
            return 4;
        }
        else return 0;
    }
    @FXML
    void sort(ActionEvent event) throws IOException {       //升序排序

        for (int i = 0; i <employeeList.size()-1; i++){
            for (int j = 0; j < employeeList.size()-1-i; j++){
                if (getOrder(employeeList.get(j).getJob())>getOrder(employeeList.get(j+1).getJob())) {
                    Collections.swap(employeeList, j, j+1);
                }
            }
        }
        for (int i = 0; i < employeeList.size(); i++) {
           saveFile_clear();

        }
    }

    @FXML
    void sort1(ActionEvent event) throws IOException {              //降序排序
        for (int i = 0; i <employeeList.size()-1; i++){
            for (int j = 0; j < employeeList.size()-1-i; j++){
                if (getOrder(employeeList.get(j).getJob())<getOrder(employeeList.get(j+1).getJob())) {
                    Collections.swap(employeeList, j, j+1);
                }
            }
        }
        for (int i = 0; i < employeeList.size(); i++) {
            saveFile_clear();

        }
    }
    @FXML
    void menu(ActionEvent event) throws IOException {                       //返回到主菜单
        Stage preStage = (Stage)home.getScene().getWindow();
        preStage.close();                //关闭当前页面
        Stage stage= new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));         //加载主菜单页面的FXML
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("教职工管理系统");
        stage.setScene(scene);
        stage.show();
    }

}

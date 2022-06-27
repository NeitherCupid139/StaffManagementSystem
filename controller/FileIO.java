package controller;

import system.employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static controller.InputController.employeeList;

public class FileIO {
    public static void readFile() throws IOException {              //读取文件信息
        File file=new File("info.txt");
        if (!file.exists()) {                   //如果文件不存在，则创建文件
            file.createNewFile();
        }
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            employeeList.add(new employee(input.next(),input.next(),input.next(),input.nextInt(),input.nextInt(),input.nextInt(),input.next(),input.next(),input.next(),input.next()));
        }
        input.close();
    }
    public static void saveFile_add() throws IOException {          //将数据保存进文件中，以追加的形式
        File file = new File("info.txt");
        if (!file.exists()) {               //如果文件不存在，则创建文件
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file, true);
        for (int i = 0; i < employeeList.size(); i++) {
            fw.write(employeeList.get(i).getName() + " " + employeeList.get(i).getGender() + " " + employeeList.get(i).getId() + " " + employeeList.get(i).getYear() + " " + employeeList.get(i).getMonth() + " " + employeeList.get(i).getDay() + " " + employeeList.get(i).getNum() + " " + employeeList.get(i).getTel() + " " + employeeList.get(i).getJob() + " " + employeeList.get(i).getPart() + " ");
        }
        fw.close();
    }
    public static void saveFile_clear() throws IOException {                //将数据保存进文件中，以覆盖的形式
        File file = new File("info.txt");
        if (!file.exists()) {           //如果文件不存在，则创建文件
            file.createNewFile();
        }
        FileWriter fw1 = new FileWriter(file);
        for (int i = 0; i < employeeList.size(); i++) {
            fw1.write(employeeList.get(i).getName() + " " + employeeList.get(i).getGender() + " " + employeeList.get(i).getId() + " " + employeeList.get(i).getYear() + " " + employeeList.get(i).getMonth() + " " + employeeList.get(i).getDay() + " " + employeeList.get(i).getNum() + " " + employeeList.get(i).getTel() + " " + employeeList.get(i).getJob() + " " + employeeList.get(i).getPart() + " ");
        }
        fw1.close();
    }

}

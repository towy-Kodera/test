/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSV;

/**
 *
 * @author ogawa
 */
import book.QandA;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

//ArrayListでHashMapを制御
public class CSV {
    public static ArrayList<QandA> data;
    private static File dataFile = null;
    private static PrintWriter writer = null;
    private static File dataDir;
    
    public CSV(){
        this.data = new ArrayList<>();
        dataDir = new File("." + File.separator + "data");
        dataDir.mkdirs();
    }
    
    //問題と答えを受け取って、データベースにセット
    public static void Input(String question, String answer){
        float zero = 0;
        QandA QArate = new QandA(question, answer, zero);
        data.add(QArate);
    }
    
    //問題番号によって、問題を受け取る
    public static QandA Output(int number){
        return data.get(number);
    }
    
    //問題番号によって、問題を削除
    public static void Remove(int number){
        data.remove(number);
    }
    
    //問題番号によって、正答率を入力
    public static void CorrectRate(int number, float rate){
        data.get(number).SetRate(rate);
    }
    
    public static void setOutputFile(File datafile) throws FileNotFoundException{
        //dataFile = datafile;
        try {
            writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(datafile),"UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeFile(){
        if(dataFile != null){
            writer.flush();
            writer.close();
            dataFile = null;
        }
    }
    
    public static void outputAllData(File datafile) throws FileNotFoundException{
        try { 
            PrintWriter output = new PrintWriter(new OutputStreamWriter(new FileOutputStream(datafile),"UTF-8"));
            
            for(int i = 0;i < data.size();i++){
                ArrayList<String> line = data.get(0).ToString();
                for(String elem:line){
                    output.print(elem);
                    System.out.println(elem);
                    output.print(",");
                }
                output.println();
            }
            output.close();
            closeFile();
            writer = null;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //CSVに保存する
    public static void MakeCSV(){
        String filename = "data.csv";
        dataFile = new File(dataDir.getPath() + File.separator + filename);
        try{
            CSV.setOutputFile(dataFile);
            CSV.outputAllData(dataFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

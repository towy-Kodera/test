/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package book;

import CSV.CSV;

/**
 *
 * @author ogawa
 */
public class Book {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String q = "what";
        String a = "I don't know";
        CSV b = new CSV();
        
        b.Input(q,a);
        b.MakeCSV();
        //1
    }
    
}

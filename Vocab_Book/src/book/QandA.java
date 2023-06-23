/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book;

/**
 *
 * @author ogawa
 */
import java.util.ArrayList;

public class QandA {
    public String question, answer;
    public Float correctRate;
    
    public QandA(String q, String a, float rate){
        question = q;
        answer = a;
        correctRate = rate;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public float getCorrectRate() {
        return correctRate;
    }
    
    public void SetRate(float rate){
        correctRate = rate;
    }
    
    public ArrayList<String> ToString(){
        ArrayList<String> line = new ArrayList<>();
        line.add(question);
        line.add(answer);
        line.add(correctRate.toString());
        return line;
    }
}

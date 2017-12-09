/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverppluschat.test;

/**
 *
 * @author stephen
 */
public class testsplit {
    public static void main(String[] args) {
        String mess = "thanh|ahuhu|chat";
        String[] data = mess.split("\\|");
        for (int i = 0; i < data.length; i++){
            System.out.println(data[i]);
        }
    }
    
}

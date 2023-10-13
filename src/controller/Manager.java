/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.Library;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import view.Menu;

public class Manager extends Menu<String>{
    static String[] mc = {"Add new word.","Delete word.","Translate.","Exit."};
    Library l;
    HashMap<String, String> hm = new HashMap<>();
    
    public Manager(){
    super("========= Program =========", mc);
    l = new Library();
    }
    
    public void execute(int n){
        switch(n){
            case 1: 
                addNewWord(hm);
                break;
            case 2:
                deleteWord(hm);
                break;
            case 3:
                translate(hm);
                break;
            case 4:
                System.out.println("Exit the program successfully!");
                System.exit(0);
        }
    }
    
    public  void addNewWord(HashMap<String, String> hm) {
        System.out.print("Enter Enlish: ");
        String english = l.checkInputString();
        if (!checkKeywordExist(hm, english)) {
            if (!l.checkInputYN()) {
                return;
            }
        }
        System.out.print("Enter Vietnamese: ");
        String vietnam = l.checkInputString();
        //check key word english exist or not
        hm.put(english, vietnam);
        System.err.println("Add successful.");
    }

    
    public  void deleteWord(HashMap<String, String> hm) {
        System.out.print("Enter english: ");
        String english = l.checkInputString();
        hm.remove(english);
        System.err.println("Delete successful.");
    }
    
    
    public void translate(HashMap<String, String> hm) {
        System.out.print("Enter english: ");
        String english = l.checkInputString();
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        for (Map.Entry entry : entries) {
            if (entry.getKey().equals(english)) {
                System.out.println("Vietnamese: " + entry.getValue());
                return;
            }
        }
        System.err.println("Not found in data");
    }

   
    public boolean checkKeywordExist(HashMap<String, String> hm, String english) {
        Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (english.equalsIgnoreCase(mentry.getKey().toString())) {
                return false;
            }
        }
        return true;
    }
}

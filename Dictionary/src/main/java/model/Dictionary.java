/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author macbookpro
 */
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> dictionary;
    private String dataFilePath;

    public Dictionary(String dataFilePath) {
        this.dataFilePath = dataFilePath;
        dictionary = new HashMap<>();
        loadData();
    }

    public boolean addWord(String eng, String vi) {
        if (dictionary.containsKey(eng)) {
            System.out.println("The word is already in the dictionary.");
            return false;
        }

        dictionary.put(eng, vi);
        updateDatabase();
        return true;
    }

    public boolean removeWord(String eng) {
        if (dictionary.containsKey(eng)) {
            dictionary.remove(eng);
            updateDatabase();
            return true;
        } else {
            System.out.println("The word does not exist.");
            return false;
        }
    }

    public String translate(String eng) {
        if (dictionary.containsKey(eng)) {
            return dictionary.get(eng);
        } else {
            return "Translation not found.";
        }
    }

    private void loadData() {
        try {
            File file = new File(dataFilePath);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                dictionary = (HashMap<String, String>) ois.readObject();
                ois.close();
                fis.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }
    }

    private void updateDatabase() {
        try {
            FileOutputStream fos = new FileOutputStream(dataFilePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dictionary);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error updating data to file: " + e.getMessage());
        }
    }
}
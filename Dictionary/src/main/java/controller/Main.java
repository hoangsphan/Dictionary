/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import model.Dictionary;
import view.DictionaryView;

/**
 *
 * @author macbookpro
 */
public class Main {
    public static void main(String[] args) {
        String dataFilePath = "dictionary_data.dat";
        Dictionary model = new Dictionary(dataFilePath);
        DictionaryController controller = new DictionaryController(model, null);
        DictionaryView view = new DictionaryView(controller);
        controller.setView(view);
        view.handleUserInput();
    }
}
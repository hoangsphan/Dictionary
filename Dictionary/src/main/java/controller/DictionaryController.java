/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Dictionary;
import view.DictionaryView;

/**
 *
 * @author macbookpro
 */
public class DictionaryController {
    private Dictionary model;
    private DictionaryView view;

    public DictionaryController(Dictionary model, DictionaryView view) {
        this.model = model;
        this.view = view;
    }

  public void setView(DictionaryView view) {
        this.view = view;
    }
    public boolean addWord(String eng, String vi) {
        return model.addWord(eng, vi);
    }

    public boolean removeWord(String eng) {
        return model.removeWord(eng);
    }

    public String translate(String eng) {
        return model.translate(eng);
    }

    public void startProgram() {
        view.handleUserInput();
    }
}

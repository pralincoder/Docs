package com.mgassociates.bluefin.docs.Models;

import java.util.ArrayList;

/**
 * Created by Rasil10 on 2017-12-13.
 */

public class RequiredDocsInfo {
    int id;
    ArrayList<String> docs;
    int money;

    public RequiredDocsInfo() {
    }

    public RequiredDocsInfo(int id, ArrayList<String> docs, int money) {
        this.id = id;
        this.docs = docs;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getDocs() {
        return docs;
    }

    public void setDocs(ArrayList<String> docs) {
        this.docs = docs;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}


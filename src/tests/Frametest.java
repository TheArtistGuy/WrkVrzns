package tests;

import adressbook.view.AdressBookFrame;

public class Frametest {
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                AdressBookFrame abf = new AdressBookFrame();
            }
        }).start();

    }

}
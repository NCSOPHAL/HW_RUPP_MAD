package kh.edu.rupp.fe.ruppmad;

import android.content.ContentValues;
import android.content.Context;

import kh.edu.rupp.fe.ruppmad.Database.DBHelper;

/**
 * RUPPMAD
 * Created by leapkh on 4/26/17.
 */

public class AppSingleton {

    private DBHelper dbHelper;

    private static AppSingleton instance;

    private AppSingleton(){

    }

    public static AppSingleton getInstance(){
        if(instance == null){
            instance = new AppSingleton();
        }
        return instance;
    }

}

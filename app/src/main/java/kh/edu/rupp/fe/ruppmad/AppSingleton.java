package kh.edu.rupp.fe.ruppmad;

/**
 * RUPPMAD
 * Created by leapkh on 4/26/17.
 */

public class AppSingleton {

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

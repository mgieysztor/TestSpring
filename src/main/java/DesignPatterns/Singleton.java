package DesignPatterns;

/**
 * Created by RENT on 2017-01-28.
 */
public class Singleton{

    private static Singleton singleton = new Singleton();

    private Singleton(){ //konstruktor prywatny

    }

//    public static Singleton getInstance (){
//        return singleton;
//    }
        //lazy
    public static Singleton getInstance (){
        if (singleton==null){

        }

        return singleton;
    }
}

package com.example.democit;

public class MyDataSingleton {


        private static MyDataSingleton instance;

        String myName;

        private MyDataSingleton(){
            System.out.println("data onstructor");
            myName = "Sune";
        }

        public static MyDataSingleton getInstance(){
            if (instance == null){
                instance = new MyDataSingleton();
            }
            return instance;
        }



}

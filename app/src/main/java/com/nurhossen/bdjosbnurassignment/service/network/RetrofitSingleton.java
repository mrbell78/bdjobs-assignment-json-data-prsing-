package com.nurhossen.bdjosbnurassignment.service.network;

public final class RetrofitSingleton {

    private static volatile  RetrofitSingleton retrofitinstance =null;

    private RetrofitSingleton(){}

    public  static RetrofitSingleton getInstance(){
        if(retrofitinstance==null){
            synchronized(RetrofitSingleton.class){
                if(retrofitinstance==null){
                    retrofitinstance = new RetrofitSingleton();
                }
            }
        }

        return  retrofitinstance;
    }
}

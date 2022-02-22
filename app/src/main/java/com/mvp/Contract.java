package com.mvp;

public interface Contract {

    interface View{
        void onSuccess(String succcess);
        void onError(String error);
    }

    interface Presenter {
        void doLogin(String login, String password);
    }

}

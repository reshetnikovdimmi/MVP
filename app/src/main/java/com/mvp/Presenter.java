package com.mvp;

public class Presenter implements Contract.Presenter{

Contract.View view;

    public Presenter(Contract.View view) {
        this.view = view;
    }

    @Override
    public void doLogin(String login, String password) {

        // login Name
        // password 123

        if (login.equals("Name") && password.equals("123")){
view.onSuccess("УСПЕХ");
        }else {
            view.onError("НЕУДАЧА");
        }

    }
}

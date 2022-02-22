package com.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Contract.View {

    EditText PersonName,Password;
    Button button;

    Contract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this);

        PersonName = findViewById(R.id.PersonName);
        Password = findViewById(R.id.Password);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String personName = PersonName.getText().toString();
                String password = Password.getText().toString();

                if (TextUtils.isEmpty(personName)||TextUtils.isEmpty(password)){
                    onError("НЕУДАЧА");
                }else {
                    presenter.doLogin(personName,password);
                }

            }
        });

    }

    @Override
    public void onSuccess(String success) {
        Toast.makeText(this, success, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
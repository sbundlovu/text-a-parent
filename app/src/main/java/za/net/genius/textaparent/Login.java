package za.net.genius.textaparent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity implements View.OnClickListener {

    Button bSignIn; //it has login button. get view and create variables
    EditText etUsername, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bSignIn = (Button) findViewById(R.id.signIn);

        bSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) { //get what was clicke and perform relevant action
        switch(v.getId()) {
            case R.id.signIn:
                // whats happening here
                //start dashboard activty
                startActivity((new Intent(this,Compose.class)));
                break;
        }
    }
}

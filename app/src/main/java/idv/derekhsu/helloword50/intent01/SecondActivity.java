package idv.derekhsu.helloword50.intent01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import idv.derekhsu.helloword50.R;

public class SecondActivity extends AppCompatActivity {

    EditText accountEdit;
    EditText passwordEdit;
    EditText ageEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        this.processViews();

        Intent intent = getIntent();
        accountEdit.setText(intent.getStringExtra("accountValue"));
        passwordEdit.setText(intent.getStringExtra("passwordValue"));
        ageEdit.setText(Integer.toString(intent.getIntExtra("ageValue", 0)));
    }

    private void processViews() {
        accountEdit = (EditText) findViewById(R.id.account_edit_second);
        passwordEdit = (EditText) findViewById(R.id.password_edit_second);
        ageEdit = (EditText) findViewById(R.id.age_edit_second);
    }
}

package idv.derekhsu.helloword50.intent01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import idv.derekhsu.helloword50.R;

public class Intent01Activity extends AppCompatActivity {

    private EditText accountEdit;
    private EditText passwordEdit;
    private EditText ageEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent01);

        this.processViews();
    }

    public void clickOk(View view) {
        String accountValue = accountEdit.getText().toString();
        String passwordValue = passwordEdit.getText().toString();
        String ageStr = ageEdit.getText().toString();

        int ageValue = 0;

        try {
            ageValue = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Age must be number!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, SecondActivity.class);

        intent.putExtra("accountValue", accountValue);
        intent.putExtra("passwordValue", passwordValue);
        intent.putExtra("ageValue", ageValue);

        startActivity(intent);
    }

    private void processViews() {
        accountEdit = (EditText) findViewById(R.id.account_edit);
        passwordEdit = (EditText) findViewById(R.id.password_edit);
        ageEdit = (EditText) findViewById(R.id.age_edit);
    }
}

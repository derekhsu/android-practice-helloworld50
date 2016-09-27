package idv.derekhsu.helloword50.intent03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import idv.derekhsu.helloword50.R;

public class Intent03Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent03);
    }

    public void buttonClick(View view) {

        Intent intent = new Intent(this, MmsActivity.class);
        startActivity(intent);

    }
}

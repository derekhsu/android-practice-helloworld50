package idv.derekhsu.helloword50;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OnClick01Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onclick01);

        Button button01 = (Button) findViewById(R.id.button01);
        MyListener01 myListener01 = new MyListener01();
        button01.setOnClickListener(myListener01);
    }

    private class MyListener01 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(OnClick01Activity.this, "Button01", Toast.LENGTH_SHORT).show();
        }
    }
}

package idv.derekhsu.helloword50;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout01);

        class MyListener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Toast Message", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void buttonClick(View view) {
        TextView textHello = (TextView) findViewById(R.id.text_hello);
        Date now = new Date();
        textHello.setText(now.toString());
    }

    public void sayHello(View view) {
        int id = view.getId();

        if (id == R.id.button01) {
            Toast.makeText(this, "Hello! Button01", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.button02) {
            Toast.makeText(this, "Hello! Button02", Toast.LENGTH_SHORT).show();
        }
    }

    public void isReady(View view) {
        CheckBox ready = (CheckBox) view;
        String message = ready.isChecked() ? "Yes":"No";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void selectMovie(View view) {
        RadioButton checkedRadio = (RadioButton) view;
        Toast.makeText(this, checkedRadio.getText(), Toast.LENGTH_SHORT).show();
    }
}

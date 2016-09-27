package idv.derekhsu.helloword50;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Listener01Activity extends AppCompatActivity {

    private TextView info;
    private EditText edit;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener01);

        processViews();
        processControllers();
    }

    private void processViews() {
        info = (TextView) findViewById(R.id.infoText);
        edit = (EditText) findViewById(R.id.edit);
        text = (TextView) findViewById(R.id.text);
    }

    private void processControllers() {

        edit.setOnFocusChangeListener(new MyFocus());
        text.setOnTouchListener(new MyTouch02());
    }

    private class MyFocus implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            info.setText(hasFocus ? "EditText Focused" : "INFO");
        }
    }

    private class MyTouch02 implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();

            if (action == MotionEvent.ACTION_DOWN) {
                Toast.makeText(Listener01Activity.this,
                        "Textview DOWN",
                        Toast.LENGTH_SHORT).show();
            } else if (action == MotionEvent.ACTION_MOVE) {
                final int pc = event.getPointerCount();
                StringBuffer sb = new StringBuffer();

                for (int i=0; i<pc; i++) {
                    sb.append("point" + event.getPointerId(i) +
                        ": " + (int) event.getX(i) + "/" + (int) event.getY(i));

                    if (i < pc - 1) {
                        sb.append("\n");
                    }
                }

                info.setText(sb.toString());
            } else if (action == MotionEvent.ACTION_UP) {
                Toast.makeText(Listener01Activity.this,
                        "Textview UP",
                        Toast.LENGTH_SHORT).show();
                info.setText("INFO");
            }

            return true;
        }
    }
}

package idv.derekhsu.helloword50;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Spinner01Activity extends AppCompatActivity {

    private TextView info;
    private Spinner spinner01, spinner02;
    private ArrayAdapter<String> aa01, aa02;

    private static final String[] arrayData = { "ONE", "TWO", "THREE"};
    private List<String> listData;

    private int spinnerCount = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner01);
        processViews();

        listData = new ArrayList<>();
        listData.add("ALPHA");
        listData.add("BETA");
        listData.add("DELTA");

        int layout01 = android.R.layout.simple_spinner_item;
        int layout02 = R.layout.spinner_dropdown;

        aa01 = new ArrayAdapter<String>(this, layout01, arrayData);
        spinner01.setAdapter(aa01);

        aa02 = new ArrayAdapter<>(this, layout02, listData);
        aa02.setDropDownViewResource(layout02);
        spinner02.setAdapter(aa02);

        processControllers();
    }

    private void processViews() {
        this.info = (TextView) findViewById(R.id.info2);
        this.spinner01 = (Spinner) findViewById(R.id.spinner01);
        this.spinner02 = (Spinner) findViewById(R.id.spinner02);
    }

    private void processControllers() {

        MyItem myItem = new MyItem();

        this.spinner01.setOnItemSelectedListener(myItem);
        this.spinner02.setOnItemSelectedListener(myItem);
    }

    private class MyItem implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (spinnerCount > 0) {
                spinnerCount--;
                return;
            }

            String message = "";
            int vid = parent.getId();

            if (vid == R.id.spinner01) {
                message = arrayData[position];
                listData.add(message);
                aa02.notifyDataSetChanged();
            } else if (vid == R.id.spinner02) {
                message = listData.get(position);
            }

            info.setText(message);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}

package idv.derekhsu.helloword50;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListView01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view01);
        
        String[] data = new String[] {"1", "2", "3"};
        
        int layoutId = android.R.layout.simple_list_item_1;

        ArrayAdapter<String> aa =
                new ArrayAdapter<String>(this, layoutId, data);

        final ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(aa);
    }
}

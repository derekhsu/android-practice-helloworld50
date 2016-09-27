package idv.derekhsu.helloword50.res;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import idv.derekhsu.helloword50.R;

public class Res02Activity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<CharSequence> aa;
    private List<CharSequence> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res02);

        processView();
        items = new ArrayList<>();

        items.add("A");
        items.add("B");
        items.add("C");

        aa = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(aa);
    }

    private void processView() {
        listView = (ListView) findViewById(R.id.list_view_res02);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.listview_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        if (item.getItemId() == R.id.context_menu_view) {
            CharSequence charSequence = aa.getItem(info.position);
            Toast.makeText(this, charSequence, Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}

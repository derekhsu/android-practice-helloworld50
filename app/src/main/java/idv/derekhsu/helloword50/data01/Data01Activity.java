package idv.derekhsu.helloword50.data01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import idv.derekhsu.helloword50.R;

public class Data01Activity extends AppCompatActivity {

    private PlaceDAO placeDAO;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data01);

        registerForContextMenu(listView);

        placeDAO = new PlaceDAO(this);

    }

    private void processViews() {
        this.listView = (ListView) findViewById(R.id.data_listview_data01);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) menuInfo;

        Place selected = placeDAO.get(info.id);

        menu.setHeaderTitle(selected.getNote());

        if (v == listView) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.menu_data01_context, menu);
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        final Place selected = placeDAO.get(info.id);
        int id = item.getItemId();

        switch (id) {
            case R.id.update_menu:
                break;
            case R.id.delete_menu:
                break;
        }
    }
}

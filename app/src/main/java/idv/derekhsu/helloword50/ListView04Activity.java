package idv.derekhsu.helloword50;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import idv.derekhsu.helloword50.listview04.Fruit;
import idv.derekhsu.helloword50.listview04.FruitAdapter;

public class ListView04Activity extends AppCompatActivity {

    private List<Fruit> items;
    private ListView listView;
    private TextView info;
    private FruitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view04);

        processView();
        processControllers();

        items = new ArrayList<>();

        items.add(new Fruit(1, "Strawberry", "Sweet fleshy red fruit", true));
        items.add(new Fruit(2, "Carrot", "Edible root of the cultivated carrot plant", false));
        items.add(new Fruit(3, "Pumpkin", "Usually large pulpy deep-yellow round fruit", true));

        adapter = new FruitAdapter(this, R.layout.listview_item04, items);

        this.listView.setAdapter(adapter);
    }

    private void processView() {
        info = (TextView) findViewById(R.id.info4);
        this.listView = (ListView) findViewById(R.id.list_view4);
    }

    private void processControllers() {
        MyItem myItem = new MyItem();
        this.listView.setOnItemClickListener(myItem);
    }

    private class MyItem implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Fruit fruit = adapter.getItem(position);
            fruit.setSelected(!fruit.isSelected());
            adapter.set(position, fruit);

            info.setText(fruit.getName() + ": " + (fruit.isSelected() ? "selected": "unselected"));
        }
    }
}
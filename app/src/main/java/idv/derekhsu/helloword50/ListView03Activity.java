package idv.derekhsu.helloword50;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListView03Activity extends AppCompatActivity {


    private List<HashMap<String, String>> items;
    private ListView listView;
    private TextView info;
    private SimpleAdapter aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view03);

        this.processViews();
        this.processControllers();

        items = new ArrayList<>();

        HashMap<String, String> record;

        record = new HashMap<>();
        record.put("id", "1");
        record.put("name", "StrawBerry");
        record.put("content", "Sweet fleshy red fruit");
        items.add(record);

        record = new HashMap<>();
        record.put("id", "2");
        record.put("name", "Carrot");
        record.put("content", "Edible root of the cultivate carrot plant");
        items.add(record);

        record = new HashMap<>();
        record.put("id", "3");
        record.put("name", "Pumpkin");
        record.put("content", "Usually large pulpy depp-yellow round fruit ");
        items.add(record);

        record = new HashMap<>();
        record.put("id", "4");
        record.put("name", "Apple");
        record.put("content", "An apple a day keeps doctors away");
        items.add(record);

        record = new HashMap<>();
        record.put("id", "5");
        record.put("name", "Pineapple");
        record.put("content", "Pineapple feels bad");
        items.add(record);

        record = new HashMap<>();
        record.put("id", "6");
        record.put("name", "Tomato");
        record.put("content", "Tomato comes from Japan");
        items.add(record);

        record = new HashMap<>();
        record.put("id", "7");
        record.put("name", "Banana");
        record.put("content", "Babababababab nananananana");
        items.add(record);

        record = new HashMap<>();
        record.put("id", "8");
        record.put("name", "Orange");
        record.put("content", "Orange is yellow");
        items.add(record);

        record = new HashMap<>();
        record.put("id", "9");
        record.put("name", "Watermelon");
        record.put("content", "Taiwan's watermelon");
        items.add(record);

        String[] keys = {"id", "name", "content"};
        int[] viewIds = { R.id.id_text, R.id.name_text, R.id.content_text };

        aa = new SimpleAdapter(this, items, R.layout.listview_item, keys, viewIds);

        listView.setAdapter(aa);
    }

    private void processViews() {
        info = (TextView) findViewById(R.id.info2);
        listView = (ListView) findViewById(R.id.list_view2);
    }

    private void processControllers() {
        MyItem myItem = new MyItem();
        MyScroll myScroll = new MyScroll();
        this.listView.setOnItemClickListener(myItem);
        this.listView.setOnItemLongClickListener(myItem);
        this.listView.setOnScrollListener(myScroll);
    }

    private class MyItem implements AdapterView.OnItemClickListener,
            AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            TextView nameText = (TextView) view.findViewById(R.id.name_text);
            info.setText("LongClick: " + nameText.getText());
            parent.setSelection(position);
            listView.smoothScrollToPosition(parent.getSelectedItemPosition());
            return false;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            TextView nameText = (TextView) view.findViewById(R.id.name_text);
            info.setText("Click: " + nameText.getText());
        }
    }

    private class MyScroll implements AbsListView.OnScrollListener {

        private boolean isBottom;

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            isBottom = (firstVisibleItem + visibleItemCount) >= totalItemCount;
            info.setText("First: " + firstVisibleItem + " Visible: " + visibleItemCount);
        }

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            switch (scrollState) {
                case OnScrollListener.SCROLL_STATE_FLING:
                    break;
                case OnScrollListener.SCROLL_STATE_IDLE:
                    if (isBottom) {
                        Toast.makeText(ListView03Activity.this, "Bottom", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                    break;
            }
        }
    }
}

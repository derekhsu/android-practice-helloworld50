package idv.derekhsu.helloword50.listview04;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import idv.derekhsu.helloword50.R;

/**
 * Created by derekhsu on 2016/9/25.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int layoutId;
    private List<Fruit> items;

    public FruitAdapter(Context context, int layoutId, List<Fruit> items) {
        super(context, layoutId, items);
        this.layoutId = layoutId;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = getContext();

        LinearLayout view;

        if (convertView == null) {
            view = new LinearLayout(context);

            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi = (LayoutInflater) context.getSystemService(inflater);
            vi.inflate(layoutId, view, true);
        } else {
            view = (LinearLayout) convertView;
        }

        TextView id_text = (TextView) view.findViewById(R.id.id_text);
        TextView name_text = (TextView) view.findViewById(R.id.name_text);
        TextView content_text = (TextView) view.findViewById(R.id.content_text);
        CheckBox selected_check = (CheckBox) view.findViewById(R.id.selected_check);

        Fruit fruit = items.get(position);

        id_text.setText(Long.toString(fruit.getId()));
        name_text.setText(fruit.getName());
        content_text.setText(fruit.getContent());
        selected_check.setChecked(fruit.isSelected());


        return view;
    }

    public void set(int index, Fruit fruit) {
        if (index >= 0 && index < items.size()) {
            items.set(index, fruit);
            notifyDataSetChanged();
        }
    }
}

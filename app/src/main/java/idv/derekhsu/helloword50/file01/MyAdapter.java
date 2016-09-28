package idv.derekhsu.helloword50.file01;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by derekhsu on 2016/9/28.
 */
public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<String> items = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void add(String file) {
        items.add(file);
    }

    public String getFileName(int position) {
        return items.get(position);
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(context);
        } else {
            imageView = (ImageView) convertView;
        }

        Bitmap bitmap = BitmapFactory.decodeFile(items.get(position));
        imageView.setImageBitmap(bitmap);

        return imageView;
    }
}

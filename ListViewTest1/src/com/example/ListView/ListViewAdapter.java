package com.example.ListView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class ListViewAdapter extends BaseAdapter {
    private Context context;   //运行上下文
    private List<Map<String,Object>> listItems;
    private LayoutInflater listContainer;//视图容器

    public final class ListItemView
    {
       // public ImageView image;
        public TextView title;
        public TextView date;
        public TextView join;
        public TextView author;
        public TextView content;
    }

    public ListViewAdapter(Context context,List<Map<String,Object>> listItems)
    {
        this.context = context;
        listContainer = LayoutInflater.from(context);
        this.listItems = listItems;
    }

    public int getCount() {
        // TODO Auto-generated method stub
             return listItems.size();
         }

    public Object getItem(int arg0) {
      // TODO Auto-generated method stub
         return null;
       }

    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
      }


    /**
     * ListView Item设置
     */
    public View getView(int position,View convertView,ViewGroup parent)
    {
        Log.e("method","getView");
        ListItemView listItemView = null;
        if (convertView == null)
        {
            listItemView = new ListItemView();
            convertView = listContainer.inflate(R.layout.list_item,null);
           // listItemView.image = (ImageView)convertView.findViewById(R.id.imageItem);
            listItemView.title = (TextView)convertView.findViewById(R.id.titleItem);
            listItemView.date = (TextView)convertView.findViewById(R.id.dateItem);
            listItemView.join = (TextView)convertView.findViewById(R.id.joinItem);
            listItemView.author = (TextView)convertView.findViewById(R.id.authorItem);
            listItemView.content = (TextView)convertView.findViewById(R.id.contentItem);
            convertView.setTag(listItemView);
        }
        else
        {
            listItemView = (ListItemView)convertView.getTag();
        }
        //listItemView.image.setBackgroundResource((Integer)listItems.get(position).get("image"));

        listItemView.title.setText((String)listItems.get(position).get("title"));
        listItemView.date.setText((String)listItems.get(position).get("date"));
        listItemView.join.setText((String)listItems.get(position).get("join"));
        listItemView.author.setText((String)listItems.get(position).get("author"));
        listItemView.content.setText((String)listItems.get(position).get("content"));
        return convertView;
    }
}

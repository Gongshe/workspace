package com.example.ListView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

    public int getCount() {  //列表显示行数
        // TODO Auto-generated method stub
             return listItems.size();
         }

    public Object getItem(int position) {
      // TODO Auto-generated method stub
         return listItems.get(position);
       }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
      }


    /**
     * ListView Item设置
     */
    public View getView(int position,View convertView,ViewGroup parent)
    {
        Log.e("method","getView");
        ListItemView listItemView = null;

        //防止重复操作，findViewById()方法也是比较耗时的，因此只调用一次
        if (convertView == null)     // View的每次创建是比较耗时，因此对于getView方法传入convertView应充分利用！＝NULL 的判断
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
        else  //ViewHolder的应用可以优化LISTVIEW。View的findViewById（）方法比较耗时，因此需要考虑 只调用一次，之后就用View.getTag()方法来获得ViewHolder对象
        {
            listItemView = (ListItemView)convertView.getTag();
        }
        //listItemView.image.setBackgroundResource((Integer)listItems.get(position).get("image"));

        listItemView.title.setText((String)listItems.get(position).get("title"));
        listItemView.date.setText((String)listItems.get(position).get("date"));
        listItemView.join.setText((String)listItems.get(position).get("join"));
        listItemView.author.setText((String)listItems.get(position).get("author"));
        listItemView.content.setText((String)listItems.get(position).get("content"));

       /* listItemView.title.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("Text", " u clicked on title Position"+ position);

            }
        });
        */

        return convertView;
    }
}

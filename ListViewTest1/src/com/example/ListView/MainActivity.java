package com.example.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {
    private ListView listView;
    private ListViewAdapter listViewAdapter;
    private List<Map<String,Object>> listItems;
    //private Integer[] imageIDs = {R.drawable.abc,R.drawable.abc};
    private String[] titleItems = {"双11购物攻略","海淀区一居室出租","西行漫记","ICID报名","北京视觉设计求职","《三体》人物原型细究"};
    private String[] dateItems ={"2013.11.05","2013.10.31","2013.10.24","2013.10.24","2013.10.24","2013.10.24"};
    private String[] joinItems = {"43","143","43","43","43","43"};
    private String[] authorItems ={"Allen","Quuee","Fling","King","Anna","Bobbie"};
    private String[] contentItems = {"双11将至，最全的购物攻略","大约14平米左右，未装修，三层，有空调",
    "西部两月徒步归来，分享心得","交互设计行业盛事，报名优惠条件","视觉设计求职，三年工作经验，看看简历","视觉设计求职，三年工作经验，看看简历"};
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listView = (ListView)findViewById(R.id.list_string);
        listItems = getListItems();

        listViewAdapter = new ListViewAdapter(this,listItems);
        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //点击事件
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Log.i("Text", " u clicked item" + position);
            }
        });
}

    /**
     * 初始化信息
     */
    private List<Map<String,Object>> getListItems()
    {
        List<Map<String,Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < titleItems.length; i++)
        {
            Map<String,Object> map = new HashMap<String, Object>();  //泛型概念，object为任意类型
           // map.put("image",imageIDs[i]);
            map.put("title",titleItems[i]);
            map.put("date",dateItems[i]);
            map.put("join",joinItems[i]);
            map.put("author",authorItems[i]);
            map.put("content",contentItems[i]);
            listItems.add(map);
        }
        return listItems;
    }
}


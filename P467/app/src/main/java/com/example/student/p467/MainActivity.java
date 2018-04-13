package com.example.student.p467;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ItemAdapter itemAdapter;
    ArrayList<Item> list;
    LinearLayout container;
    GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container=findViewById(R.id.container);  //item.xml의 container를 받아온다

        list=new ArrayList<>();
        list.add(new Item("소녀시대1","010--4887-4848",30,R.drawable.image1));
        list.add(new Item("소녀시대2","010--4887-1234",31,R.drawable.image2));
        list.add(new Item("소녀시대3","010--4887-6575",32,R.drawable.image3));
        list.add(new Item("소녀시대4","010--4887-7546",33,R.drawable.image4));
        list.add(new Item("소녀시대5","010--4887-4567",34,R.drawable.image5));
        list.add(new Item("소녀시대6","010--4887-3467",35,R.drawable.image6));

        itemAdapter=new ItemAdapter(list);
        gridView=findViewById(R.id.gridView);
        gridView.setAdapter(itemAdapter); //itemAdapter 를 listView 에 심어줘야한다
    }
    public void clickbt(View v){
        itemAdapter.addItem(new Item("소녀시대6","010--4887-3467",35,R.drawable.image6));
        itemAdapter.notifyDataSetChanged();
    }


    //ItemAdapter
    public class ItemAdapter extends BaseAdapter {

        ArrayList<Item> list;
        Context context;
        public ItemAdapter(){}

        public ItemAdapter(ArrayList<Item> list){

            this.list=list;
        }
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }
        public void addItem(Item item){
            list.add(item);
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View vw =null;

            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            vw =  inflater.inflate(R.layout.item, container,true);
            //vw가 item을 받는다
            TextView name =vw.findViewById(R.id.textView);
            TextView phone=vw.findViewById(R.id.textView2);
            TextView age=vw.findViewById(R.id.textView3);
            ImageView img=vw.findViewById(R.id.imageView);
            name.setText(list.get(i).getName());
            phone.setText(list.get(i).getPhone());
            age.setText(list.get(i).getAge()+"");
            img.setImageResource(list.get(i).getResId());

            return vw;
        }
    }

}


package com.example.mobiledevtestscreening;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


public class hlm3 extends AppCompatActivity {

    GridView gridView;
    SwipeRefreshLayout swipeRefreshLayout;
    String[] items_name = {"Andi", "Budi", "Charlie", "Dede"};
    String[] items_birth = {"2014-01-01", "2014-02-02", "2014-03-03", "2014-06-06"};
    int[] items_img = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hlm3);

       gridView = findViewById(R.id.gridView);

       GridAdapter gridAdapter = new GridAdapter(items_name, items_birth, items_img, this);
       gridView.setAdapter(gridAdapter);

       gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent guest = new Intent(hlm3.this, hlm2.class);
               startActivity(guest);

               /*Button btn_guest = findViewById(R.id.btnGuest);
               btn_guest.setText(items_name[i]); */
           }
       });

        swipeRefreshLayout = findViewById(R.id.refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
            }
        });

    }

    public class GridAdapter extends BaseAdapter{
        String[] name;
        String[] birth;
        int[] img;
        Context context;
        LayoutInflater layoutInflater;

        public GridAdapter(String[] name, String[] birth, int[] img, Context context){
            this.img = img;
            this.name = name;
            this.birth = birth;
            this.context = context;
        }

        @Override
        public int getCount() {
            return items_name.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if (layoutInflater == null) {
                layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            }
            if (view == null){
                view = layoutInflater.inflate(R.layout.grid_item, null);
            }

            ImageView item_image = view.findViewById(R.id.grid_img);
            TextView item_name = view.findViewById(R.id.item_name);
            TextView item_birth = view.findViewById(R.id.item_birth);

            item_image.setImageResource(items_img[i]);
            item_name.setText(items_name[i]);
            item_birth.setText(items_birth[i]);

            return view;
        }
    }
}
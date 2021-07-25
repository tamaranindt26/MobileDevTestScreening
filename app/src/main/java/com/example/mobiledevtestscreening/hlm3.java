package com.example.mobiledevtestscreening;

import androidx.appcompat.app.AppCompatActivity;

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
               Intent a = new Intent(hlm3.this, hlm2.class);
               startActivity(a);
           }
       });

    }

    public class GridAdapter extends BaseAdapter{
        private String[] items_name;
        private String[] items_birth;
        private int[] items_img;
        private Context context;
        private LayoutInflater layoutInflater;

        public GridAdapter(String[] items_name, String[] items_birth, int[] items_img, Context context){
            this.items_img = items_img;
            this.items_name = items_name;
            this.items_birth = items_birth;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public int getCount() {
            return items_img.length;
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

            if (view == null){
                view = layoutInflater.inflate(R.layout.listview_item, viewGroup, false);
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
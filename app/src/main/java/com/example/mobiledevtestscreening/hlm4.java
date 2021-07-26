package com.example.mobiledevtestscreening;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobiledevtestscreening.databinding.ActivityHlm4Binding;

import java.util.List;

public class hlm4 extends AppCompatActivity {

    ListView listView;
    String[] eventTitle = {"Flower 1", "Flower 2", "Flower 3", "Flower 4"};
    String[] eventDate = {"01/02/2003", "02/03/2004", "03/04/20005", "04/05/2006"};
    int[] eventImg = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hlm4);

        listView = findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this, eventTitle, eventDate, eventImg);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent evnt = new Intent(hlm4.this, hlm2.class);
               startActivity(evnt);

               /*Button btn_evnt = findViewById(R.id.btnEvent);
               btn_evnt.setText(eventTitle[i]); */
           }
        });

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bck = new Intent(hlm4.this, MainActivity.class);
                startActivity(bck);
            }
        });

        ImageView search = findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "You Clicked Search", Toast.LENGTH_LONG).show();
            }
        });

        ImageView new_article = findViewById(R.id.new_article);
        new_article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(hlm4.this, hlm5.class);
                startActivity(c);
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String[] evenTitle;
        String[] eventDate;
        int[] eventImg;

        MyAdapter(Context c, String[] title, String[] date, int[] image) {
            super(c, R.layout.listview_item, R.id.lv_date, title);
            this.context = c;
            this.evenTitle = title;
            this.eventDate = date;
            this.eventImg = image;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View listview_item = layoutInflater.inflate(R.layout.listview_item, parent, false);
            ImageView lvimg = listview_item.findViewById(R.id.lv_img);
            TextView lvname = listview_item.findViewById(R.id.lv_name);
            TextView lvdate = listview_item.findViewById(R.id.lv_date);

            lvimg.setImageResource(eventImg[position]);
            lvname.setText(eventTitle[position]);
            lvdate.setText(eventDate[position]);

            return listview_item;
        }
    }
}


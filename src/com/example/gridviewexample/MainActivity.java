package com.example.gridviewexample;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private GridView grid;
	public String arr_city[] = { "A", "B", "C", "D", "E", "F", "F", "G", "H",
			"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
			"V", "W", "X", "Y", "Z" };
	ArrayList<String> arrlist = new ArrayList<String>();
	ArrayList<String> arrlist1 = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		grid = (GridView) findViewById(R.id.gridview);
		for (int i = 0; i <=arr_city.length-1; i++) {
			arrlist.add(arr_city[i]);
		}

		grid.setAdapter(new TextAdapter(this));
		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				arrlist1.add(arrlist.get(arg2));
				Toast.makeText(getApplicationContext(), arrlist.get(arg2),
						Toast.LENGTH_LONG).show();
				Intent i = new Intent(getApplicationContext(), text_view.class);
				i.putExtra("id", arrlist.get(arg2));
				startActivity(i);
				// grid.setAdapter(new TextAdapter(this));

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public class TextAdapter extends BaseAdapter {
		Context mcontext;

		public TextAdapter(Context mainActivity) {
			mcontext = mainActivity;
			// TODO Auto-generated constructor stub
		}

		public TextAdapter(OnItemClickListener onItemClickListener) {
			// TODO Auto-generated constructor stub
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return arrlist.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			TextView text1;
			if (arg1 == null) {
				text1 = new TextView(mcontext);
			} else {
				text1 = (TextView) arg1;
			}
			text1.setText(arrlist.get(arg0));
			// TODO Auto-generated method stub
			return text1;
		}

	}

}

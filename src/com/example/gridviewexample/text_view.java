package com.example.gridviewexample;

import java.util.Locale;


import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class text_view extends Activity implements OnClickListener,
		OnInitListener {
	public String arr_city[] = { "A", "B", "C", "D", "E", "F", "F", "G", "H",
			"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
			"V", "W", "X", "Y", "Z" };
	public int position;
	private TextView text, text1;
	public String s, s1;
	private Button btn_speak, btn_next, btn_previous, btn_slide;
	public TextToSpeech speech;
	public CountDownTimer ctd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.character_view);
		text = (TextView) findViewById(R.id.text1);
		text1 = (TextView) findViewById(R.id.text2);
		btn_speak = (Button) findViewById(R.id.btn_speak);
		btn_next = (Button) findViewById(R.id.next);
		btn_previous = (Button) findViewById(R.id.Previous);
		// btn_slide = (Button) findViewById(R.id.btn_slider);
		s = getIntent().getStringExtra("id");
		text.setText(s.toUpperCase());
		text1.setText(s.toLowerCase());
		fun_forslide();
		btn_speak.setOnClickListener(this);
		btn_next.setOnClickListener(this);
		btn_previous.setOnClickListener(this);
		// btn_slide.setOnClickListener(this);
		Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
		// btn_next.setVisibility(8);
		// btn_previous.setVisibility(8);
		speech = new TextToSpeech(this, this);
		speech.setLanguage(Locale.ENGLISH);
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.btn_speak:
			speech.speak(s, speech.QUEUE_FLUSH, null);

			// speech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
			// speech.setPitch((float) 1);
			// speech.setSpeechRate(8);

			break;
		case R.id.next:
			position++;
			if (position > arr_city.length - 1) {
				position = 0;
			}
			// speech = new TextToSpeech(this, this);
			// speech.setLanguage(Locale.ENGLISH);
			speech.speak(arr_city[position], speech.QUEUE_FLUSH, null);
			text.setText(arr_city[position].toUpperCase());
			text1.setText(arr_city[position].toLowerCase());
			break;
		case R.id.Previous:
			position--;
			if (position < 0) {
				position = arr_city.length - 1;
			}
			// speech = new TextToSpeech(this, this);
			// speech.setLanguage(Locale.ENGLISH);
			speech.speak(arr_city[position], speech.QUEUE_FLUSH, null);
			text.setText(arr_city[position].toUpperCase());
			text1.setText(arr_city[position].toLowerCase());

		default:
			break;
		}

	}

	@Override
	public void onInit(int arg0) {
		if (arg0 == TextToSpeech.SUCCESS) {

		}

		// TODO Auto-generated method stub

	}

	private void fun_forslide() {
		ctd = new CountDownTimer(5000, 1) {

			@Override
			public void onTick(long arg0) {

			}

			@Override
			public void onFinish() {

				position++;
				if (position > arr_city.length - 1) {
					// position=arr_city[position];

				}
				text.setText(arr_city[position].toUpperCase());
				text1.setText(arr_city[position].toLowerCase());
				fun_forslide();
				speech.speak(arr_city[position], speech.QUEUE_FLUSH, null);

			}
		}.start();

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		speech.shutdown();
	}

}

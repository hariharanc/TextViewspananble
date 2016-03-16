package com.example.edittextsample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	String name = "Maruthupandiyan hari";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView txtTime = (TextView) findViewById(R.id.txt_time);

		// txtTime.append(span);
		// txtTime.append("\n");

		for (int i = 0; i < name.length(); i++) {
			String word = Character.toString(name.charAt(i));

			Log.i(MainActivity.class.toString(), "MainActivity word" + word);
			if (word.equalsIgnoreCase("a")) {
				Spannable span = new SpannableString("a");
				span.setSpan(new RelativeSizeSpan(2f), 0, span.length(),
						Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				// txtTime.append(span);
			} else {
				// txtTime.append(word);
			}
		}

		
		SpannableStringBuilder sb = new SpannableStringBuilder(name);
		Pattern p = Pattern.compile("a", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(name);
		while (m.find()) {
			// String word = m.group();
			// String word1 = notes.substring(m.start(), m.end());

			sb.setSpan(new RelativeSizeSpan(5f), m.start(), m.end(),
					Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		}
		txtTime.setText(sb);

	}

}

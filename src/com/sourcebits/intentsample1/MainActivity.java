package com.sourcebits.intentsample1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void Process(View view) {
		Intent intent, chooser;
		EditText etext = (EditText) findViewById(R.id.edittext);

		if (view.getId() == R.id.button1) {
			intent = new Intent(android.content.Intent.ACTION_SEND);
			intent.setType("text/plain");
			// intent.putExtra("To","9681609345");
			intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "subject");
			intent.putExtra(android.content.Intent.EXTRA_TEXT, etext.getText().toString());// to
																							// send
																							// the
																							// data
																							// to
																							// chooser
																							// which
																							// we
																							// typed
																							// in
																							// edittext
			chooser = Intent.createChooser(intent, "share text");
			startActivity(chooser);

		}
		if (view.getId() == R.id.button2)

		{
			intent = new Intent(android.content.Intent.ACTION_VIEW);
			intent.setType("video/*");
			String Url= "https://www.youtube.com/watch?v=q9ayN39xmsI";
			//String Url = etext.getText().toString();
			// intent.setData(Uri.parse(Url));
			intent.putExtra(Intent.EXTRA_STREAM,Uri.parse(Url));
			chooser = Intent.createChooser(intent, "share video url");
			startActivity(chooser);
		}

		if (view.getId() == R.id.button3)

		{
			intent = new Intent("com.sourcebits.intentsample2.MainActivity");
			startActivity(intent);
		}

		if (view.getId() == R.id.button4) {
			intent = new Intent(android.content.Intent.ACTION_VIEW);
			String Url = etext.getText().toString();
			intent.setData(Uri.parse(Url));
			chooser = Intent.createChooser(intent, "open browser");
			startActivity(chooser);
		}

	}

}

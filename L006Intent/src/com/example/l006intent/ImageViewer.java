package com.example.l006intent;

import java.io.File;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewer extends Activity {

	private ImageView view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_im);
		view = (ImageView) findViewById(R.id.image);
		Uri uri = getIntent().getData();
		view.setImageURI(uri);

	}
}

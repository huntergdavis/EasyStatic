package com.hunterdavis.easystatic;

import java.util.Random;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

public class EasyStatic extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        

		OnClickListener regenButtonListner = new OnClickListener() {
			public void onClick(View v) {
					// do something when the button is clicked
					regenStatic();
			}
		};

		Button regenButton = (Button) findViewById(R.id.regenButton);
		regenButton.setOnClickListener(regenButtonListner);
		
		regenStatic();
		
		// Look up the AdView as a resource and load a request.
		AdView adView = (AdView) this.findViewById(R.id.adView);
		adView.loadAd(new AdRequest());
		
    }
    
    public Boolean regenStatic() {
    	ImageView imgView = (ImageView) findViewById(R.id.ImageView01);
    	
    	// create a width*height long int array and populate it with random 1 or 0
    	final Random myRandom = new Random();
    	int rgbSize = 300*400;
    	int[] rgbValues = new int[rgbSize];
    	for(int i = 0;i<rgbSize;i++)
    	{
    		rgbValues[i] = myRandom.nextInt();
    	}
    	
    	// create a width*height bitmap
    	BitmapFactory.Options staticOptions = new BitmapFactory.Options();
    	staticOptions.inSampleSize = 2;
    	Bitmap staticBitmap = Bitmap.createBitmap(rgbValues,300, 400,Bitmap.Config.RGB_565);
		
		
		// set the imageview to the static
		imgView.setImageBitmap(staticBitmap);
		
    	return true;    	
    	
    }
    
}
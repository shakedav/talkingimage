package talkingImage.app.shaked;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

import android.R.raw;
import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.media.SoundPool;

public class TalkingImageActivity extends Activity
	implements View.OnClickListener{
	
	protected Button Dad;
	protected Button Mom;
	protected SoundPool Pool;
	protected ArrayList<Integer> fileNames;
	
    TalkSounds talkSounds = new TalkSounds();
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Dad = (Button) findViewById(R.id.Dad);
        Mom = (Button) findViewById(R.id.Mom);
        ImageView image = (ImageView)findViewById(R.id.Image);
        image.setScaleType(ScaleType.FIT_XY);
        
        AddSoundsToHash();
        
        Dad.setOnClickListener(this);
        Mom.setOnClickListener(this);
        }
    
    public void AddSoundsToHash(){    	 
    	talkSounds.addSound(1, R.raw.dad1, getBaseContext());
    	talkSounds.addSound(2, R.raw.dad2, getBaseContext());
    	talkSounds.addSound(3, R.raw.dad3, getBaseContext());
    	talkSounds.addSound(4, R.raw.dad4, getBaseContext());
    	talkSounds.addSound(5, R.raw.dad5, getBaseContext());
    	talkSounds.addSound(6, R.raw.mom1, getBaseContext());
    	talkSounds.addSound(7, R.raw.mom2, getBaseContext());
    	talkSounds.addSound(8, R.raw.mom3, getBaseContext());
    	talkSounds.addSound(9, R.raw.mom4, getBaseContext());
    	talkSounds.addSound(10,R.raw.mom5, getBaseContext());         
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Random rand = new Random();			
		int index;
		if (v == Dad)
		{
			index = rand.nextInt(6);
			talkSounds.play(index, false);
		}
		else if (v == Mom)
		{
			int maximum = 10;
			int minimum = 6;
			Random rn = new Random();
			int range = maximum - minimum + 1;
			index =  rn.nextInt(range) + minimum;
			talkSounds.play(index, false);
		}
	}

}
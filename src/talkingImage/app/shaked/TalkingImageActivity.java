package talkingImage.app.shaked;


import android.R.raw;
import android.app.Activity;
import android.os.Bundle;
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
        talkSounds.addSound(1, R.raw.dad, getBaseContext());
		talkSounds.addSound(2, R.raw.mom, getBaseContext());
		
        Dad.setOnClickListener(this);
        Mom.setOnClickListener(this);
        }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == Dad)
		{
			talkSounds.play(1, false);
		}
		else if (v == Mom)
		{
			talkSounds.play(2, false);
		}
	}

}
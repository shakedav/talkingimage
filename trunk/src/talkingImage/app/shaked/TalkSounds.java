package talkingImage.app.shaked;
import java.util.HashMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class TalkSounds {
        private  SoundPool soundPool;
        private  HashMap<Integer, Integer> soundPoolHashMap;

        public TalkSounds() {
                soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
                soundPoolHashMap = new HashMap<Integer, Integer>();
        }

        public void addSound(int index, int soundID, Context context) {
                int soundPoolID = soundPool.load(context, soundID, 1);
                soundPoolHashMap.put(index, soundPoolID);
        }

        public int play(int index, boolean loop) {
        	int trackID;   
        	if (!loop)
        	{
        		trackID = soundPool.play((Integer) soundPoolHashMap.get(index), 1, 1, 1, 0, 1f);
    		}
            else
            	trackID = soundPool.play((Integer) soundPoolHashMap.get(index), 1, 1, 1, -1, 1f);
        	return trackID;
        }

        public void stop(int index) {
                soundPool.stop((Integer) soundPoolHashMap.get(index));
        }

        public void release() {
                soundPool.release();
        }
}
package talkingImage.app.shaked;
import java.util.HashMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class TalkSounds {
        private  SoundPool soundPool;
        private  HashMap soundPoolHashMap;

        public TalkSounds() {
                soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
                soundPoolHashMap = new HashMap(10);
        }

        public void addSound(int index, int soundID, Context context) {
                int soundPoolID = soundPool.load(context, soundID, 1);
                soundPoolHashMap.put(index, soundPoolID);
        }

        public void play(int index, boolean loop) {
                if (!loop)
                        soundPool.play((Integer) soundPoolHashMap.get(index), 1, 1, 1, 0, 1f);
                else
                        soundPool.play((Integer) soundPoolHashMap.get(index), 1, 1, 1, -1, 1f);
        }

        public void stop(int index) {
                soundPool.stop((Integer) soundPoolHashMap.get(index));
        }

        public void release() {
                soundPool.release();
        }
}
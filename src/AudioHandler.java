import java.io.*;
import javax.sound.sampled.*;

public class AudioHandler {

	private static float gain = 0.0f;
	private static float balance = 0.0f;

	public static void playClip(String soundFileName, int numLoops) {
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(soundFileName));
			clip.open(ais);

			FloatControl gainContorl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainContorl.setValue(gain);

			FloatControl balanceControl = (FloatControl)clip.getControl(FloatControl.Type.BALANCE);
			balanceControl.setValue(balance);
			
			clip.loop(numLoops);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void setBalance(float f) {
		balance = f;
	}

	public static void setGain(float f) {
		gain = f;
	}
	
}
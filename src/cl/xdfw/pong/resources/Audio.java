
package cl.xdfw.pong.resources;

import static java.applet.Applet.newAudioClip;
import java.applet.AudioClip;

/**
 *
 * @author Jstefaulv
 */
public class Audio {
    public AudioClip getAudio(String url) {
        return newAudioClip(getClass().
                getResource(url));
    }
}

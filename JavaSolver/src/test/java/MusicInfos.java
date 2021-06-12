import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;

public class MusicInfos {

    @Test
    public void run() {
        System.out.println(solution(
            /* "ABCDEFG",
            new String[] {
                "12:00,12:14,HELLO,CDEFGAB",
                "13:00,13:05,WORLD,ABCDEF"
            } */
                "CC#BCC#BCC#BCC#B",
                new String[] {
                        "03:00,03:30,FOO,CC#B",
                        "04:00,04:08,BAR,CC#BCC#BCC#B",
                        "23:09,23:59,TEST,CC#B"
                }
        ));
    }

    private String solution(String m, String[] musicinfos) {
        String mm = this.convert(m);
        String answer = "(None)";
        long len = -1;

        for (int i = 0; i < musicinfos.length; i++) {
            String mi = musicinfos[i];
            String[] mia = mi.split(",");

            LocalTime sTime = LocalTime.of(Integer.parseInt(mia[0].substring(0, 2)), Integer.parseInt(mia[0].substring(3, 5)));
            LocalTime eTime = LocalTime.of(Integer.parseInt(mia[1].substring(0, 2)), Integer.parseInt(mia[1].substring(3, 5)));
            Duration dur = Duration.between(sTime, eTime);

            mia[3] = this.convert(mia[3]);
            StringBuilder sb = new StringBuilder();
            int index = 0;
            for (int j = 0; j < dur.toMinutes(); j++) {
                if (mia[3].length() <= index) {
                    index = 0;
                }

                sb.append(mia[3].substring(index, index + 1));
                index++;
            }
            String music = sb.toString();
            // System.out.println(mm + " > " + music);
            int ex = music.indexOf(mm);
            if (-1 < ex) {
                if (len < dur.toMinutes()) {
                    len = dur.toMinutes();
                    answer = mia[2];
                }
            }

            // System.out.println(sb.toString());
        }

        return answer;
    }

    private String convert(String m) {
        m = m.replace("A#", "a");
        m = m.replace("B#", "b");
        m = m.replace("C#", "c");
        m = m.replace("D#", "d");
        m = m.replace("E#", "e");
        m = m.replace("F#", "f");
        m = m.replace("G#", "g");
        return m;
        /* String[] mm = m.split("#");

        for (int i = 0; i < mm.length; i++) {
            String s = mm[i];
            mm[i] = s.substring(0, s.length() - 1) + s.substring(s.length() - 1, s.length()).toLowerCase();
        }

        if (!m.substring(m.length() - 1, m.length()).equals("#")) {
            mm[mm.length- 1] = mm[mm.length - 1].toUpperCase();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mm.length; i++) {
            sb.append(mm[i]);
        }

        return sb.toString(); */
    }
}

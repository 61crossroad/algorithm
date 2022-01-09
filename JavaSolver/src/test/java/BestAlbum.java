import org.junit.jupiter.api.Test;

import java.util.*;

public class BestAlbum {
    @Test
    public void run() {
        int[] answer = solution(
                new String[] {"classic", "pop", "classic", "classic", "pop"},
                new int[] {500, 600, 150, 800, 2500});
        Arrays.stream(answer).forEach(s -> System.out.print(s + " "));
    }

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Song[] songs = new Song[genres.length];
        Map<String, List<Song>> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            songs[i] = new Song(i, genres[i], plays[i]);
        }
        Arrays.sort(songs, (o1, o2) -> o2.played - o1.played);

        for (Song song : songs) {
            List<Song> list = map.getOrDefault(song.genre, new ArrayList<>());
            if (list.isEmpty()) {
                list.add(new Song(-1, song.genre, 0));
            }
            list.get(0).played += song.played;
            list.add(song);
            map.put(song.genre, list);
        }

        List<Map.Entry<String, List<Song>>> entries = new ArrayList<>(map.entrySet());
        entries.sort((o1, o2) -> o2.getValue().get(0).played - o1.getValue().get(0).played);
        for (Map.Entry<String, List<Song>> entry : entries) {
            List<Song> list = entry.getValue();
            for (int i = 1; i <= 2 && i < list.size(); i++) {
                answer.add(list.get(i).id);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private static class Song {
        int id;
        String genre;
        int played;

        public Song(int id, String genre, int played) {
            this.id = id;
            this.genre = genre;
            this.played = played;
        }
    }
}

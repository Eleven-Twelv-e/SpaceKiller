public class SpaceKiller {
    static String spaceKiller(String s) {
        if (!s.equals("")) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ') {
                    stringBuilder.append(s.charAt(i));
                }
            }
            return String.valueOf(stringBuilder);
        } else return s;

    }
}
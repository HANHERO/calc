package controllers;

public class InputFormatter {

    private InputFormatter() {
    }

    public static String formatter(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);
        if (text.contains(".")) {
            for (int i = 0; i < text.indexOf("."); i += 3) {
                if (i == 0) continue;
                stringBuilder.insert(text.indexOf(".") - i, " ");
            }
        } else {
            for (int i = 0; i < text.length(); i += 3) {
                if (i == 0) continue;
                stringBuilder.insert(text.length() - i, " ");
            }
        }
        return stringBuilder.toString().replace(".", ",").replace("- ", "-");
    }
}

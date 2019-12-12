public class RLE {


    public RLE() {
    }

    ;

    public String encode(String plainText) {

        char previous = ' ';
        int counter = 1;
        String result = "";
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            if (previous == ' ') {
                previous = c;
            } else if (previous == c) {
                counter++;
            } else {
                result += "" + previous + counter;
                result += ",";
                previous = c;
                counter = 1;
            }
            if (i == plainText.length() - 1) {
                result += "" + previous + counter;
            }

        }

        return result;
    }


    String decode(String encodedText) {

        return "";

    }


}

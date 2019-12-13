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

        String[] dividedText = encodedText.split(",");
        System.out.println(dividedText[0]);
        StringBuilder sb = new StringBuilder();


        for(String s : dividedText){
            int counter = Character.getNumericValue(s.charAt(1));
            for (int j = 0; j < counter; j++){
            sb.append(s.charAt(0));
            }
        }

        return sb.toString();

    }


}

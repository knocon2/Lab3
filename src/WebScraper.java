import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static int countOneWord(final String url, final String word) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return 0;
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();

        String[] stringArray = contents.split(" |\\.|\\,|\\;");
        int count = 0;
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equalsIgnoreCase(word)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] unused) {
        System.out.println(countOneWord("http://erdani.com/tdpl/hamlet.txt", "the"));
    }
}

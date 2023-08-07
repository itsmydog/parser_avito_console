package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static final String url = "https://www.avito.ru/moskva_i_mo/telefony/mobilnye_telefony/apple/iphone_11-ASgBAgICA0SywA2kmzm0wA3OqzmwwQ2I_Dc?cd=1&f=ASgBAQECA0SywA2kmzm0wA3OqzmwwQ2I_DcBQObgDST2wVz4wVwBRcaaDBV7ImZyb20iOjAsInRvIjoyNTAwMH0&s=104";
    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect(url).get();
        List <String> listOne = new ArrayList<>();


        for (Element x : doc.select(
                "div[data-marker=item]"
        )){
            Elements elements = x.select("[itemprop=url]");
            if (elements.isEmpty()){
                continue;
            } else {
                final String title = x.select("[title]").text();
                final String href = elements.attr("href");
                final String price = x.select("[itemprop=price]").attr("content");
                listOne.add((title + " | " + price + " | " + href));
                System.out.println(title + " | " + price + " | " + "https://www.avito.ru" +href);
            }
        }



    }
}

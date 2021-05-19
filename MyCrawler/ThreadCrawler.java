package MyCrawler;
import java.util.ArrayList;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import java.io.IOException;
import java.util.List;
import java.net.URL;
import java.util.Stack;
import java.util.concurrent.*;
public class ThreadCrawler implements Runnable {
    private static Object object1 = new Object();
    private Stack<String> URLS;
    private ArrayList<String> visitedLinks = new ArrayList<String>();
    private int ID;
    private static final int Max_Depth = 5;
    //public static BlockingQueue<String> URLS_queue = new LinkedBlockingDeque<>();

    public ThreadCrawler(Stack<String>urls) {
        System.out.println("Web crawler create");

      URLS=urls;



    }

    @Override


    public void  run() {


while(true)
{
try {
    synchronized (object1){
        String url = URLS.pop();

        if (url == null) {
            break;
        }
        crawl(url);
    }

    }catch (Exception e) {
    e.printStackTrace();
}

}



    }

    private synchronized void crawl(String u) {

      //  if(level<=Max_Depth)
         {
            String url = u.toString();
            Document doc=request(url);
            if(doc!=null)
            {
for(Element link  : doc.select("a[href]"))
{
    String next_link=link.absUrl("href");
    if(visitedLinks.contains(next_link)==false)
    {

      URLS.push(next_link);
    }
}


            }
        }



    }

    private synchronized Document request(String url) {

        try {

            Connection con = Jsoup.connect(url);
            Document doc = con.get();
            if (con.response().statusCode() == 200) {
                System.out.println(url);
                String title = doc.title();
                System.out.println(title);
                visitedLinks.add(url);


                return doc;
            }

            return null;
        } catch (IOException e) {
            return null;

        }


    }
}

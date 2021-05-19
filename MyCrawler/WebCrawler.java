package MyCrawler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.Stack;


public class WebCrawler {
    private Stack<String> URLS;

    public WebCrawler(Stack<String>urls)
    {

        URLS=urls;


    }

    private List<Thread> threads;


public void thread_running(int no_thread)
{
threads=new ArrayList<>();

for(int i=0;i<no_thread;i++)
{
threads.add(new Thread(new MyCrawler.ThreadCrawler(URLS)));
 threads.get(i).start();

}
    for(Thread thread :threads)
    {
        try
        {
            thread.join();

        }
        catch (InterruptedException e)
        {

            e.printStackTrace();

        }

    }


}







}

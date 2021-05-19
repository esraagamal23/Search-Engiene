package MyCrawler;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.net.URL;
import java.util.concurrent.*;
import java.util.Stack;

public class Main {



    public static void main(String args[])
    {
        Stack<String>urls=new Stack<>();
Scanner input=new Scanner(System.in);

urls.push("https://www.geeksforgeeks.org/stack-class-in-java/");
urls.push("https://codeforces.com/");
urls.push("https://www.w3schools.com/java/java_user_input.asp");
System.out.println("Please Enter The number of Thread");
int no_thread=input.nextInt();//take number of thread


//urls.add("https://codeforces.com/");
WebCrawler crawler=new WebCrawler(urls);
//crawler.begin(no_thread);
crawler.thread_running(no_thread);




    }
}

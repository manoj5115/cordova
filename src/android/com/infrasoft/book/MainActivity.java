package com.infrasoft.book;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.pm.InstrumentationInfo;
import android.os.Bundle;

import com.infrasoft.book.view.BookAdapter;
import com.infrasoft.book.view.BookLayout;
import com.infrasoft.book.view.BookModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity {

    String page1 = "1 - Android is a mobile operating system (OS) currently developed by Google, based on the Linux kernel and designed primarily for touchscreen mobile devices such as smartphones and tablets. Android's user interface is based on direct manipulation, using touch gestures that loosely correspond to real-world actions, such as swiping, tapping and pinching, to manipulate on-screen objects, along with a virtual keyboard for text input. In addition to touchscreen devices, Google has further developed Android TV for televisions, Android Auto for cars, and Android Wear for wrist watches, each with a specialized user interface";
    String page2 = "2 - Initially developed by Android, Inc., which Google bought in 2005,[13] Android was unveiled in 2007, along with the founding of the Open Handset Alliance – a consortium of hardware, software, and telecommunication companies devoted to advancing open standards for mobile devices.[14] As of July 2013, the Google Play store has had over one million Android applications (\"apps\") published, and over 50 billion applications downloaded.[15]";
    String page3 = "3 - An April–May 2013 survey of mobile application developers found that 71% of developers create applications for Android,[16] and a 2015 survey found that 40% of full-time professional developers see Android as their priority target platform, which is comparable to Apple's iOS on 37% with both platforms far above others.[17] At Google I/O 2014, the company revealed that there were over one billion active monthly Android users, up from 538 million in June 2013.[18]";
    String page4 = "4 - Android, Inc. was founded in Palo Alto, California in October 2003 by Andy Rubin (co-founder of Danger),[25] Rich Miner (co-founder of Wildfire Communications, Inc.),[26] Nick Sears (once VP at T-Mobile),[27] and Chris White (headed design and interface development at WebTV[13]) to develop, in Rubin's words, \"smarter mobile devices that are more aware of its owner's location and preferences\".[13] The early intentions of the company were to develop an advanced operating system for digital cameras.";
    String page5 = "5 - Source code of Android is released by Google under open source licenses, although most Android devices ultimately ship with a combination of open source and proprietary software, including proprietary software required for accessing Google services.[3] Android is popular with technology companies that require a ready-made, low-cost and customizable operating system for high-tech devices.[19] Its open nature has encouraged a large community of developers and enthusiasts to use the open-source code as a foundation for community-driven projects.";
    private int totalPages = 5;
    //String page6 = "6 - " + page3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BookLayout bk = new BookLayout(this);
        String data = getIntent().getStringExtra("data");
//        List<BookModel> bookPages = initPages(data);
        List<BookModel> bookPages = initPages();
        BookAdapter ba = new BookAdapter(this);
        // ba.addItem(str);
        ba.setData(bookPages);
        bk.setPageAdapter(ba);
        setContentView(bk);
    }

    private List<BookModel> initPages(String rawData) {
        List<BookModel> bookPages = new ArrayList<BookModel>();
        try {
            JSONArray data = new JSONArray(rawData);
            for (int i = 0; i < data.length(); i++) {

                JSONObject row = data.getJSONObject(i);
                if (row != null) {
                    String title = row.getString("title");
                    String content = row.getString("content");
                    BookModel b = new BookModel();
                    b.setTitle(title);
                    b.setContent(content);
                    bookPages.add(b);
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bookPages;
    }

    private List<BookModel> initPages() {
        List<String> content = new ArrayList<String>();
        content.add(page1);content.add(page2);content.add(page3);content.add(page4);content.add(page5);
        List<BookModel> bookPages = new ArrayList<BookModel>();
        for (int i = 0; i < totalPages; i++) {
            BookModel b = new BookModel();
            b.setTitle("Page " + (i + 1) + " of " + totalPages);
            b.setContent(content.get(i));
            bookPages.add(b);
        }
        return bookPages;
    }
}
package cn.cxnxs.test;


import com.rometools.rome.feed.module.DCModule;
import com.rometools.rome.feed.module.DCModuleImpl;
import com.rometools.rome.feed.module.DCSubject;
import com.rometools.rome.feed.module.DCSubjectImpl;
import com.rometools.rome.feed.synd.*;
import com.rometools.rome.io.SyndFeedOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class RSSDemo {

    public static void main(String[] args) {
        try {
            SyndFeed feed = new SyndFeedImpl();
            feed.setFeedType("rss_2.0");
            feed.setTitle("Sample RSS Feed");
            feed.setLink("http://www.example.com");
            feed.setDescription("This is a sample RSS feed");

            List<SyndEntry> entries = new ArrayList<>();
            SyndEntry entry = new SyndEntryImpl();
            entry.setTitle("Entry Title");
            entry.setLink("http://www.example.com/entry1");
            entry.setPublishedDate(new Date());
            SyndContentImpl syndContent = new SyndContentImpl();
            syndContent.setValue("This is the content of the entry");
            entry.setDescription(syndContent);

            DCModule dcModule = new DCModuleImpl();
            DCSubject dcSubject = new DCSubjectImpl();
            dcSubject.setValue("Java");
            dcModule.setSubjects(Collections.singletonList(dcSubject));
            entry.getModules().add(dcModule);

            entries.add(entry);
            feed.setEntries(entries);

            System.out.println(new SyndFeedOutput().outputString(feed));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

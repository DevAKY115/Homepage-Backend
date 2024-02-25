package com.projects.Homepage.Itemlist;

import com.projects.Homepage.Itemlist.Websites.Caseking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    protected Iterable<Item> getAllItems(){
        return itemRepository.findAll();
    }

    protected Item createItem(Item item){
        item.setBelowThreshold(item.getPrice() < item.getThreshold() ? true : false);
        return itemRepository.save(item);
    }

    protected Item getItem(long id){
        return itemRepository.findById(id).get();
    }

    protected Item grabInformation(String url){

        String website = getWebsite(url);

        if(website == null){
            return new Item();
        }

        switch (website){
            case "caseking":
                Caseking caseking = new Caseking();
                caseking.scrapeProduct(url);
                return caseking;
        }



        return null;
    }

    protected String getWebsite(String urlString){
        try {
            URL url = new URL(urlString);

            String host = url.getHost();
            host = host.substring(host.indexOf('.') + 1);
            host = host.substring(0, host.indexOf('.'));

            return host;

        } catch (MalformedURLException e){
            System.out.println("Couldn't generate URL from urlString");
        }

        return null;
    }

    protected void updateAllPrices(){

        List<Item> allItems = (List<Item>) itemRepository.findAll();

        for(Item item : allItems){

            String website = getWebsite(item.url);

            switch (website){
                case "caseking":
                    Caseking caseking = new Caseking();
                    item.setPrice(caseking.updatePrice(item.url));
                    item.setBelowThreshold(item.getPrice() < item.getThreshold() ? true : false);
                    itemRepository.save(item);
                    continue;
                case "amazon":
            }

        }
    }


}

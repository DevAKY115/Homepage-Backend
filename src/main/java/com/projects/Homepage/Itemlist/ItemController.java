package com.projects.Homepage.Itemlist;

import com.projects.Homepage.Itemlist.Websites.Caseking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @PutMapping("/grabInformation")
    private Item grabInformation(@RequestBody String url){

        return itemService.grabInformation(url);
    }

    @PutMapping("/createItem")
    private Item createItem(@RequestBody Item item){

        return itemService.createItem(item);
    }

    @GetMapping("/getAllItems")
    private Iterable<Item> getAllItems(){
        return itemService.getAllItems();
    }
    @GetMapping(path="/getItem/{id}")
    private Item getItem(@PathVariable long id){
        return itemService.getItem(id);
    }

    private Item editItem(@RequestBody Long id){
        return null;
    }

    private Item deleteItem(@RequestBody Long id){
        return null;
    }

    @GetMapping("/updatePrices")
    private void updatePrices(){
        itemService.updateAllPrices();
    }



}

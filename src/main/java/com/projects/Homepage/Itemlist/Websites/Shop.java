package com.projects.Homepage.Itemlist.Websites;

import com.projects.Homepage.Itemlist.Item;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public interface Shop {

    /**
     * Passes the url to a WebDriver and gathers the necessary information.
     * Returns an Item with the information filled in.
     * @param url
     * @return
     */
    Item scrapeProduct(String url);

    /**
     * Grabs the price of the product.
     * @param driver the WebDriver containing the product information.
     */
    void scrapePrice(WebDriver driver);

    /**
     * Grabs the availabilty of the product.
     * @param driver the WebDriver containing the product information.
     */
    void scrapeAvailability(WebDriver driver);

    /**
     * Grabs the name of the product.
     * @param driver the WebDriver containing the product information.
     */
    void scrapeName(WebDriver driver);

    /**
     * Grabs the name of the website from its url.
     * @param url
     * @throws MalformedURLException
     */
    void scrapeWebsite(String url);

    /**
     * updates the price of the item
     * @param urlString URL of the item
     * @return the price of the item
     */
    double updatePrice(String urlString);

}

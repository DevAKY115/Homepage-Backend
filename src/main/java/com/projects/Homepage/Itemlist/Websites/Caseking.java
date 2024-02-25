package com.projects.Homepage.Itemlist.Websites;

import com.projects.Homepage.Itemlist.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Caseking extends Item implements Shop{

    @Override
    public Item scrapeProduct(String url) {

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--user-data-dir=C:\\Users\\B\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        //options.addArguments("--headless");

        ChromeDriver driver = new ChromeDriver(options);
        driver.get(url);

        scrapePrice(driver);
        scrapeAvailability(driver);
        scrapeName(driver);
        scrapeWebsite(url);

        this.setBelowThreshold(this.getPrice() < this.getThreshold() ? true : false);


        driver.quit();



        return this;
    }

    @Override
    public void scrapePrice(WebDriver driver) {

        String price = driver.findElement(By.className("article_details_price")).getText();

        price = price.substring(0, price.length()-2);
        price = price.replace(',', '.');

        setPrice(Double.parseDouble(price));
    }

    @Override
    public void scrapeAvailability(WebDriver driver) {
        String availability = driver.findElement(By.className("delivery_container")).findElement(By.tagName("p")).getText();

        if(availability.equals("lagernd")){
            setAvailable(true);
            return;
        }
        setAvailable(false);
    }

    @Override
    public void scrapeName(WebDriver driver){
        String name = driver.findElement(By.tagName("h1")).getText();
        name = name.substring(name.indexOf("\n")+1, name.length());

        setName(name);
    }

    @Override
    public void scrapeWebsite(String urlString) {

        setUrl(urlString);


        try {
            URL url = new URL(urlString);

            String host = url.getHost();
            host = host.substring(host.indexOf('.') + 1);
            host = host.substring(0, host.indexOf('.'));

            setWebsite(host);

        } catch (MalformedURLException e){
            System.out.println("Couldn't generate URL from urlString");
        }
    }


    public double updatePrice(String urlString){
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(urlString);

        String price = driver.findElement(By.className("article_details_price")).getText();

        price = price.substring(0, price.length()-2);
        price = price.replace(',', '.');


        driver.quit();

        return Double.parseDouble(price);

    }


}

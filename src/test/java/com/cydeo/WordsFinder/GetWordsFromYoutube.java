package com.cydeo.WordsFinder;

import com.cydeo.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GetWordsFromYoutube {
    public static void main(String[] args) {
        System.out.println(dnm());
    }



public static ArrayList<String> dnm(){


        Driver.getDriver().get("https://studylib.net/flashcards/set/yeni-set_242265");
    List<WebElement> a=Driver.getDriver().findElements(By.xpath("//*[@itemprop=\"text\"]"));
    ArrayList<String>b=new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {



            if (i%2==0){
              //  System.out.println(i+"="+a.get(i).getText());
                  b.add(a.get(i).getText());
            }




        }


        
        
        Driver.getDriver().close();

        return b;
        }
}




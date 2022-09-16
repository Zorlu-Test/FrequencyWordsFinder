package com.cydeo.WordsFinder;

import com.cydeo.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class voc_Frequency {


    @Test
    public void dnm() throws InterruptedException, FileNotFoundException {

        Driver.getDriver().get("https://youglish.com/");


        File file=new File("src/test/java/com/cydeo/MyWorks/mywords.txt");
        Scanner scanner=new Scanner(file);
        ArrayList<String> myWord=new ArrayList<>();

        while (scanner.hasNext()){
            myWord.add(scanner.nextLine());
        }

        System.out.println(myWord);

        for (int i = 0; i < myWord.size(); i++) {
            WebElement search = Driver.getDriver().findElement(By.xpath("//*[@id=\"q\"]"));
            Thread.sleep(250);
            search.sendKeys(myWord.get(i));
            WebElement searchClik = Driver.getDriver().findElement(By.xpath("//*[@id=\"btxt\"]"));
            searchClik.click();

            WebElement clear = Driver.getDriver().findElement(By.xpath("//*[@id=\"q\"]"));
            clear.clear();

            System.out.println();
        }



    }


}

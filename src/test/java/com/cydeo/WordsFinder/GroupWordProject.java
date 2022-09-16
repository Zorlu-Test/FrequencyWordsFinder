package com.cydeo.WordsFinder;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class GroupWordProject {
    public static void main(String[] args) throws FileNotFoundException, Exception {


        File file = new File("src/test/java/com/cydeo/MyWorks/MyUnknownWoc.txt");

        Scanner scan = new Scanner(file);

        ArrayList<String> myWords = new ArrayList<>(GetWordsFromYoutube.dnm());
        ArrayList<Integer> myWordInt = new ArrayList<>();


        Map<Integer, String> myMap = new TreeMap<>(Collections.reverseOrder());


//        while (scan.hasNext()) {
//            myWords.add(scan.nextLine());
//        }

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://youglish.com/");

        Actions actions = new Actions(driver);


        for (int i = 0; i < 5; i++) {


            WebElement search = driver.findElement(By.xpath("//*[@id=\"q\"]"));
            search.sendKeys(myWords.get(i), Keys.ENTER);

            try {
                if (driver.findElement(By.xpath("/html/body/div[1]/div/form/button")).isDisplayed()) {
                    //   actions.moveToElement(driver.findElement(By.xpath("//*[@id='recaptcha-anchor']/div[1]"))).click().perform();

                    Point point = driver.findElement(By.xpath("/html/body/div[1]/div/form/button")).getLocation();
                    point.getX();
                    point.getY();

                    actions.moveByOffset(point.getX(), point.getY()-90).click().build().perform();

                 //   Thread.sleep(200);
                    actions.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div/form/button"))).click().build().perform();

                }
            }catch (Exception a){

            }


            Thread.sleep(100);
            WebElement clear = driver.findElement(By.xpath("//*[@id=\"q\"]"));
            clear.clear();

//            actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[28]/div[2]/div[1]/button"))).perform();
//            actions.sendKeys("k").perform();

            WebElement elemntText = driver.findElement(By.xpath("(//h1)[1]"));

            String myNumbers = elemntText.getText();

            System.out.println("myNumbers = " + myNumbers);
            System.out.println("elemntText.getText() = " + elemntText.getText());

            String myNumStr[] = myNumbers.split(" ");

            String myOnlyNum = myNumStr[myNumStr.length - 1].replace("):", "").toLowerCase();
            String dummy2 = "";


            System.out.println("===================" + myOnlyNum);

            int myNumsInt;

            try {
                myNumsInt = Integer.parseInt(myOnlyNum);
            } catch (Exception a) {
                myNumsInt = 0;
            }

            myWordInt.add(myNumsInt);
            System.out.println(myOnlyNum);


            myMap.put(myNumsInt, myWords.get(i));

        }


        System.out.println("myMap = " + myMap);

        int m = 1;
        for (Integer integer : myMap.keySet()) {
            System.out.println(m + "- " + myMap.get(integer) + " = " + integer);
            m++;
        }


        // Send results to an email
        // Get rid of from Youtube video
        // 100 time rules
        // get vocabulary  from youtube


    }


}

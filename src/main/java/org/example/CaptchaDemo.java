package org.example;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.noise.StraightLineNoiseProducer;
import cn.apiclub.captcha.text.producer.NumbersAnswerProducer;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CaptchaDemo {

    // 1. Create the captch
    public static Captcha createCaptch(int width, int height) {
        return new Captcha.Builder(width, height)
                .addBackground(new GradiatedBackgroundProducer())
                .addText(new NumbersAnswerProducer())
                .addNoise(new StraightLineNoiseProducer())
                .build();
    }

    public static void createImage(Captcha captcha) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(captcha.getImage(), "png", bos);
            FileOutputStream fos = new FileOutputStream("C:/Installation/Captcha result/captDemo.png");
            fos.write(bos.toByteArray());
            fos.flush();
            fos.close();
        } catch (IOException io) {
            io.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }//catch
    }//method

    public static void main(String[] args) {
        Captcha captcha = CaptchaDemo.createCaptch(200, 80);
        createImage(captcha);
        System.out.println("DONE");
    }
}//class

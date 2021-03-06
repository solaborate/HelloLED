package com.solaborate.helloled.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.solaborate.helloled.LedAnimation;


public class MainActivity extends AppCompatActivity {

    LedAnimation ledAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ledAnimation = new LedAnimation();
    }

    public void redLedAnimation(View v) {
        // create a string that contains 24 color hex values, one for each led on the ring
        String redColor = "ff0000";
        String colors = redColor + redColor + redColor +
                redColor + redColor + redColor +
                redColor + redColor + redColor +
                redColor + redColor + redColor +
                redColor + redColor + redColor +
                redColor + redColor + redColor +
                redColor + redColor + redColor +
                redColor + redColor + redColor;
        showLedColors(colors);
    }

    public void greenLedAnimation(View v) {
        // create a string that contains 24 color hex values, one for each led on the ring
        String greenColor = "00ff00";
        String colors = greenColor + greenColor + greenColor +
                greenColor + greenColor + greenColor +
                greenColor + greenColor + greenColor +
                greenColor + greenColor + greenColor +
                greenColor + greenColor + greenColor +
                greenColor + greenColor + greenColor +
                greenColor + greenColor + greenColor +
                greenColor + greenColor + greenColor;
        showLedColors(colors);
    }

    public void blueLedAnimation(View v) {
        // create a string that contains 24 color hex values, one for each led on the ring
        String blueColor = "0000ff";
        String colors = blueColor + blueColor + blueColor +
                blueColor + blueColor + blueColor +
                blueColor + blueColor + blueColor +
                blueColor + blueColor + blueColor +
                blueColor + blueColor + blueColor +
                blueColor + blueColor + blueColor +
                blueColor + blueColor + blueColor +
                blueColor + blueColor + blueColor;
        showLedColors(colors);
    }

    public void stopLedAnimation(View v) {
        // this function will not shut down the Led Ring, but will show black colors on it
        // create a string that contains 24 black color hex
        String blackColor = "000000";
        String colors = blackColor + blackColor + blackColor +
                blackColor + blackColor + blackColor +
                blackColor + blackColor + blackColor +
                blackColor + blackColor + blackColor +
                blackColor + blackColor + blackColor +
                blackColor + blackColor + blackColor +
                blackColor + blackColor + blackColor +
                blackColor + blackColor + blackColor;
        showLedColors(colors);
    }

    private void showLedColors(String colors) {
        // convert colors string to byte array
        byte[] b = hexStringToByteArray(colors);

        // write the colors byte array in LED ring
        ledAnimation.writeLedColors(b);
    }

    private byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}
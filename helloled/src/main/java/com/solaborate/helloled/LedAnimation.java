package com.solaborate.helloled;

import android.support.annotation.Size;
import android.util.Log;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Created by Ardian Ahmeti on 10/07/19.
 * ardian.ahmeti97@gmail.com
 */

public class LedAnimation {

    private final String TAG = "LEDRing";
    private ByteBuffer mOutputBuffer = ByteBuffer.allocate(1024);//allocateDirect,allocate

    public LedAnimation(){}

    /**
     * Writes colors in Hello LedRing
     * @param rgbData - byte array of the color(s) to be shown on the ring
     *                Must be of size 72 ( 24 LEDs - 3 bytes per LED for Red / Green / Blue )
     * throws IllegalArgumentException if the size of @rgbData is not of size 72
     * */
    public void writeLedColors(@Size(72) byte[] rgbData) throws IllegalArgumentException {
        if(rgbData.length != 72){
            throw new IllegalArgumentException("Byte array size must be equal to 72 bytes");
        }
        writeToDevice(rgbData);
    }

    private void writeToDevice(byte[] rgbData) {
        try {
            mOutputBuffer.clear();
            mOutputBuffer.put(rgbData);
            LedsFrameData.write(mOutputBuffer, rgbData.length);
        } catch (IOException e) {
            Log.e(TAG, "write rgb data error:", e);
        }

    }

}

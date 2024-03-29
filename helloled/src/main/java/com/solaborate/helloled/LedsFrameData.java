package com.solaborate.helloled;

import java.io.IOException;
import java.nio.ByteBuffer;

public class LedsFrameData {
	static {
		System.loadLibrary("LedsJNI");
	}
    static void write(ByteBuffer buffer, int length, String writePath) throws IOException {
		if (buffer.isDirect()) {
			writeDirect(buffer, length, writePath);
		} else if (buffer.hasArray()) {
			writeArray(buffer.array(), length, writePath);
		} else {
			throw new IllegalArgumentException("buffer is not direct and has no array");
		}		

    }	
	private static native void writeArray(byte[] buffer, int length, String writePath) throws IOException;	//writeArray
	private static native void writeDirect(ByteBuffer buffer, int length, String writePath) throws IOException;	//writeDirect
}
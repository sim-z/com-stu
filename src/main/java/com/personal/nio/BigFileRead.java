package com.personal.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class BigFileRead {

    final int BUFFER_SIZE = 0x300000;// ��������СΪ3M

    public void read(File f) {

        try {
            MappedByteBuffer inputBuffer = new RandomAccessFile(f, "r").getChannel()
                    .map(FileChannel.MapMode.READ_ONLY, f.length() / 2, f.length() / 2);

            byte[] dst = new byte[BUFFER_SIZE];// ÿ�ζ���3M������

            long start = System.currentTimeMillis();

            for (int offset = 0; offset < inputBuffer.capacity(); offset += BUFFER_SIZE) {

                if (inputBuffer.capacity() - offset >= BUFFER_SIZE) {

                    for (int i = 0; i < BUFFER_SIZE; i++)

                        dst[i] = inputBuffer.get(offset + i);

                } else {

                    for (int i = 0; i < inputBuffer.capacity() - offset; i++)

                        dst[i] = inputBuffer.get(offset + i);

                }

                int length = (inputBuffer.capacity() % BUFFER_SIZE == 0) ? BUFFER_SIZE : inputBuffer.capacity() % BUFFER_SIZE;

                System.out.println(new String(dst, 0, length));// new
                // String(dst,0,length)��������ȡ�����汣����ַ��������Զ�����в���

            }

            long end = System.currentTimeMillis();

            System.out.println("��ȡ�ļ��ļ�һ�����ݻ��ѣ�" + (end - start) + "����");

        } catch (

        FileNotFoundException e)

        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (

        IOException e)

        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

    }

}

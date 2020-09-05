package com.example.demo.design.adapter;

/**
 * @ClassName Mp4Player
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/4 23:13
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}

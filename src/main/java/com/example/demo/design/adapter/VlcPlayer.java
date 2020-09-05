package com.example.demo.design.adapter;

/**
 * @ClassName VlcPlayer
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/4 23:12
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}

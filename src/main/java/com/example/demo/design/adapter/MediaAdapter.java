package com.example.demo.design.adapter;

/**
 * @ClassName MediaAdpter
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/4 23:13
 */
public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer player;

    public MediaAdapter(String audioType) {
        if ("vlc".equalsIgnoreCase(audioType)) {
            player = new VlcPlayer();
        } else if ("mp4".equalsIgnoreCase(audioType)) {
            player = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            player.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            player.playMp4(fileName);
        }
    }
}

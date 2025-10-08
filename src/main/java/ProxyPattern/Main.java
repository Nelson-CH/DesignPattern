package ProxyPattern;

import java.util.ArrayList;

//ServiceInterface: 定義 Real 物件與 Proxy 物件的共同介面。
interface YouTubeDownloader {
    void downloadVideo(int id);
}

class RealYouTubeDownloader implements YouTubeDownloader {
    @Override
    public void downloadVideo(int id) {
        System.out.println("Start to download video id #" + id);
    }
}

class ProxyYouTubeDownloader implements YouTubeDownloader {
    private RealYouTubeDownloader realYouTubeDownloader;
    private ArrayList<Integer> downloadedVideos;

    public ProxyYouTubeDownloader() {
        downloadedVideos = new ArrayList<>();
        realYouTubeDownloader = new RealYouTubeDownloader();
    }

    @Override
    public void downloadVideo(int id) {
        if (!downloadedVideos.contains(id)) {
            this.downloadedVideos.add(id);
            this.realYouTubeDownloader.downloadVideo(id);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ProxyYouTubeDownloader proxy = new ProxyYouTubeDownloader();
        proxy.downloadVideo(1);
        proxy.downloadVideo(2);
        proxy.downloadVideo(3);
    }
}

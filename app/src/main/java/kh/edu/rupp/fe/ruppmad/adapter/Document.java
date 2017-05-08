package kh.edu.rupp.fe.ruppmad.adapter;

/**
 * RUPPMAD
 * Created by leapkh on 4/26/17.
 */

public class Document {

    private String title;
    private String thumbnailUrl;
    private int size;

    public Document(String title, String thumbnailUrl, int size) {
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getFormatSize(){
        return size + " M";
    }

}

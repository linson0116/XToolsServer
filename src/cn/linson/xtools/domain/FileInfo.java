package cn.linson.xtools.domain;


public class FileInfo {
    private int width;
    private int height;
    private String name;
    private String path;
    private String date;
    private float template = 240;
    private float scale = 1;
    public int getNewWidth() {
        if (width > template && height > template) {
            scale = (float) (width > height ? width : height) / template;
            return (int) (width / scale);
        }
        return (int) template;
    }

    public float getNewHeight() {
        if (width > template && height > template) {
            scale = (float) (width > height ? width : height) / template;
            return (int) (height / scale);
        }
        return template;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}

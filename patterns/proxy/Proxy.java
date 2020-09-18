package patterns.proxy;

public class Proxy {
    public static void main(String[] args) {
        Image image = new ImageProxy("file");
        image.show();
    }
}

interface Image {
    void show();
}

class ImageImpl implements Image {
    private String file;

    public ImageImpl(String file) {
        this.file = file;
        load();
    }

    public void load() {
        System.out.println("Загрузка картинки " + file);
    }

    @Override
    public void show() {
        System.out.println("Показ картнки " + file);
    }
}

class ImageProxy implements Image {
    private String file;
    private ImageImpl image;

    public ImageProxy(String file) {
        this.file = file;
    }

    @Override
    public void show() {
        if (image == null) {
            image = new ImageImpl(file);
        }
        image.show();
    }
}
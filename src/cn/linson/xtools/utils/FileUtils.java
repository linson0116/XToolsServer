package cn.linson.xtools.utils;



import cn.linson.xtools.domain.FileInfo;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/11.
 */
public class FileUtils {
    public static ArrayList<FileInfo> getFileInfos(File fileDir) throws IOException {
        ArrayList<FileInfo> arrayList = new ArrayList<>();
        File[] files = fileDir.listFiles();
        for (File file : files) {
            try {
                Metadata metadata = ImageMetadataReader.readMetadata(file);
                String path = file.getAbsolutePath();
                String name = file.getName();
                FileInfo fileInfo = new FileInfo();
                fileInfo.setName(name);
                fileInfo.setPath(path);
                for (Directory directory : metadata.getDirectories()) {
                    for (Tag tag : directory.getTags()) {
                        String tagName = tag.getTagName();
                        String desc = tag.getDescription();
                        if (tagName.equals("Image Height")) {
                            fileInfo.setHeight(Integer.parseInt(desc.substring(0, desc.indexOf(' '))));
                        } else if (tagName.equals("Image Width")) {
                            fileInfo.setWidth(Integer.parseInt(desc.substring(0, desc.indexOf(' '))));
                        } else if (tagName.equals("Date/Time Original")) {
                            System.out.println(desc);
                        }
                    }
                }
                arrayList.add(fileInfo);
            } catch (ImageProcessingException e) {
                System.out.println(file.getName());
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}

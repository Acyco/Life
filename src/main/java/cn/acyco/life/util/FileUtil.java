package cn.acyco.life.util;

import java.io.File;
import java.io.IOException;

/**
 * @author Acyco
 * @create 2020-04-01 07:22
 */
public class FileUtil {
    /**
     * 创建一个新的文件，
     * @param file  文件对象
     * @return 是否有创建
     * @throws IOException  
     */
    public static boolean createFile(File file) throws IOException {
        return !file.exists() && (file.getParentFile().mkdir() && file.createNewFile());
    }
}

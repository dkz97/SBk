package org.dkz97.sbk.cmd;

import cn.hutool.core.io.file.PathUtil;
import cn.hutool.core.util.RuntimeUtil;
import org.dkz97.sbk.common.DateFormatTemp;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Desc: 用于监控线程的命令 如将线程dump到文件中
 *
 * @author dkz97
 * @version 1.0.0
 * @date 2022/9/2 17:51
 */
public class Jstack {


    public static String dlThreadDump(String id) {
        String folderPath = System.getProperty("user.dir") + "/thread/";

        return dlThreadDumpByDirPath(id, folderPath);
    }

    public static String dlThreadDumpByDirPath(String id, String dirPath) {
        // 创建文件夹，若文件夹已经存在则不会创建
        PathUtil.mkdir(Paths.get(dirPath));

        String dateStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateFormatTemp.YYYYMMDDHHMMSS));
        String threadFilePath = dirPath + dateStr + "_" + id + "_thread.txt";

        RuntimeUtil.exec("jstack " + id + " > " + threadFilePath);
        return threadFilePath;
    }

}

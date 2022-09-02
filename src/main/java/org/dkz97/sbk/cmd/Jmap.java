package org.dkz97.sbk.cmd;


import cn.hutool.core.io.file.PathUtil;
import cn.hutool.core.util.RuntimeUtil;
import org.dkz97.sbk.common.DateFormatTemp;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Desc: 将堆快照dump到项目目录的 /dump文件夹下
 *
 * @author dkz97
 * @version 1.0.0
 * @date 2022/9/2 16:02
 */
public class Jmap {

    /**
     * 返回内存占用直方图 (只有存活对象)
     * @param id 堆快照的id
     * @return 内存占用直方图
     */
    public static List<String> histoLive(String id) {
        return RuntimeUtil.execForLines("jmap -histo:live " + id);
    }

    /**
     * 导出堆快照，默认将堆快照下载到项目目录的 /dump文件夹下
     * @param id 堆快照id
     * @return 堆快照文件路径
     * @throws IOException IOException
     */
    public static String dlHeapDump(String id) throws IOException {
        String folderPath = System.getProperty("user.dir") + "/dump/";

        return dlHeapDumpByDirPath(id, folderPath);
    }

    /**
     * 导出堆快照，将堆快照下载到传入的文件夹路径下
     * @param id 进程id
     * @param dirPath 文件夹路径
     * @return 堆快照文件路径
     * @throws IOException IOException
     */
    public static String dlHeapDumpByDirPath(String id, String dirPath) throws IOException {
        // 创建文件夹，若文件夹已经存在则不会创建
        PathUtil.mkdir(Paths.get(dirPath));

        String dateStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateFormatTemp.YYYYMMDDHHMMSS));
        String dumpFilePath = dirPath + dateStr + "_" + id + "_heap.hprof ";
        RuntimeUtil.exec("jmap -dump:format=b,file=" + dumpFilePath + id);
        return dumpFilePath;
    }


}

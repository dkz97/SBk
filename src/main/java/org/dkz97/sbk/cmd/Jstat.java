package org.dkz97.sbk.cmd;

import cn.hutool.core.util.RuntimeUtil;
import org.dkz97.sbk.cmd.struct.ClassStruck;

import java.util.List;

/**
 * Desc: jstat命令，用于获取jvm的运行状态
 *
 * @author dkz97
 * @version 1.0.0
 * @date 2022/9/5 17:51
 */
public class Jstat {

    /**
     * 类加载信息
     * @param id 进程id
     * @return ClassStruck
     */
    public static ClassStruck getClass(String id) {
        ClassStruck result = new ClassStruck();
        List<String> console = RuntimeUtil.execForLines("jstat -class " + id);
        if (console.isEmpty() || console.size() < 2) {
            return result;
        }
        //String[] keys = console.get(0).split("\\s+");
        String[] values = console.get(1).split("\\s+");
        result.setLoaded(values[0]);
        result.setLoadBytes(values[1]);
        result.setUnloaded(values[2]);
        result.setUnLoadBytes(values[3]);
        result.setTime(values[4]);
        return result;
    }

}

package org.dkz97.sbk.cmd;

import cn.hutool.core.util.RuntimeUtil;
import org.dkz97.sbk.cmd.struct.ClassStruck;
import org.dkz97.sbk.cmd.struct.MemoryStruck;

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

    /**
     * 内存加载及各区内存信息
     * @param id 进程id
     * @return MemoryStruck
     */
    public static MemoryStruck getMemory(String id) {
        MemoryStruck result = new MemoryStruck();
        List<String> console = RuntimeUtil.execForLines("jstat -gc " + id);
        if (console.isEmpty() || console.size() < 2) {
            return result;
        }
        //String[] keys = console.get(0).split("\\s+");
        String[] values = console.get(1).split("\\s+");
        result.setS0C(values[0]);
        result.setS1C(values[1]);
        result.setS0U(values[2]);
        result.setS1U(values[3]);
        result.setEC(values[4]);
        result.setEU(values[5]);
        result.setOC(values[6]);
        result.setOU(values[7]);
        result.setMC(values[8]);
        result.setMU(values[9]);
        result.setCCSC(values[10]);
        result.setCCSU(values[11]);
        result.setYGC(values[12]);
        result.setYGCT(values[13]);
        result.setFGC(values[14]);
        result.setFGCT(values[15]);
        result.setGCT(values[16]);
        return result;
    }



}

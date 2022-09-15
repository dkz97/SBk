package org.dkz97.sbk.cmd;

import cn.hutool.core.util.RuntimeUtil;
import org.dkz97.sbk.cmd.struct.JpsStruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Desc: 用于执行jps命令，返回结果
 *
 * @author dkz97
 * @version 1.0.0
 * @date 2022/9/1 15:21
 */
public class Jps {

    private static final Logger log = LoggerFactory.getLogger(Jps.class);


    public static HashMap<String, JpsStruct> execute() {
        List<String> console = RuntimeUtil.execForLines("jps -l -v");
        return build(console);
    }

    private static HashMap<String, JpsStruct> build(List<String> console) {
        HashMap<String, JpsStruct> result = new HashMap<>();
        for (String aLine : console) {
            String[] one = aLine.split("\\s+");
            if (one.length < 2) {
                continue;
            }
            //排除sun.tools进程
            if (one[1].contains("sun.tools")) {
                continue;
            }

            String pid = one[0];
            String fullName = one[1];
            String className = fullName;
            if (fullName.contains(".") || !fullName.contains(".jar")) {
                // 获取最后一个.后面的值
                className = fullName.substring(fullName.lastIndexOf(".") + 1);
            }
            List<String> params = Arrays.stream(one).skip(2).collect(Collectors.toList());
            result.put(pid, new JpsStruct(pid, fullName, className, params));
        }
        return result;
    }

}

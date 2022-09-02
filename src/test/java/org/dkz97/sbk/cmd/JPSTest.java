package org.dkz97.sbk.cmd;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Desc: jps命令测试类
 *
 * @author dkz97
 * @version 1.0.0
 * @date 2022/9/1 19:25
 */
public class JPSTest {

    @Test
    void testBuild() throws Exception {
        // java 反射获取 org.dkz97.sbk.cmd.JPS
        Class<?> clazz = Class.forName("org.dkz97.sbk.cmd.JPS");
        // 获取方法
        Method buildMethod = clazz.getDeclaredMethod("build", List.class);
        buildMethod.setAccessible(true);
        // 构造参数
        List<String> console = Arrays.asList("19171 com.rs.io.radius3.RadiusStateDetailKafkaServer");
        Object invoke = buildMethod.invoke(clazz.newInstance(), console);
        System.out.println(invoke);
    }

}

package org.dkz97.sbk.cmd.struct;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Desc: 解析jps命令后生成的结构体，主要为了方便传输和提高可读性
 *
 * @author dkz97
 * @version 1.0.0
 * @date 2022/9/1 15:28
 */
@Data
@AllArgsConstructor
public class JpsStruct {

    /*   进程ID  */
    private String processId;
    /*   包含路径的全类名  */
    private String fullName;
    /*   执行的类名或者jar包名  */
    private String className;
    /*   执行参数  */
    private List<String> parameters;


}

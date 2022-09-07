package org.dkz97.sbk.cmd.struct;

import lombok.Data;

/**
 * Desc: 记录类加载数量或
 *
 * @author dkz97
 * @version 1.0.0
 * @date 2022/9/7 11:18
 */
@Data
public class ClassStruck {

    /* 加载class的数量 */
    private String loaded;

    /* 所占用空间大小 */
    private String loadBytes;

    /* 未加载数量 */
    private String unloaded;

    /* 未加载占用空间 */
    private String unLoadBytes;

    /* 加载时间 */
    private String time;

}

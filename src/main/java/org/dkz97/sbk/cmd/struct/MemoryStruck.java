package org.dkz97.sbk.cmd.struct;

import lombok.Data;

/**
 * Desc: 堆内存信息的结构体
 *
 * @author dkz97
 * @version 1.0.0
 * @date 2022/9/6 17:20
 */
@Data
public class MemoryStruck {

    /* 第一个幸存区的大小 */
    private String S0C;
    /* 第二个幸存区的大小 */
    private String S1C;
    /* 第一个幸存区的使用大小 */
    private String S0U;
    /* 第二个幸存区的使用大小 */
    private String S1U;
    /* eden的大小 */
    private String EC;
    /* eden的使用大小 */
    private String EU;
    /* 老年代的大小 */
    private String OC;
    /* 老年代的使用大小 */
    private String OU;
    /* 元空间的大小 */
    private String MC;
    /* 元空间的使用大小 */
    private String MU;
    /* 压缩类空间的大小 */
    private String CCSC;
    /* 压缩类空间的使用大小 */
    private String CCSU;
    /* 年轻代垃圾回收次数 */
    private String YGC;
    /* 年轻代垃圾回收消耗时间 */
    private String YGCT;
    /* 老年代垃圾回收次数 */
    private String FGC;
    /* 老年代垃圾回收消耗时间 */
    private String FGCT;
    /* 垃圾回收总消耗时间 */
    private String GCT;

}

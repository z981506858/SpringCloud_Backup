package com.zz.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *  实体对象
 */
@Data
@AllArgsConstructor // 全参
@NoArgsConstructor // 空参
public class Payment implements Serializable {
    private Long id;
    private String serial;
}

package com.demo.eureka.eurekaconsumer.entity;

import lombok.*;

/**
 * copyright (C), 2021, Altaria Studio
 *
 * @author Sancho
 * @version 1.0.0
 * <author>                <time>                  <version>                   <description>
 * Sancho                  2021/5/24 10:25
 * @program eureka-consumer
 * @description
 * @create 2021/5/24 10:25
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {

    private String name;

    private String id;
}
package com.muy.system.datasource.annotation;

/**
 * 多数据库枚举.
 *
 * @author by yanglikai on 17/9/5.
 */
public enum DbMsEnum {
  MASTER("masterDs"),     // 用户库
  SLAVE("slaveDs"); // 共通库

  private final String key;

  public String get() {
    return this.key;
  }

  DbMsEnum(String key) {
    this.key = key;
  }
}

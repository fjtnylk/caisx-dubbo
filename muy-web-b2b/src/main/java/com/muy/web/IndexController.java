package com.muy.web;

import com.muy.consumer.IndexService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2017/10/12.
 */
@RestController
public class IndexController {
  @Resource
  private IndexService indexService;

  @GetMapping(value = "/hello")
  public String hello() {
    return indexService.toMessage();
  }

  @GetMapping(value = "/dtl")
  public String loadDtl() {
    return indexService.toDtl();
  }

  @GetMapping(value = "/dtl2")
  public String loadDtl2() {
    return "yanglikai";
  }
}

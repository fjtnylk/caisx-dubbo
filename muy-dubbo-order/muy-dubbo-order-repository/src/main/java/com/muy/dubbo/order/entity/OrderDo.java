package com.muy.dubbo.order.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yanglikai on 2017/10/13.
 */
@TableName(value = "jshop_orderform")
public class OrderDo implements Serializable {
  @TableId
  private Long id;
  @TableField
  private Long userId;
  @TableField
  private String userName;
  @TableField
  private Integer orderStatus;
  @TableField
  private Integer orderGoodsCount;
  @TableField(value = "totalPrice")
  private BigDecimal totalPrice;
  @TableField(value = "addTime")
  private Date addTime;
  @TableField
  private String receiverName;
  @TableField
  private String receiverArea;
  @TableField
  private String receiverAreaInfo;
  @TableField
  private String receiverMobile;
  @TableField
  private String deliveryTime;
  @TableField
  private String userOrderType;
  @TableField
  private String msg;
  @TableField
  private String userContractNo;
  @TableField
  private Integer orderMain;
  @TableField
  private Integer bussinessType;
  @TableField
  private Long evaUserId;
  @TableField
  private String orderId;
  @TableField
  private String orderType;
  @TableField
  private String contractStoreNo;
  @TableField
  private String targetStoreNo;
  @TableField
  private String childOrderDetail;
  @TableField
  private Long parentId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Integer getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(Integer orderStatus) {
    this.orderStatus = orderStatus;
  }

  public Integer getOrderGoodsCount() {
    return orderGoodsCount;
  }

  public void setOrderGoodsCount(Integer orderGoodsCount) {
    this.orderGoodsCount = orderGoodsCount;
  }

  public BigDecimal getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
  }

  public Date getAddTime() {
    return addTime;
  }

  public void setAddTime(Date addTime) {
    this.addTime = addTime;
  }

  public String getReceiverName() {
    return receiverName;
  }

  public void setReceiverName(String receiverName) {
    this.receiverName = receiverName;
  }

  public String getReceiverArea() {
    return receiverArea;
  }

  public void setReceiverArea(String receiverArea) {
    this.receiverArea = receiverArea;
  }

  public String getReceiverAreaInfo() {
    return receiverAreaInfo;
  }

  public void setReceiverAreaInfo(String receiverAreaInfo) {
    this.receiverAreaInfo = receiverAreaInfo;
  }

  public String getReceiverMobile() {
    return receiverMobile;
  }

  public void setReceiverMobile(String receiverMobile) {
    this.receiverMobile = receiverMobile;
  }

  public String getDeliveryTime() {
    return deliveryTime;
  }

  public void setDeliveryTime(String deliveryTime) {
    this.deliveryTime = deliveryTime;
  }

  public String getUserOrderType() {
    return userOrderType;
  }

  public void setUserOrderType(String userOrderType) {
    this.userOrderType = userOrderType;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getUserContractNo() {
    return userContractNo;
  }

  public void setUserContractNo(String userContractNo) {
    this.userContractNo = userContractNo;
  }

  public Integer getOrderMain() {
    return orderMain;
  }

  public void setOrderMain(Integer orderMain) {
    this.orderMain = orderMain;
  }

  public Integer getBussinessType() {
    return bussinessType;
  }

  public void setBussinessType(Integer bussinessType) {
    this.bussinessType = bussinessType;
  }

  public Long getEvaUserId() {
    return evaUserId;
  }

  public void setEvaUserId(Long evaUserId) {
    this.evaUserId = evaUserId;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  public String getContractStoreNo() {
    return contractStoreNo;
  }

  public void setContractStoreNo(String contractStoreNo) {
    this.contractStoreNo = contractStoreNo;
  }

  public String getTargetStoreNo() {
    return targetStoreNo;
  }

  public void setTargetStoreNo(String targetStoreNo) {
    this.targetStoreNo = targetStoreNo;
  }

  public String getChildOrderDetail() {
    return childOrderDetail;
  }

  public void setChildOrderDetail(String childOrderDetail) {
    this.childOrderDetail = childOrderDetail;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }
}

/**
 * 
 */
package org.apache.camel.hotwaxCommerce.dataObject;

import java.util.ArrayList;


public class Items {
	 private String productId;
	 private String hsnCode;
	 private String orderId;
	 private String externalOrderId;
	 private String orderItemSeqId;
	 private String shipmentId;
	 private String externalShipmentId;
	 private String shipmentItemSeqId;
	 private String sku;
	 private String itemSeqId;
	 private String type;
	 private float quantity;
	 private float amount;
	 ArrayList < ItemAdjustments > itemAdjustments = new ArrayList < ItemAdjustments > ();


	 // Getter Methods 

	 public String getProductId() {
	  return productId;
	 }

	 public String getOrderId() {
	  return orderId;
	 }

	 public String getExternalOrderId() {
	  return externalOrderId;
	 }

	 public String getOrderItemSeqId() {
	  return orderItemSeqId;
	 }

	 public String getShipmentId() {
	  return shipmentId;
	 }

	 public String getExternalShipmentId() {
	  return externalShipmentId;
	 }

	 public String getShipmentItemSeqId() {
	  return shipmentItemSeqId;
	 }

	 public String getSku() {
	  return sku;
	 }

	 public String getItemSeqId() {
	  return itemSeqId;
	 }

	 public String getType() {
	  return type;
	 }

	 public float getQuantity() {
	  return quantity;
	 }

	 public float getAmount() {
	  return amount;
	 }

	 // Setter Methods 

	 public void setProductId(String productId) {
	  this.productId = productId;
	 }

	 public void setOrderId(String orderId) {
	  this.orderId = orderId;
	 }

	 public void setExternalOrderId(String externalOrderId) {
	  this.externalOrderId = externalOrderId;
	 }

	 public void setOrderItemSeqId(String orderItemSeqId) {
	  this.orderItemSeqId = orderItemSeqId;
	 }

	 public void setShipmentId(String shipmentId) {
	  this.shipmentId = shipmentId;
	 }

	 public void setExternalShipmentId(String externalShipmentId) {
	  this.externalShipmentId = externalShipmentId;
	 }

	 public void setShipmentItemSeqId(String shipmentItemSeqId) {
	  this.shipmentItemSeqId = shipmentItemSeqId;
	 }

	 public void setSku(String sku) {
	  this.sku = sku;
	 }

	 public void setItemSeqId(String itemSeqId) {
	  this.itemSeqId = itemSeqId;
	 }

	 public void setType(String type) {
	  this.type = type;
	 }

	 public void setQuantity(float quantity) {
	  this.quantity = quantity;
	 }

	 public void setAmount(float amount) {
	  this.amount = amount;
	 }

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public ArrayList<ItemAdjustments> getItemAdjustments() {
		return itemAdjustments;
	}

	public void setItemAdjustments(ArrayList<ItemAdjustments> itemAdjustments) {
		this.itemAdjustments = itemAdjustments;
	}

	@Override
	public String toString() {
		return "Items [productId=" + productId + ", hsnCode=" + hsnCode + ", orderId=" + orderId + ", externalOrderId="
				+ externalOrderId + ", orderItemSeqId=" + orderItemSeqId + ", shipmentId=" + shipmentId
				+ ", externalShipmentId=" + externalShipmentId + ", shipmentItemSeqId=" + shipmentItemSeqId + ", sku="
				+ sku + ", itemSeqId=" + itemSeqId + ", type=" + type + ", quantity=" + quantity + ", amount=" + amount
				+ ", itemAdjustments=" + itemAdjustments + "]";
	}

	
	 
}

package com.lfksc.api.model;

public class HomeScrollImageModel {
	//滚动图片的地址
	private String imageUrl;
	//跳转的网页地址
	private String targetUrl;
	//店铺ID
	private Long shopId;
	//商品ID
	private Long goodsId;
	
	public HomeScrollImageModel() {
		super();
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	
}

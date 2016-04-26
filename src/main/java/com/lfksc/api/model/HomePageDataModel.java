package com.lfksc.api.model;

public class HomePageDataModel {
	//标题
	private String title;
	//简介
	private String content;
	//标签
	private String label;
	//促销类型
	private Integer promotionType;
	//展示的图片
	private String imageUrl;
	//店铺ID
	private Long shopId;
	//商品ID
	private Long goodsId;
	//商品分类ID
	private Long goodsPropertyId;

	public HomePageDataModel() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(Integer promotionType) {
		this.promotionType = promotionType;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public Long getGoodsPropertyId() {
		return goodsPropertyId;
	}

	public void setGoodsPropertyId(Long goodsPropertyId) {
		this.goodsPropertyId = goodsPropertyId;
	}
	
}

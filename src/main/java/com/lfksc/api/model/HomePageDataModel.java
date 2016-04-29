package com.lfksc.api.model;

import java.util.List;

public class HomePageDataModel {
	//优质商家
	private List<HomePageDataItemModel> shops;
	//热门分类
	private List<HomePageDataItemModel> property;
	//热销商品
	private List<HomePageDataItemModel> goods;

	public HomePageDataModel() {
		super();
	}

	public List<HomePageDataItemModel> getShops() {
		return shops;
	}

	public void setShops(List<HomePageDataItemModel> shops) {
		this.shops = shops;
	}

	public List<HomePageDataItemModel> getProperty() {
		return property;
	}

	public void setProperty(List<HomePageDataItemModel> property) {
		this.property = property;
	}

	public List<HomePageDataItemModel> getGoods() {
		return goods;
	}

	public void setGoods(List<HomePageDataItemModel> goods) {
		this.goods = goods;
	}


}

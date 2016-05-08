package com.lfksc.api.service;

import java.util.List;

import com.lfksc.api.model.FirstSortsModel;
import com.lfksc.api.model.ResponseModel;
import com.lfksc.api.model.SecondSortsModel;

public interface IGoodsService {

	/**
	 * 获取商品一级分类（底部菜单分类中的商品分类）
	 */
	public ResponseModel<List<FirstSortsModel>> getFirstSorts();
	
	/**
	 * 根据商品一级分类，获取分类下信息
	 */
	public ResponseModel<SecondSortsModel> getSecondSorts();
	
}

package com.lfksc.api.service;

import java.util.List;

import com.lfksc.api.model.HomePageDataModel;
import com.lfksc.api.model.HomeScrollImageModel;
import com.lfksc.api.model.ResponseModel;

/**
 * 未归类的接口
 * @author huguangwen
 *
 */
public interface ICommonService {
	
	/**
	 * 获取首页滚动图片
	 */
	public ResponseModel<List<HomeScrollImageModel>> getHomeScrollImages();
	
	/**
	 * 获取首页数据
	 */
	public ResponseModel<List<HomePageDataModel>> getHomePageDatas();
}

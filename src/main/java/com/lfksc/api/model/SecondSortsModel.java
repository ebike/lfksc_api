package com.lfksc.api.model;

import java.util.List;

public class SecondSortsModel {

	//重要分类（最上面的图片）
	private SortsInfoModel importSorts;
	//常见分类
	private List<SortsInfoModel> commonSorts;
	//热门分类
	private List<SortsInfoModel> hotSorts;
	
	public SecondSortsModel() {
		super();
	}

	public SortsInfoModel getImportSorts() {
		return importSorts;
	}

	public void setImportSorts(SortsInfoModel importSorts) {
		this.importSorts = importSorts;
	}

	public List<SortsInfoModel> getCommonSorts() {
		return commonSorts;
	}

	public void setCommonSorts(List<SortsInfoModel> commonSorts) {
		this.commonSorts = commonSorts;
	}

	public List<SortsInfoModel> getHotSorts() {
		return hotSorts;
	}

	public void setHotSorts(List<SortsInfoModel> hotSorts) {
		this.hotSorts = hotSorts;
	}
	
}

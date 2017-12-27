package com.whv.doc.taglibs;


import javax.servlet.jsp.tagext.TagSupport;

import com.whv.doc.utils.convert.ResponseUtils;

import net.sf.json.JSONObject;
/**
 * FlexPaper标签
 * @author huawei
 *
 */
public class FlexPaper extends TagSupport {
	public FlexPaper() {
		super();
		clearData();
	}
	@Override
	public int doStartTag() throws javax.servlet.jsp.JspException
	{

		return super.doStartTag();
	};

	@Override
	public int doEndTag() throws javax.servlet.jsp.JspException
	{
		release();
		return super.doEndTag();
	};

	@Override
	public int doAfterBody() throws javax.servlet.jsp.JspException
	{
		rend();
		return super.doAfterBody();
	};

	@Override
	public void release()
	{
		super.release();
		clearData();
	}
	private void rend() {
		StringBuffer results = new StringBuffer();
		results.append(" <a id=\""+getElementId()+"\" style=\""+getStyle()+"\"></a>");
		results.append("<script type=\"text/javascript\">\n");
		results.append("var fpview = new FlexPaperViewerEmbedding(\"")
			.append(getElementId())
			.append("\",{\"config\":").append(getConfigJson().toString()).append("});");
		results.append("</script>\n");
		ResponseUtils.write(pageContext, results.toString());
		
	}
	private static final long serialVersionUID = -2113952585050207387L;
	private JSONObject conf;
	private String style;
	public JSONObject getConf() {
		return conf;
	}
	public void setConf(JSONObject conf) {
		this.conf = conf;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	private String ElementId;
	private String SwfFile;
	private String PdfFile;
	private String IMGFiles;
	private String JSONFile;
	private String useCustomJSONFormat;
	private String JSONPageDataFormat;
	private String JSONDataType;
	private Double Scale;
	private String ZoomTransition;
	private Double ZoomTime;
	private Double ZoomInterval;
	private Boolean FitPageOnLoad;
	private Boolean FitWidthOnLoad;
	private Boolean FullScreenAsMaxWindow;
	private Boolean ProgressiveLoading;
	private Double MinZoomSize;
	private Double MaxZoomSize;
	private Boolean SearchMatchAll;
	private String SearchServiceUrl;
	private String InitViewMode;
	private Boolean BitmapBasedRendering;
	private Integer StartAtPage;
	private Boolean PrintPaperAsBitmap;
	private Boolean AutoAdjustPrintSize;
	private Boolean EnableCornerDragging;
	private String BackgroundColor;
	private String PanelColor;
	private String BackgroundAlpha;
	private String UIConfig;
	private Boolean ViewModeToolsVisible;
	private Boolean ZoomToolsVisible;
	private Boolean NavToolsVisible;
	private Boolean CursorToolsVisible;
	private Boolean SearchToolsVisible;
	private String StickyTools;
	private String Toolbar;
	private String DocSizeQueryService;

	private String RenderingOrder;

	private String localeChain;
	private String jsDirectory;
	private String cssDirectory;
	private String localeDirectory;
	private String key;
	public String getElementId() {
		return ElementId;
	}
	public void setElementId(String elementId) {
		ElementId = elementId;
	}
	public String getSwfFile() {
		return SwfFile;
	}
	public void setSwfFile(String swfFile) {
		SwfFile = swfFile;
	}
	public String getPdfFile() {
		return PdfFile;
	}
	public void setPdfFile(String pdfFile) {
		PdfFile = pdfFile;
	}
	public String getIMGFiles() {
		return IMGFiles;
	}
	public void setIMGFiles(String iMGFiles) {
		IMGFiles = iMGFiles;
	}
	public String getJSONFile() {
		return JSONFile;
	}
	public void setJSONFile(String jSONFile) {
		JSONFile = jSONFile;
	}
	public String getUseCustomJSONFormat() {
		return useCustomJSONFormat;
	}
	public void setUseCustomJSONFormat(String useCustomJSONFormat) {
		this.useCustomJSONFormat = useCustomJSONFormat;
	}
	public String getJSONPageDataFormat() {
		return JSONPageDataFormat;
	}
	public void setJSONPageDataFormat(String jSONPageDataFormat) {
		JSONPageDataFormat = jSONPageDataFormat;
	}
	public String getJSONDataType() {
		return JSONDataType;
	}
	public void setJSONDataType(String jSONDataType) {
		JSONDataType = jSONDataType;
	}
	public Double getScale() {
		return Scale;
	}
	public void setScale(Double scale) {
		Scale = scale;
	}
	public String getZoomTransition() {
		return ZoomTransition;
	}
	public void setZoomTransition(String zoomTransition) {
		ZoomTransition = zoomTransition;
	}
	public Double getZoomTime() {
		return ZoomTime;
	}
	public void setZoomTime(Double zoomTime) {
		ZoomTime = zoomTime;
	}
	public Double getZoomInterval() {
		return ZoomInterval;
	}
	public void setZoomInterval(Double zoomInterval) {
		ZoomInterval = zoomInterval;
	}
	public Boolean getFitPageOnLoad() {
		return FitPageOnLoad;
	}
	public void setFitPageOnLoad(Boolean fitPageOnLoad) {
		FitPageOnLoad = fitPageOnLoad;
	}
	public Boolean getFitWidthOnLoad() {
		return FitWidthOnLoad;
	}
	public void setFitWidthOnLoad(Boolean fitWidthOnLoad) {
		FitWidthOnLoad = fitWidthOnLoad;
	}
	public Boolean getFullScreenAsMaxWindow() {
		return FullScreenAsMaxWindow;
	}
	public void setFullScreenAsMaxWindow(Boolean fullScreenAsMaxWindow) {
		FullScreenAsMaxWindow = fullScreenAsMaxWindow;
	}
	public Boolean getProgressiveLoading() {
		return ProgressiveLoading;
	}
	public void setProgressiveLoading(Boolean progressiveLoading) {
		ProgressiveLoading = progressiveLoading;
	}
	public Double getMinZoomSize() {
		return MinZoomSize;
	}
	public void setMinZoomSize(Double minZoomSize) {
		MinZoomSize = minZoomSize;
	}
	public Double getMaxZoomSize() {
		return MaxZoomSize;
	}
	public void setMaxZoomSize(Double maxZoomSize) {
		MaxZoomSize = maxZoomSize;
	}
	public Boolean getSearchMatchAll() {
		return SearchMatchAll;
	}
	public void setSearchMatchAll(Boolean searchMatchAll) {
		SearchMatchAll = searchMatchAll;
	}
	public String getSearchServiceUrl() {
		return SearchServiceUrl;
	}
	public void setSearchServiceUrl(String searchServiceUrl) {
		SearchServiceUrl = searchServiceUrl;
	}
	public String getInitViewMode() {
		return InitViewMode;
	}
	public void setInitViewMode(String initViewMode) {
		InitViewMode = initViewMode;
	}
	public Boolean getBitmapBasedRendering() {
		return BitmapBasedRendering;
	}
	public void setBitmapBasedRendering(Boolean bitmapBasedRendering) {
		BitmapBasedRendering = bitmapBasedRendering;
	}
	public Integer getStartAtPage() {
		return StartAtPage;
	}
	public void setStartAtPage(Integer startAtPage) {
		StartAtPage = startAtPage;
	}
	public Boolean getPrintPaperAsBitmap() {
		return PrintPaperAsBitmap;
	}
	public void setPrintPaperAsBitmap(Boolean printPaperAsBitmap) {
		PrintPaperAsBitmap = printPaperAsBitmap;
	}
	public Boolean getAutoAdjustPrintSize() {
		return AutoAdjustPrintSize;
	}
	public void setAutoAdjustPrintSize(Boolean autoAdjustPrintSize) {
		AutoAdjustPrintSize = autoAdjustPrintSize;
	}
	public Boolean getEnableCornerDragging() {
		return EnableCornerDragging;
	}
	public void setEnableCornerDragging(Boolean enableCornerDragging) {
		EnableCornerDragging = enableCornerDragging;
	}
	public String getBackgroundColor() {
		return BackgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		BackgroundColor = backgroundColor;
	}
	public String getPanelColor() {
		return PanelColor;
	}
	public void setPanelColor(String panelColor) {
		PanelColor = panelColor;
	}
	public String getBackgroundAlpha() {
		return BackgroundAlpha;
	}
	public void setBackgroundAlpha(String backgroundAlpha) {
		BackgroundAlpha = backgroundAlpha;
	}
	public String getUIConfig() {
		return UIConfig;
	}
	public void setUIConfig(String uIConfig) {
		UIConfig = uIConfig;
	}
	public Boolean getViewModeToolsVisible() {
		return ViewModeToolsVisible;
	}
	public void setViewModeToolsVisible(Boolean viewModeToolsVisible) {
		ViewModeToolsVisible = viewModeToolsVisible;
	}
	public Boolean getZoomToolsVisible() {
		return ZoomToolsVisible;
	}
	public void setZoomToolsVisible(Boolean zoomToolsVisible) {
		ZoomToolsVisible = zoomToolsVisible;
	}
	public Boolean getNavToolsVisible() {
		return NavToolsVisible;
	}
	public void setNavToolsVisible(Boolean navToolsVisible) {
		NavToolsVisible = navToolsVisible;
	}
	public Boolean getCursorToolsVisible() {
		return CursorToolsVisible;
	}
	public void setCursorToolsVisible(Boolean cursorToolsVisible) {
		CursorToolsVisible = cursorToolsVisible;
	}
	public Boolean getSearchToolsVisible() {
		return SearchToolsVisible;
	}
	public void setSearchToolsVisible(Boolean searchToolsVisible) {
		SearchToolsVisible = searchToolsVisible;
	}
	public String getStickyTools() {
		return StickyTools;
	}
	public void setStickyTools(String stickyTools) {
		StickyTools = stickyTools;
	}
	public String getToolbar() {
		return Toolbar;
	}
	public void setToolbar(String toolbar) {
		Toolbar = toolbar;
	}
	public String getDocSizeQueryService() {
		return DocSizeQueryService;
	}
	public void setDocSizeQueryService(String docSizeQueryService) {
		DocSizeQueryService = docSizeQueryService;
	}
	public String getRenderingOrder() {
		return RenderingOrder;
	}
	public void setRenderingOrder(String renderingOrder) {
		RenderingOrder = renderingOrder;
	}
	public String getLocaleChain() {
		return localeChain;
	}
	public void setLocaleChain(String localeChain) {
		this.localeChain = localeChain;
	}
	public String getJsDirectory() {
		return jsDirectory;
	}
	public void setJsDirectory(String jsDirectory) {
		this.jsDirectory = jsDirectory;
	}
	public String getCssDirectory() {
		return cssDirectory;
	}
	public void setCssDirectory(String cssDirectory) {
		this.cssDirectory = cssDirectory;
	}
	public String getLocaleDirectory() {
		return localeDirectory;
	}
	public void setLocaleDirectory(String localeDirectory) {
		this.localeDirectory = localeDirectory;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * 获取flexpaper的config的json对象
	 * @return
	 */
	public JSONObject getConfigJson() {
		JSONObject jo = new JSONObject();
		if(getConf() != null) {
			jo.putAll(getConf());
		}
		jo.put("ElementId",getElementId());
		jo.put("SwfFile",getSwfFile());
		jo.put("PdfFile",getPdfFile());
		jo.put("IMGFiles",getIMGFiles());
		jo.put("JSONFile",getJSONFile());
		jo.put("useCustomJSONFormat",getUseCustomJSONFormat());
		jo.put("JSONPageDataFormat",getJSONPageDataFormat());
		jo.put("JSONDataType",getJSONDataType());
		jo.put("Scale",getScale());
		jo.put("ZoomTransition",getZoomTransition());
		jo.put("ZoomTime",getZoomTime());
		jo.put("ZoomInterval",getZoomInterval());
		jo.put("FitPageOnLoad",getFitPageOnLoad());
		jo.put("FitWidthOnLoad",getFitWidthOnLoad());
		jo.put("FullScreenAsMaxWindow",getFullScreenAsMaxWindow());
		jo.put("ProgressiveLoading",getProgressiveLoading());
		jo.put("MinZoomSize",getMinZoomSize());
		jo.put("MaxZoomSize",getMaxZoomSize());
		jo.put("SearchMatchAll",getSearchMatchAll());
		jo.put("SearchServiceUrl",getSearchServiceUrl());
		jo.put("InitViewMode",getInitViewMode());
		jo.put("BitmapBasedRendering",getBitmapBasedRendering());
		jo.put("StartAtPage",getStartAtPage());
		jo.put("PrintPaperAsBitmap",getPrintPaperAsBitmap());
		jo.put("AutoAdjustPrintSize",getAutoAdjustPrintSize());
		jo.put("EnableCornerDragging",getEnableCornerDragging());
		jo.put("BackgroundColor",getBackgroundColor());
		jo.put("PanelColor",getPanelColor());
		jo.put("BackgroundAlpha",getBackgroundAlpha());
		jo.put("UIConfig",getUIConfig());
		jo.put("ViewModeToolsVisible",getViewModeToolsVisible());
		jo.put("ZoomToolsVisible",getZoomToolsVisible());
		jo.put("NavToolsVisible",getNavToolsVisible());
		jo.put("CursorToolsVisible",getCursorToolsVisible());
		jo.put("SearchToolsVisible",getSearchToolsVisible());
		jo.put("StickyTools",getStickyTools());
		jo.put("Toolbar",getToolbar());
		jo.put("DocSizeQueryService",getDocSizeQueryService());
		jo.put("RenderingOrder",getRenderingOrder());
		jo.put("localeChain",getLocaleChain());
		jo.put("jsDirectory",getJsDirectory());
		jo.put("cssDirectory",getCssDirectory());
		jo.put("localeDirectory",getLocaleDirectory());
		jo.put("key",getKey());
		return jo;
	}
	
	private void clearData() {
		ElementId= null;
		SwfFile= null;
		PdfFile= null;
		IMGFiles= null;
		JSONFile= null;
		useCustomJSONFormat= null;
		JSONPageDataFormat= null;
		JSONDataType= null;
		Scale= null;
		ZoomTransition= null;
		ZoomTime= null;
		ZoomInterval= null;
		FitPageOnLoad= null;
		FitWidthOnLoad= null;
		FullScreenAsMaxWindow= null;
		ProgressiveLoading= null;
		MinZoomSize= null;
		MaxZoomSize= null;
		SearchMatchAll= null;
		SearchServiceUrl= null;
		InitViewMode= null;
		BitmapBasedRendering= null;
		StartAtPage= null;
		PrintPaperAsBitmap= null;
		AutoAdjustPrintSize= null;
		EnableCornerDragging= null;
		BackgroundColor= null;
		PanelColor= null;
		BackgroundAlpha= null;
		UIConfig= null;
		ViewModeToolsVisible= null;
		ZoomToolsVisible= null;
		NavToolsVisible= null;
		CursorToolsVisible= null;
		SearchToolsVisible= null;
		StickyTools= null;
		Toolbar= null;
		DocSizeQueryService= null;
		RenderingOrder= null;
		localeChain= null;
		jsDirectory= null;
		cssDirectory= null;
		localeDirectory= null;
		key= null;
		conf = null;
		style = null;
	}
}

package com.lepeng.admin.web.tags;
import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Throwables;
import com.lepeng.admin.web.domain.PageBean;


public class PageNavigatorTag extends BodyTagSupport {
    
	private static final long serialVersionUID = -5033165462116527351L;

	private static final Logger log = LoggerFactory.getLogger(PageNavigatorTag.class);
    
	private PageBean<?> pageBean; 		
	private String align = "center";
	private String showPageNum = "10";
	/** 路径 */
	private String url = "";
	/** 是否是模态窗口 */
	private boolean modal = false;
	/** 方法名 */
	private String functionName = "";

    public int doEndTag() {
		JspWriter out = pageContext.getOut();
    	if (pageBean == null || pageBean.getPageCount() < 1) {
    		try {
    			if (pageBean == null || pageBean.getPageCount() == 0) {
    				out.println("没有数据");
    			} else {
    				out.print("");
    			}
    		} catch (IOException ex) {
    			log.error(Throwables.getStackTraceAsString(ex));
    			Throwables.propagate(ex);
    		}
    		return EVAL_BODY_INCLUDE;
    	}
    	String urlPath = "";
    	StringBuffer buffer = new StringBuffer();
		buffer.append("<div class=\"pull-right\"><ul class=\"pagination\">");
		
		//显示出上一页
		if(pageBean.getPageNo()<=1){
			buffer.append("<li class=\"pre disabled\"><a href=\"#\">上一页</a></li>");
		}else{
			buffer.append("<li class=\"pre\">");
			if(!modal){
				urlPath = url.contains("?") ? url + "&pageNo=" : "?pageNo=";
				buffer.append("<a href=\""+urlPath+(pageBean.getPageNo()-1)+"\">上一页</a></li>");
			}else{
				buffer.append("<a href=\"#\" onclick=\"" + functionName + "('"+(pageBean.getPageNo()-1)+"');\">上一页</a></li>");
			}
		}
		
		//保证在总页码数大于10的情况下，页面上有10个标签页
		int showNum = Integer.parseInt(showPageNum); 
		
		int a = (showNum - 1)/2;
		pageBean.setStartPage(pageBean.getPageNo() > a ? pageBean.getPageNo() - a : 1);
		pageBean.setEndPage((pageBean.getPageCount() > pageBean.getStartPage() + (showNum - 1)) ? pageBean.getStartPage() + (showNum - 1) : pageBean.getPageCount().intValue());
		
		//打印可选择的页码信息
		for (int i = pageBean.getStartPage(); i <= pageBean.getEndPage(); i++) {
			if (i == pageBean.getPageNo()) {
				buffer.append("<li class=\"active\"><span>" + i + "</span></li>");
				continue;
			} else {
				if(!modal){
					urlPath = url.contains("?") ? url + "&pageNo=" : "?pageNo=";
					buffer.append("<li><a href=\"" + urlPath + i + "\">" + i + "</a></li>");
				}else{
					buffer.append("<li><a href=\"#\" onclick=\"" + functionName + "('" + i + "');\">" + i + "</a></li>");
				}
			}
		}

		//显示出下一页
		if(pageBean.getPageNo()>=pageBean.getPageCount()){
			buffer.append("<li class=\"next disabled\"><a href=\"#\">下一页</a></li>");
		}else{
			buffer.append("<li class=\"next\">");
			if(!modal){
				urlPath = url.contains("?") ? url + "&pageNo=" : "?pageNo=";
				buffer.append("<a href=\"" + urlPath + (pageBean.getPageNo() + 1) + "\">下一页</a></li>");
			}else{
				buffer.append("<a href=\"#\" onclick=\"" + functionName + "('" + (pageBean.getPageNo() + 1) + "');\">下一页</a></li>");
			}
		}
//		buffer.append("<li class='next'>&nbsp;&nbsp;&nbsp;<select><option>10</option><option>10</option></select></li>");
		buffer.append("</ul></div>");
		//打印查询总数和总页码
//		buffer.append("共"
//				+ (pageBean.getTotal() / pageBean.getPageSize() 
//				+ (pageBean.getTotal() % pageBean.getPageSize() == 0 ? 0 : 1)) + "页</td>&nbsp;&nbsp;&nbsp;&nbsp;");
//		buffer.append("　转到第<input class=\"num\" type=\"text\" />页　<button onclick=\"" + optMethod + "($(this).prev().val(),"+pageBean.getPageCount()+")\">go</button>");
//		buffer.append("</div>");

		try {
			out.print(buffer.toString());
		} catch (IOException ex) {
			log.error(Throwables.getStackTraceAsString(ex));
			Throwables.propagate(ex);
		}
		return EVAL_BODY_INCLUDE;
    }

	public void setPageBean(PageBean<?> pageBean) {
		this.pageBean = pageBean;
	}

	public PageBean<?> getPageBean() {
		return pageBean;
	}
	public void setAlign(String align) {
		this.align = align;
	}
	public String getAlign() {
		return align;
	}
	public void setShowPageNum(String showPageNum) {
		this.showPageNum = showPageNum;
	}
	public String getShowPageNum() {
		return showPageNum;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public boolean isModal() {
		return modal;
	}

	public void setModal(boolean modal) {
		this.modal = modal;
	}
	
	
}
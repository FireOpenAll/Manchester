package com.galaxy.front.web.model.page;
/*author:huangshanqi
 *time  :2014年11月17日 下午11:39:05
 *email :hsqmobile@gmail.com
 */
public interface InterPage<T> {

	boolean hasNext();
	boolean hasPrev();
	boolean isFirstPage();
	boolean isLastPage();
	boolean isEmpty();
	int getTotalPageNum();
	

}

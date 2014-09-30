/*
 * author:zyc
 * time:2014年6月20日
 * 功能：公用ajax 分页
 */
function ajaxPage(page,b){
	var js=b.js; var total=b.total;
	var pagesize=b.pagesize; var pagelen=b.pagelen;
    if (page > 99){
        pagelen = 5;
    }  
    pagecode = '';
    page = parseInt(page);
    total = parseInt(total);
    if (!total){
      return false;	
    }
    var  pages = Math.ceil(total / pagesize);
    if (page < 1)
        page = 1;
    if (page > pages)
        page = pages;
    offset = pagesize * (page - 1);
   var init = 1;
   var max = pages;
   var pagelen = (pagelen % 2) ? pagelen : pagelen + 1;
   var pageoffset = (pagelen - 1) / 2;
     b=$.toJSON(b);
    // 生成html
    var pagecode = "<dl>";
    if (page != 1) {
        pagecode+="<dt><a href='javascript:void(0)' onclick='"+js+"(1,"+b+")'>首页</a></dt>";
        pagecode+="<dt><a href='javascript:void(0)' onclick='"+js+"("+(page-1)+","+b+")'>上一页</a></dt>";
    }
    if (pages > pagelen) {
        if (page <= pageoffset) {
            init = 1;
            max = pagelen;
        } else {
            if (page + pageoffset >= pages + 1) {
                init = pages - pagelen + 1;
            } else {
                init = page - pageoffset;
                max = page + pageoffset;
            }
        }
    }
    // 生成html
    for ( var i = init; i <= max; i++) {
        if (i == page) {
            pagecode+="<dd><a href='javascript:void(0)' class='choose'>"+i+"</a></dd>";
        } else {
            pagecode+="<dd><a href='javascript:void(0)' onclick='"+js+"("+i+","+b+")'>"+i+"</a></dd>";
        }
    }

    if (page != pages) {
        pagecode+="<dt><a href='javascript:void(0)' onclick='"+js+"("+(page+1)+","+b+")'>下一页</a></dt>";
        pagecode+="<dt><a href='javascript:void(0)' onclick='"+js+"("+pages+","+b+")'>尾页</a></dt>";
    }
    pagecode += "<dt><span>共"+pages+"页</span></dt>";
    pagecode+="</dl>";
    return pagecode;
	
}

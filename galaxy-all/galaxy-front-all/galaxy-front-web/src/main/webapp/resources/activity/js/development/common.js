function clareError ()
{
    var pareUl = $(this).parents("ul");
    pareUl.removeClass('error');
    pareUl.children("li[class=tips]").last().html("");
    return true;
};

// 添加错误提示
function showError (that,msg) 
{
    //$("#jsSub").attr("disable","");
    var ulObj = that.parents("ul");
    var cueMsg = '<span class="icon"></span>' + msg;
    //ulObj.attr('oldClass',oldClass).addClass(oldClass + ' error');
    ulObj.addClass(' error');
    ulObj.children("li[class=tips]").last().html(cueMsg);
    //console.log(ulObj.children("li").last());
    //that.focus().one('focusout', clareError);
    var tagN = that.get(0).tagName;
    if (tagN == 'INPUT' || tagN == 'TEXTAREA') {
        that.one('focus', clareError);
    } else {
        that.one('click', clareError);
    }
    var topval = that.offset().top;
    $("body").animate({ 'scrollTop':(topval - 200) },400);
    
    return true;
}
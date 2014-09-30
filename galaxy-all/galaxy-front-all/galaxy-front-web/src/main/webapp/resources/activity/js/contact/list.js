var groupInfoStarus=false;
$(function (){
    getList ();
});
function getList ()
{
    var url = js_huodongshu_domain+"/contact/contactlist.do";
    var search = $("#jsSearchCode").val();
    $.post(url,{'search':search,'page':1,'count':30},function (json) {
        if (json.status == '1') {
            // 分组信息
            var groupL = json.data.group_list, Ghtml='';
            if (groupL.length == 0) {groupInfoStarus = true;}
            for(var i =0 ;i < groupL.length ; ++i){
                Ghtml += '<span><input type="checkbox" name="groupname" value="'+groupL[i]['id']+'" id="jsGroup'+groupL[i]['id']+'" />'+groupL[i]['name']+'</span>';
            }
            $("#groupList").html(Ghtml);
            var data = json.data.list, html='';
            if (data.length == 0) {
                $("#contactList").html('<tr><td colspan="5">暂无信息~~</td></tr>');
                return false;
            }
            for(var i =0 ;i < data.length ; ++i){
                data[i]['num'] = (i + 1);
                html += spliceHtml(data[i]);
            }
            $("#contactList").html(html);
            //showTips();
            $(".showGroup").hover(function () {
                $(this).attr("style","height: auto;");
            },function () {
                $(this).attr("style","");
            });
            UIdialog();
        } else {
            $("#contactList").html('<tr><td colspan="5">'+json.msg+'~</td></tr>');
        }
    }, 'json');
}


// 添加文件
function addContactDialog(dialog,closeDialog){
    //点击保存按钮
    dialog.find(".dialogSave a.saveBtn").unbind("click").click(function(){
        if ($(this).attr("disable") == "yes") { alert('正在保存中~');return false; }
        $(this).attr("disable","yes");
        var id = $("#contactId").val();
        var groupIdsOld = $("#groupIdsOld").val();
        var name = $("#jsName").val();
        if (name == '') { showError($("#jsName"), '姓名不能为空~'); return false;}
        if (fontNum(name) > 10) {showError($("#jsName"), '姓名超出了十个字了~'); return false;}
        var email = $("#jsEmail").val();
        if (email == '') { showError($("#jsEmail"), 'Email不能为空~'); return false;}
        var phone = $("#jsPhone").val();
        if (phone == '') { showError($("#jsPhone"), '电话不能为空~'); return false;}
        var company = $("#jsCompany").val();
        //if (company == '') { showError($("#jsCompany"), '公司名称不能为空~'); return false;}
        if (fontNum(company) > 30) {showError($("#jsCompany"), '公司名称超出了三十个字了~'); return false;}
        var job = $("#jsJob").val();
        //if (job == '') { showError($("#jsJob"), '职位不能为空~'); return false;}
        if (fontNum(job) > 20) {showError($("#jsJob"), '职位超出了二十个字了~'); return false;}
        var group_list = $("input[name=groupname]:checked");
        if(phone.length != 11) { showError($("#jsPhone"), '手机号码不正确');return; }
        if (!/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i.test(email)) {
             showError($("#jsEmail"), '邮箱格式不正确');return;
        }
        
        if (group_list.length == 0) { alert('请选择组信息~~');$("#jsSub").attr("disable","");return false; }
        var groupIds = '';
        group_list.each(function (){
            groupIds += $(this).val()+',';
        });
        var url = js_huodongshu_domain+"/contact/addcontact.do";
        $.post(url, {'id':id,'group_ids_old':groupIdsOld,'name':name,'group_ids':groupIds,'email':email,'telphone':phone,'job_title':job,'company':company,}, function (json) {
            if (json.status == '1') {
                getList ();
                closeDialog();
                $("#addContact input[type=text]").val("");
                $("input[name=groupname]").prop('checked',false);
                $("#jsSub").attr("disable","");
            } else {
                showError($("#js"+json.data+""), json.msg);
                $(this).attr("disable","");
            }
        }, 'json');
    });
    
    //点击关闭按钮
    dialog.find(".dialogClose,.Close").unbind("click").click(function(){
        $("input[type=text]").val("");
        $("input[name=groupname]").prop('checked',false);
        $(".account_addContacts > ul").removeClass("error");
        closeDialog();
    });
}

function delContact(contactId)
{
    if (contactId == 0) { return false;}
    if (!confirm('确定删除此联系人？')) { return false;}
    var url = js_huodongshu_domain+"/contact/delcontact.do";
    
    $.post(url, {'contact_id':contactId}, function (json) {
        if (json.status == '1') {
            $("#contactId"+contactId).slideUp(function () {
                $(this).remove();
            });
        } else {
            alert(json.msg);
        }
    },'json');
}
function spliceHtml (data) 
{
    var html = '';
    html +='<tr id="contactId'+data.id+'">\
        <td>'+data.name+'</td>\
        <td>'+data.email+'</td>\
        <td>'+data.telphone+'</td>';
        var ids = data.group_ids;
        if (ids.length >= 2) {
            html += '<td width="" class="more">\
                <span class="text showGroup"  style="">'+data.group_names+'</span>\
                </td>';
        } else {
            if (data.group_names == "") {data.group_names ="暂无分组";}
            html += '<td>'+data.group_names+'</td>';
        }
        
        html += '<td class="operate">\
            <a title="编辑" class="icon05" UIdialog="addContact" href="javascript:editContact({\'contact_id\':\''+data.id+'\',\'name\':\''+data.name+'\',\'email\':\''+data.email+'\',\'telphone\':\''+data.telphone+'\',\'job_title\':\''+data.job_title+'\',\'company\':\''+data.company+'\',\'group_ids_old\':\''+data.group_ids_old+'\',\'group_ids\':\''+data.group_ids+'\',});" data></a>\
            <a title="删除" class="icon04" href="javascript:delContact('+data.id+')"></a>\
        </td>\
    </tr>';
        
        return html;
}

function editContact(data)
{
    $("#contactId").val(data.contact_id);$("#jsName").val(data.name);$("#jsEmail").val(data.email);
    $("#jsPhone").val(data.telphone);$("#jsJob").val(data.job_title);$("#jsCompany").val(data.company);
    if (data.group_ids_old != '0'){ $("#groupIdsOld").val(data.group_ids_old); }
    var groupList = data.group_ids;
    var groupArr = groupList.split(',');
    if (groupArr.length >0) {
        for (var i=0;i<groupArr.length;i++) {
            $("input[name=groupname][value="+groupArr[i]+"]").prop("checked",true);
        }
    }
    return true;
}

function showTips() {
    var $root=$("table td.more");
    $root.each(function(){
        var $this=$(this);
        var tableInfo=$this.find("b").html();
        var $showInfoBar=$this.find("a.icon");
        var $showInfo=$('<div class="a"></div><div class="b"><div class="c"></div></div>');
        $showInfoBar.hover(
            function(){
                $showInfoBar.css({"z-index":1}).append($showInfo.clone());
                $this.find(".b").append(tableInfo);
                $(".a").css({"height":$(".b").outerHeight(),"width":$(".b").outerWidth()});
                $(".b").css({"marginLeft":$(".a").css("paddingLeft"),"marginTop":$(".a").css("paddingTop")});
            },
            function(){
                $showInfoBar.removeAttr("style");
                $(".a").remove();
                $(".b").empty().remove();
            }
        );
    });
}
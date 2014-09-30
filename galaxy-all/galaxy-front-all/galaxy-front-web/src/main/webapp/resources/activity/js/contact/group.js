
$(function () {
    getList ();
});

function getList ()
{
    var url = js_huodongshu_domain+"/contact/grouplist.do";
    $.post(url,{}, function (json) {
        if (json.status == '1') {
            var data = json.data, html ='';
            if (data.length == 0) {
                $("#groupList").html('<tr  ><td colspan="5">暂无信息~~</td></tr>');
                return false;
            }
            for(var i =0 ;i < data.length ; ++i){
                data[i]['num'] = (i + 1);
                html +=spliceHtml(data[i]);
            }
            $("#groupList").html(html);
            UIdialog();
        } else {
            $("#groupList").html('<tr  ><td colspan="5">'+json.msg+'~</td></tr>');
            //alert(json.msg);
        }
    }, 'json');
}

function editContact(groupId,groupName)
{
    console.log(groupId+'-'+groupName);
    $("#jsGroupId").val(groupId);
    $("#jsGroupName").val(groupName);
    return true;
}

function delContact(groupId, total)
{
    if (groupId == '') {alert("ID不能为空~");return false;}
    if (total == '0') {
        if (!confirm('确定要删除该组吗~')) { return false;}
    } else {
        if (!confirm('本组中有'+total+'个联系人;确定要删除该组吗~')) { return false;}
    }
    var url = js_huodongshu_domain+"/contact/delgroup.do";
    
    $.post(url, {'group_id':groupId},function (json) {
        if (json.status == '1') {
            $("#groupId"+groupId).slideUp('1300',function () {
                $(this).remove();
            });
        } else {
            alert(json.msg);
        }
    }, 'json');
}

function addContactDialog(dialog,closeDialog){
    //点击保存按钮
    dialog.find(".dialogSave a.saveBtn").unbind("click").click(function(){
        var groupId = $("#jsGroupId").val();
        var groupName = $("#jsGroupName").val();
        if (groupName == ''){ ($("#jsGroupName"),'不能为空~');}
        if (fontNum(groupName) > 10) {
            showError($("#jsGroupName"),'组名不得超过10个字~');
            return false;}
        var url = js_huodongshu_domain+"/contact/addgroup.do";
        $.post(url, {'group_id':groupId,'name':groupName}, function (json) {
            if (json.status == '1') {
                closeDialog();
                getList ();
                $("#jsGroupId").val("");
                $("#jsGroupName").val("");
            } else {
                alert(json.msg);
            }
        }, 'json');
        
    });
    
    //点击关闭按钮
    dialog.find(".Close").unbind("click").click(function(){ $("#jsGroupId").val("");$("#jsGroupName").val("");closeDialog(); });
    dialog.find(".dialogClose").unbind("click").click(function(){ $("#jsGroupId").val("");$("#jsGroupName").val("");closeDialog(); });
}

function spliceHtml (data)
{
    var html = '';
    
    html +='<tr id="groupId'+data.group_id+'">\
        <td>'+data.num+'</td>\
        <td>'+data.group_name+'</td>\
        <td>'+data.total+'</td>\
        <td>'+data.created_time+'</td>\
        <td class="operate">\
            <a title="编辑" class="icon05" href="javascript:editContact(\''+data.group_id+'\',\''+data.group_name+'\');" UIdialog="addContact"></a>\
            <a title="查看" class="icon10" href="'+js_huodongshu_domain+'/html/contact_group_show.html?group_id='+data.group_id+'&group_name='+encodeURI(data.group_name)+'"></a>\
            <a title="删除" class="icon04" href="javascript:delContact(\''+data.group_id+'\',\''+data.total+'\');"></a>\
        </td>\
    </tr>';
    
    return html;
}
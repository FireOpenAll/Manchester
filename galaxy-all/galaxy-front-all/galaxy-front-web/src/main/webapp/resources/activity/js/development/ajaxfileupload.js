/**
 * huodongshu - ajaxfileupload.js ajax上传文件通用JS代码
 * http://www.huodongshu.com
 * Date: 2014/06/05
 * @author lid_ong@sina.com
 * @requires jQuery v1.4.4+
 * $Id: ajaxfileupload.js 16424 2014-09-05 02:36:19Z srn $
 */
jQuery.extend({
    createUploadIframe: function(id, uri)
    {
            //create frame
            var frameId = 'jUploadFrame' + id;
            if(window.ActiveXObject) {
                // edit  lidong 这里在IE下创建iframe DOM是回出错
                //var io = document.createElement('<iframe id="' + frameId + '" name="' + frameId + '" />');
                var  io = document.createElement("iframe");
                io.id = frameId;        // io.setAttribute("id", frameId);
                io.name = frameId;    // io.setAttribute("name", frameId);
                if(typeof uri== 'boolean'){
                    io.src = 'javascript:false';
                }
                else if(typeof uri== 'string'){
                    io.src = uri;
                }
            }
            else {
                var io = document.createElement('iframe');
                io.id = frameId;
                io.name = frameId;
            }
            io.style.position = 'absolute';
            io.style.top = '-1000px';
            io.style.left = '-1000px';
            document.body.appendChild(io);
            return io;            
    },
    createUploadForm: function(id, fileElementId)
    {
        //create form    
        var formId = 'jUploadForm' + id;
        var fileId = 'jUploadFile' + id;
        var form = jQuery('<form  action="" method="POST" name="' + formId + '" id="' + formId + '" enctype="multipart/form-data"></form>');    
        var oldElement = jQuery('#' + fileElementId);
        var newElement = jQuery(oldElement).clone();
        jQuery(oldElement).attr('id', fileId);
        jQuery(oldElement).before(newElement);
        jQuery(oldElement).appendTo(form);
        //set attributes
        jQuery(form).css('position', 'absolute');
        jQuery(form).css('top', '-1200px');
        jQuery(form).css('left', '-1200px');
        jQuery(form).appendTo('body');
        return form;
    },

    ajaxFileUpload: function(s) {
        // TODO introduce global settings, allowing the client to modify them for all requests, not only timeout        
        s = jQuery.extend({}, jQuery.ajaxSettings, s);
        var id = s.fileElementId;        
        var form = jQuery.createUploadForm(id, s.fileElementId);
        var io = jQuery.createUploadIframe(id, s.secureuri);
        var frameId = 'jUploadFrame' + id;
        var formId = 'jUploadForm' + id;
        
        if( s.global && ! jQuery.active++ )
        {
            // Watch for a new set of requests
            jQuery.event.trigger( "ajaxStart" );
        }
        var requestDone = false;
        // Create the request object
        var xml = {};
        if( s.global )
        {
            jQuery.event.trigger("ajaxSend", [xml, s]);
        }
        var uploadCallback = function(isTimeout)
        {
            // Wait for a response to come back    
            var io = document.getElementById(frameId);
            try 
            {
                if(io.contentWindow)
                {
                     xml.responseText = io.contentWindow.document.body?io.contentWindow.document.body.innerHTML:null;
                     xml.responseXML = io.contentWindow.document.XMLDocument?io.contentWindow.document.XMLDocument:io.contentWindow.document;
                     
                }else if(io.contentDocument)
                {
                     xml.responseText = io.contentDocument.document.body?io.contentDocument.document.body.innerHTML:null;
                    xml.responseXML = io.contentDocument.document.XMLDocument?io.contentDocument.document.XMLDocument:io.contentDocument.document;
                }
            }catch(e)
            {
                jQuery.handleError(s, xml, null, e);
            }
            if( xml || isTimeout == "timeout") 
            {
                requestDone = true;
                var status;
                try {
                    status = isTimeout != "timeout" ? "success" : "error";
                    // Make sure that the request was successful or notmodified
                    if( status != "error" )
                    {
                        // process the data (runs the xml through httpData regardless of callback)
                        var data = jQuery.uploadHttpData( xml, s.dataType );                        
                        if( s.success )
                        {
                            // ifa local callback was specified, fire it and pass it the data
                            //console.log(data);
                            s.success( data, status );
                        };
                        if( s.global )
                        {
                            // Fire the global callback
                            jQuery.event.trigger( "ajaxSuccess", [xml, s] );
                        };
                    } else
                    {
                        jQuery.handleError(s, xml, status);
                    }
                } catch(e) 
                {
                    status = "error";
                    jQuery.handleError(s, xml, status, e);
                };
                if( s.global )
                {
                    // The request was completed
                    jQuery.event.trigger( "ajaxComplete", [xml, s] );
                };
                // Handle the global AJAX counter
                if(s.global && ! --jQuery.active)
                {
                    jQuery.event.trigger("ajaxStop");
                };
                if(s.complete)
                {
                     s.complete(xml, status);
                } ;
                jQuery(io).unbind();
                setTimeout(function()
                                    {    try 
                                        {
                                            jQuery(io).remove();
                                            jQuery(form).remove();    
                                            
                                        } catch(e) 
                                        {
                                            jQuery.handleError(s, xml, null, e);
                                        }
                                    }, 100);
                xml = null;
            };
        }
        // Timeout checker
        if( s.timeout > 0 ) 
        {
            setTimeout(function(){
                if( !requestDone )
                {
                    // Check to see ifthe request is still happening
                    uploadCallback( "timeout" );
                }
            }, s.timeout);
        }
        try 
        {
            var form = jQuery('#' + formId);
            jQuery(form).attr('action', s.url);
            jQuery(form).attr('method', 'POST');
            jQuery(form).attr('target', frameId);
            if(form.encoding)
            {
                form.encoding = 'multipart/form-data';                
            }
            else
            {
                form.enctype = 'multipart/form-data';
            }
            jQuery(form).submit();

        } catch(e) 
        {
            jQuery.handleError(s, xml, null, e);
        }
        if(window.attachEvent){
            document.getElementById(frameId).attachEvent('onload', uploadCallback);
        }
        else{
            document.getElementById(frameId).addEventListener('load', uploadCallback, false);
        }         
        return {abort: function () {}};    
    },

    uploadHttpData: function( r, type ) {
        var data = !type;
        data = type == "xml" || data ? r.responseXML : r.responseText;
        // ifthe type is "script", eval it in global context
        if( type == "script" )
        {
            jQuery.globalEval( data );
        }
        // Get the JavaScript object, ifJSON is used.
        if( type == "json" )
        {
            eval( "data = " + data );
        }
        // evaluate scripts within html
        if( type == "html" )
        {
            jQuery("<div>").html(data).evalScripts();
        }
        return data;
    },
    
    // ajaxFileUpload插件用到这个函数
    handleError: function( s, xhr, status, e )
    {
        // If a local callback was specified, fire it
        if ( s.error ) {
            s.error.call( s.context || s, xhr, status, e );
        }
        // Fire the global callback
        if ( s.global ) {
            (s.context ? jQuery(s.context) : jQuery.event).trigger( "ajaxError", [xhr, s, e] );
        }
    }
});

 /**
 * ajax图片上传
 * thumb 是上传图片存放文件夹也是缩略图配置信息
 * imgname 是上传按钮的name值
 * imgid 是上传按钮的ID值
 * loadimg 要加载小菊花的 ID值 暂时不用
 * type 是缩略图类型 现在只支持max
 * @author lidong
 * @returns  bool|string|array 没有完成返回false; 没用生成缩略图是直接返回上传图片网络地址; 有缩略图的返回值为array('file_url'=>'原图地址','thumb_url'=>'缩略图地址') 
 */ 
  function ajaxFileUploads(thumb, imgname, imgid, mode, callback){
    $.ajaxFileUpload({
        url: '/core/file_uploader.do?source=ajaxuploader&file_field='+imgname+'&thumb_config='+thumb+'&mode='+mode,
        secureuri: false,
        fileElementId: imgid,
        dataType: 'json',
        success: function(jsonData, type){
            callback(jsonData);
        },
        error: function(jsonData, type, e){
          //alert('上传失败，请刷新后重试1');
          callback(jsonData);
          return false;
        }
    });
    return false;
  }
  
  //dox文件上传
  function ajaxDocUploads(thumb, imgname, imgid, mode, callback){
      $.ajaxFileUpload({
          url: '/core/file_uploader.do?source=ajaxuploader&file_field='+imgname+'&thumb_config='+thumb+'&mode='+mode+'&dir=filedata',
          secureuri: false,
          fileElementId: imgid,
          dataType: 'json',
          success: function(jsonData, type){
              callback(jsonData);
          },
          error: function(jsonData, type, e){
            //alert('上传失败，请刷新后重试1');
            callback(jsonData);
            return false;
          }
      });
      return false;
    }
package com.galaxy.front.web.tag.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ResultModelUtils;

/*author:huangshanqi
 *time  :2014年11月8日 下午6:08:46
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping("tag")
public class ActivityTagController {
	
	@ResponseBody
	@RequestMapping(value="hot",method=RequestMethod.GET)
	public Object getHotTags(){
		ResultModel resultModel = new ResultModel();
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		String tags = "IT:互联网:移动互联网:电商:创业:创新:科技:公益:慈善:环保:分享会:志愿者:分享:户外:教育:讲座:公开课:课程:培训:英语:口才:沙龙:聚会:论坛:会议:交流:展览:摄影:展会:创意:文艺:艺术:文学:文化:活动:设计:校园:儿童:亲子:读书:交友:演讲:手工:融资:理财:金融:营销:投资:时尚:媒体:职场:免费:音乐:游戏:休闲:心理:健康:电影:音乐会:演唱会:舞台剧:首映:开幕式:发布会";
        ArrayList<String> list = new ArrayList<String>();
		for(String tag:tags.split(":")){
        	 list.add(tag);
        }
		resultModel.setData(list);
		return resultModel;
	} 
	

}

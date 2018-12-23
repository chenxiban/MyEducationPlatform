package com.cxb.cyj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.cyj.entity.PsotTui;
import com.cxb.cyj.entity.Result;
import com.cxb.cyj.fegin.ConsumerServiceWang;
import com.cxb.cyj.service.PsotTuiService;
import com.cxb.cyj.util.IsEmptyUtils;

/**
 * 
 * @Description: 贴吧推荐控制器
 * @ClassName: PostController.java
 * @author ChenYongJia
 * @Date 2018年12月04日 下午20:40:56
 * @Email 867647213@qq.com
 */
@RestController
@RequestMapping(value = "/post", name = "贴吧推荐管理")
public class PostController {
	
	@Autowired
	private ConsumerServiceWang consumerServiceWang;
	
	@Autowired
	private PsotTuiService psotTuiService;
	
	/**
	 * 查询贴吧推荐 http://localhost:3011/chenyongjia/ChenYongJia/post/queryAllPage
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping(value = "/queryAllPage", name = "查询贴吧推荐信息", method = RequestMethod.GET)
	public Object getCollege(PsotTui psotTui) {
		List<Integer> list=psotTuiService.countPostTuiPostId();
		if (psotTui.getP()==0) {
			if (IsEmptyUtils.isEmpty(list)) {
				return "暂无推荐帖子!!!!";
			} else {
				return consumerServiceWang.selectPostListByPostId(list);
			}
		} else if (psotTui.getP()==1) {
			return consumerServiceWang.selectPostListByTopD(psotTui.getPage(), psotTui.getRows());
		}else if (psotTui.getP()==2) {
			return consumerServiceWang.selectPostListByTopC(psotTui.getPage(), psotTui.getRows());
		} else {
			return consumerServiceWang.queryByTop(psotTui.getPage(), psotTui.getRows());
		}
		
	}
	
	/**
	 * 添加贴吧推荐 http://localhost:3011/chenyongjia/ChenYongJia/post/savePostTui
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping(value = "/savePostTui", name = "添加贴吧推荐信息", method = RequestMethod.PUT)
	public Object savePostTui(PsotTui psotTui) {
		if (psotTuiService.countPostTui()>10) {
			return new Result(false, "推荐帖子已满十条,请先移除其他推荐帖子在进行推荐操作");
		} else if (psotTuiService.savePostTui(psotTui)) {
			return new Result(true, "推荐帖子添加成功");
		} else {
			return new Result(false, "推荐帖子添加失败");
		}
	}
	
	/**
	 * 删除贴吧推荐 http://localhost:3011/chenyongjia/ChenYongJia/post/delPsotTui
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping(value = "/delPsotTui", name = "删除贴吧推荐信息", method = RequestMethod.DELETE)
	public Object delPsotTui(PsotTui psotTui) {
		if (psotTuiService.delPsotTui(psotTui.getPostId())) {
			return new Result(true, "推荐帖子移除成功");
		} else {
			return new Result(false, "推荐帖子移除失败");
		}
	}
	
	/**
	 * 查询推荐id http://localhost:3011/chenyongjia/ChenYongJia/post/getPostId
	 * 
	 * @author ChenYongJia
	 * @return
	 */
	@RequestMapping(value = "/getPostId", name = "查询推荐id", method = RequestMethod.GET)
	public List<Integer> getPostId(){
		return psotTuiService.countPostTuiPostId();
	}
	
}

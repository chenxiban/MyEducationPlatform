package com.cxb.wmx.service;


/**
 * 回复点赞踩赞service
 * @author 王梦霞
 *
 */
public interface ReplyLikeService {

	public boolean addReplylikeDz(Integer replyId,Integer userId);
	public boolean addReplylikeCz(Integer replyId,Integer userId);
	public boolean deleteReplylikeDz(Integer replyId,Integer userId);
	public boolean deleteReplylikeCz(Integer replyId,Integer userId);
	public boolean updateReplylikeDz(Integer replyId,Integer userId);
	public boolean updateReplylikeCz(Integer replyId,Integer userId);
}

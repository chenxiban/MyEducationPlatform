package com.cxb.wmx.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.cxb.wmx.entity.Discommit;
import com.cxb.wmx.entity.Dispost;

public interface ThemeDetailsRepository extends JpaRepository<Dispost, Integer>,JpaSpecificationExecutor<Dispost>{

	/**
	 * 作者:孙可欣
	 * 查询指定的帖子详情
	 * @param dispostId
	 * @return
	 */
	@Query(value="select * from tb_dispost where dispost_id=?1",nativeQuery=true)
	public Dispost selectThemeDetailsByDispostId(int dispostId);
	/**
	 * 作者:孙可欣
	 * 查询指定帖子评论
	 * @param dispost
	 * @return
	 */
/*	@Query(value="select discommitCount,discommitName where dispost=?1",nativeQuery=true)
	public Discommit selectDiscommitByDispost(int dispost);*/
	/**
	 * 作者:孙可欣
	 * 查询指定帖子中评论的回复
	 * @param discommit
	 * @return
	 */
/*	@Query(value="select userId,dispostreplyName,dispostreplyCreatetime where discommit=?1",nativeQuery=true)
	public Discommit selectDispostreplyByDiscommit(int discommit);
	
	*/
	
	
	/**
	 * @author sun
	 * 修改帖子
	 * @param discommitCount
	 * @param discommitId
	 * @return
	 */
	@Query(value="update tb_dispost  set dispost_count = ?2 ,dispost_title=?1 where dispost_id = ?3 ",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer updateThemeByDispostId(String dispostTitle,String dispostCount,int dispostId);
	


	/**
	 * @author sun
	 * 删除帖子时查看该帖子是否有点赞踩
	 * @param dispostId
	 * @return
	 */
	@Query(value="SELECT COUNT(*) FROM tb_dislike WHERE dispost_id = ?1",nativeQuery=true)
	public Integer selectDispostWhetherLike(Integer dispostId);
	
	
	/**
	 * @author sun
	 * 删除帖子的点踩赞
	 * @param discommentId
	 * @return
	 */
	@Query(value="DELETE FROM tb_dislike  WHERE dispost_id = ?1",nativeQuery=true)
	@Modifying
	@Transactional
	public Integer deleteDislikeByDispostId(Integer dispost);
	
}

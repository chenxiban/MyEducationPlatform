package com.cxb.cyj.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cxb.cyj.entity.User;
import com.cxb.cyj.entitysearch.UserSearch;

/**
 * 
 * @Description: 用户业务类
 * @ClassName: UserService.java
 * @author ChenYongJia
 * @Date 2018年12月04日 下午20:40:56
 * @Email 867647213@qq.com
 */
@Service
public interface UserService {

	/**
	 * 多条件分页检索查询
	 * 
	 * @param userName
	 * @param userIsLookout
	 * @param birthStart
	 * @param birthEnd
	 * @param email
	 * @param mtel
	 * @param page
	 * @param rows
	 * @return
	 */
	Page<User> sreachByUser(UserSearch userSearch, Pageable pageable);

	/**
	 * 根据姓名查询
	 * 
	 * @param usersName
	 * @return
	 */
	User findsLoginName(String userName);

	/**
	 * 添加用户信息
	 * 
	 * @param u
	 * @return
	 */
	boolean addUser(User u);

	/**
	 * 删除用户信息
	 * 
	 * @param stuList
	 * @return
	 */
	boolean delUser(List<String> stuList);

	/**
	 * 修改用户信息
	 * 
	 * @param id
	 * @return
	 */
	User updUserById(Integer id);

	/**
	 * 根据id查询用户
	 * 
	 * @param id
	 * @return
	 */
	User getUserById(Integer userId);

	/**
	 * 根据用户id查询用户角色
	 * 
	 * @param id
	 * @return
	 */
	List<Integer> getUserRole(Integer userId);

	/**
	 * 查询角色为老师的信息
	 * 
	 * @return
	 */
	Object getByTeacher(Integer collegeId, Integer p, Integer page, Integer rows);
	
	/**
	 * 修改老师绑定专业
	 * @param userId
	 * @param collegeId
	 * @return
	 */
	Object updateUser(Integer userId,Integer collegeId);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> getUserInfo();
	
	/**
	 * 为学生绑定班级
	 * @param userId
	 * @param classId
	 * @param p
	 * @return
	 */
	Object addUserClazz(Integer userId,Integer classId,Integer p);
	
	/**
	 * 根据用户id查询权限
	 * @param id
	 * @return
	 */
	List<String> queryPermissionValueByUserId(Integer id);

}

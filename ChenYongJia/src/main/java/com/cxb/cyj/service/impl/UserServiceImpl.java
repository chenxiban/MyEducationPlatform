package com.cxb.cyj.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cxb.cyj.dao.UsersRepository;
import com.cxb.cyj.entity.Result;
import com.cxb.cyj.entity.User;
import com.cxb.cyj.entitysearch.UserSearch;
import com.cxb.cyj.service.UserService;
import com.cxb.cyj.util.IsEmptyUtils;

/**
 * 
 * @Description: 用户业务实现类
 * @ClassName: UserServiceImpl.java
 * @author ChenYongJia
 * @Date 2018年12月04日 下午20:40:56
 * @Email 867647213@qq.com
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository usersRepository;

	/*
	 * @Autowired private RolesRepository rolesRepository;
	 */

	/**
	 * 根据姓名查询
	 * 
	 * @param usersName
	 * @return
	 */
	@Override
	public User findsLoginName(String userName) {
		return usersRepository.findByUserName(userName);
	}

	/**
	 * 动态sql分页查询
	 */
	@Override
	public Page<User> sreachByUser(UserSearch userSearch, Pageable pageable) {
		return usersRepository.findAll(this.getWhereClause(userSearch), pageable);
	}

	/**
	 * 查询条件动态组装 动态生成where语句 匿名内部类形式
	 * 
	 * @param us
	 * @return
	 * @author ChenYongJia
	 */
	@SuppressWarnings({ "serial" })
	private Specification<User> getWhereClause(final UserSearch us) {
		return new Specification<User>() {

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();// 动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();// 动态SQL表达式集合

				if (!IsEmptyUtils.isEmpty(us.getUserName())) {
					exList.add(cb.like(root.<String>get("userName"), "%" + us.getUserName() + "%"));
				}
				if (!IsEmptyUtils.isEmpty(us.getUserIsLookout())) {
					exList.add(cb.like(root.<String>get("userIsLookout"), "%" + us.getUserIsLookout() + "%"));
				}
				if (!IsEmptyUtils.isEmpty(us.getBirthStart())) {
					exList.add(cb.greaterThanOrEqualTo(root.<Date>get("userCreatTime"), us.getBirthStart()));
				}
				if (!IsEmptyUtils.isEmpty(us.getBirthEnd())) {
					exList.add(cb.lessThanOrEqualTo(root.<Date>get("userCreatTime"), us.getBirthEnd()));
				}
				if (!IsEmptyUtils.isEmpty(us.getUserProtectEMail())) {
					exList.add(cb.like(root.<String>get("userProtectEMail"), "%" + us.getUserProtectEMail() + "%"));
				}
				if (!IsEmptyUtils.isEmpty(us.getUserProtectMTel())) {
					exList.add(cb.like(root.<String>get("userProtectMTel"), "%" + us.getUserProtectMTel() + "%"));
				}
				return predicate;
			}

		};
	}

	@Override
	public boolean addUser(User u) {
		try {
			usersRepository.save(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delUser(List<String> stuList) {
		try {
			usersRepository.deleteBatch(stuList);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User updUserById(Integer userId) {
		return usersRepository.findByUserId(userId);
	}

	@Override
	public User getUserById(Integer userId) {
		return usersRepository.findByUserId(userId);
	}

	@Override
	public List<Integer> getUserRole(Integer userId) {
		return usersRepository.getUserRole(userId);
	}

	/**
	 * 查询角色为老师的信息
	 * 
	 * @return
	 */
	@Override
	public Object getByTeacher(Integer collegeId, Integer p, Integer page, Integer rows) {
		// Roles roles=rolesRepository.getAllRoles("老师");
		if (p == 1) {
			// 查询已经绑定指定院系的老师id
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("total", usersRepository.findCollegeId(collegeId).size());
			map.put("rows", usersRepository.findCollegeId(collegeId, (page - 1) * rows, rows));
			return map;
		} else if (p == 2) {
			// 查询未绑定院系的老师id
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("total", usersRepository.getUserTeacherAndUserId(3).size());
			map.put("rows", usersRepository.getUserTeacherAndUserId(3, (page - 1) * rows, rows));
			return map;
		} else if (p == 3) {
			List<Integer> list=usersRepository.getUserAndClazz();
			if (IsEmptyUtils.isEmpty(list)) {
				return 0;
			} else {
				// 查询未绑定班级的学生
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("total", usersRepository.findUserNotId(4,list).size());
				map.put("rows", usersRepository.findUserNotId(4,list,(page - 1) * rows, rows));
				return map;
			}
		} else {
			// 查询已绑定该班级的学生
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("total", usersRepository.getUserClassId(collegeId).size());
			map.put("rows", usersRepository.getUserClassId(collegeId, (page - 1) * rows, rows));
			return map;
		} 
			//List<Integer> list=usersRepository.getUserAndRoleId(3);
//			List<Integer> list=usersRepository.getUserAndRoleId(3);
//			List<Integer> list2 = null;
//			if (!IsEmptyUtils.isEmpty(list)) {
//				list2=usersRepository.getUserIdAndClassId(collegeId,list);
//			}

	}

	@Override
	public Object updateUser(Integer userId, Integer collegeId) {
		if (collegeId == 21) {
			return usersRepository.updateUser(userId, collegeId) > 0 ? new Result(true, "解除绑定该院系成功")
					: new Result(false, "解除绑定该院系失败");
		} else {
			return usersRepository.updateUser(userId, collegeId) > 0 ? new Result(true, "绑定该院系成功")
					: new Result(false, "绑定该院系失败");
		}
	}

	@Override
	public List<User> getUserInfo() {
		return usersRepository.findAll();
	}

	/**
	 * 为学生绑定班级
	 * @param userId
	 * @param classId
	 * @param p
	 * @return
	 */
	@Override
	public Object addUserClazz(Integer userId, Integer classId,Integer p) {
		if (p==1) {
			return usersRepository.addUserClazz(userId, classId)>0? new Result(true, "绑定该班级成功")
					: new Result(false, "绑定该班级失败");
		} else {
			return usersRepository.delUserClazz(userId, classId)>0? new Result(true, "解除绑定该班级成功")
					: new Result(false, "解除绑定该班级失败");
		}
	}

	/**
	 * 根据用户id查询权限
	 * @param id
	 * @return
	 */
	@Override
	public List<String> queryPermissionValueByUserId(Integer id) {
		return usersRepository.queryPermissionValueByUserId(id);
	}

}

package com.cxb.cyj.service.impl;

import java.util.Date;
import java.util.List;

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
import com.cxb.cyj.entity.User;
import com.cxb.cyj.entitysearch.UserSearch;
import com.cxb.cyj.service.UserService;
import com.cxb.cyj.util.IsEmptyUtils;

/**
 * 
 * @Description:   用户业务实现类
 * @ClassName:     UserServiceImpl.java
 * @author         ChenYongJia
 * @Date           2018年12月04日 下午20:40:56
 * @Email          867647213@qq.com
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository usersRepository;
	
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

				if (!IsEmptyUtils.isEmpty(us.getUsersName())) {
					exList.add(cb.like(root.<String>get("usersName"), "%" + us.getUsersName() + "%"));
				}
				if (!IsEmptyUtils.isEmpty(us.getUsersIsLookout())) {
					exList.add(cb.like(root.<String>get("usersIsLookout"), "%" + us.getUsersIsLookout() + "%"));
				}
				if (!IsEmptyUtils.isEmpty(us.getBirthStart())) {
					exList.add(cb.greaterThanOrEqualTo(root.<Date>get("birthStart"), us.getBirthStart()));
				}
				if (!IsEmptyUtils.isEmpty(us.getBirthEnd())) {
					exList.add(cb.lessThanOrEqualTo(root.<Date>get("birthEnd"), us.getBirthEnd()));
				}
				if (!IsEmptyUtils.isEmpty(us.getEmail())) {
					exList.add(cb.like(root.<String>get("email"), "%" + us.getEmail() + "%"));
				}
				if (!IsEmptyUtils.isEmpty(us.getMtel())) {
					exList.add(cb.like(root.<String>get("mtel"), "%" + us.getMtel() + "%"));
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
	
}

package com.glacier.permissions.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.glacier.basic.util.RandomGUID;
import com.glacier.jqueryui.util.JqGridReturn;
import com.glacier.jqueryui.util.JqPager;
import com.glacier.jqueryui.util.JqReturnJson;
import com.glacier.permission.dao.ActionMapper;
import com.glacier.permission.dao.AuthorityMapper;
import com.glacier.permission.dao.DepMapper;
import com.glacier.permission.dao.RoleMapper;
import com.glacier.permission.entity.Action;
import com.glacier.permission.entity.ActionExample;
import com.glacier.permission.entity.Authority;
import com.glacier.permission.entity.AuthorityExample;
import com.glacier.permission.entity.Role;
import com.glacier.permission.entity.RoleExample;
import com.glacier.permission.entity.User;
import com.glacier.permission.entity.util.ActionRange;
import com.glacier.permission.entity.util.DefaultAction;
import com.glacier.permissions.util.MethodLog;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private DepMapper depMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Autowired
    private ActionMapper actionMapper;

    /**
     * @Title: getRole
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param roleId
     * @param @return
     * @throws 备注
     *             <p>
     *             已检查测试:Green
     *             <p>
     */

    public Object getRole(String roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    /**
     * 
     * @Title: listAsGrid
     * @Description: TODO(以表格结构展示角色列表)
     * @param @param menuId 动作对应的菜单Id
     * @param @param pager 分页参数
     * @param @return 设定文件
     * @return Object 返回类型
     * @throws
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @MethodLog(opera = "浏览角色")
    public Object listAsGrid(JqPager pager) {

        JqGridReturn returnResult = new JqGridReturn();
        RoleExample roleExample = new RoleExample();

        Subject pricipalSubject = SecurityUtils.getSubject();
        User pricipalUser = (User) pricipalSubject.getPrincipal();
        ActionRange actionRange = (ActionRange) pricipalSubject.getSession().getAttribute("RolePanel_list");
        if (null != actionRange) {// 当权限范围才进行检查
            if (actionRange == ActionRange.DEPC) {// 当前登录用户的部门在记录创建者的部门或子部门中
                roleExample.createCriteria().andCreaterDepEqualTo(pricipalUser.getDepId());
            } else if (actionRange == ActionRange.DEP) {// 当前登录用户的部门和记录的创建者一致
                roleExample.createCriteria().andCreaterDepIn(depMapper.selectChildrenById(pricipalUser.getDepId()));
            } else if (actionRange == ActionRange.SELF) {// 当前登录用户和记录的创建者一致
                roleExample.createCriteria().andCreaterEqualTo(pricipalUser.getUserId());
            }
        }
        if (null != pager.getPage() && null != pager.getRows()) {// 设置排序信息
            roleExample.setLimitStart((pager.getPage() - 1) * pager.getRows());
            roleExample.setLimitEnd(pager.getRows());
        }
        if (StringUtils.isNotBlank(pager.getSort()) && StringUtils.isNotBlank(pager.getOrder())) {// 设置排序信息
            roleExample.setOrderByClause(pager.getOrderBy("temp_role_"));
        }
        List<Role> Roles = roleMapper.selectByExample(roleExample); // 查询所有操作列表
        int total = roleMapper.countByExample(roleExample); // 查询总页数
        returnResult.setRows(Roles);
        returnResult.setTotal(total);
        return returnResult;// 返回ExtGrid表
    }

    /**
     * @Title: addRole
     * @Description: TODO(增加角色)
     * @param @param role
     * @param @return
     * @throws 备注
     *             <p>
     *             已检查测试:Green
     *             <p>
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @MethodLog(opera = "新增角色")
    public Object addRole(Role role) {
        JqReturnJson returnResult = new JqReturnJson();// 构建返回结果，默认结果为false
        RoleExample roleExample = new RoleExample();
        int count = 0;
        // 防止角色名称重复
        roleExample.createCriteria().andRoleCnNameEqualTo(role.getRoleCnName());
        count = roleMapper.countByExample(roleExample);// 查找相同中文名称的角色数量
        if (count > 0) {
            returnResult.setMsg("角色名称重复，请重新填写!");
            return returnResult;
        }
        // 防止英文名称重复
        roleExample.clear();
        roleExample.createCriteria().andRoleEnNameEqualTo(role.getRoleEnName());
        count = roleMapper.countByExample(roleExample);// 查找相同英文名称的菜单数量
        if (count > 0) {
            returnResult.setMsg("英文名称重复，请重新填写!");
            return returnResult;
        }
        role.setRoleId(RandomGUID.getRandomGUID());
        count = roleMapper.insert(role);
        if (count == 1) {
            returnResult.setSuccess(true);
            returnResult.setMsg("[" + role.getRoleCnName() + "] 角色信息已保存");
        } else {
            returnResult.setMsg("角色信息保存失败，请联系管理员!");
        }
        return returnResult;
    }

    /**
     * @Title: editRole
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param role
     * @param @return
     * @throws 备注
     *             <p>
     *             已检查测试:Green
     *             <p>
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @MethodLog(opera = "修改角色")
    public Object editRole(Role role) {
        JqReturnJson returnResult = new JqReturnJson();// 构建返回结果，默认结果为false
        RoleExample roleExample = new RoleExample();
        int count = 0;
        // 防止角色名称重复
        roleExample.createCriteria().andRoleIdNotEqualTo(role.getRoleId()).andRoleCnNameEqualTo(role.getRoleCnName());
        count = roleMapper.countByExample(roleExample);// 查找相同中文名称的角色数量
        if (count > 0) {
            returnResult.setMsg("角色名称重复，请重新填写!");
            return returnResult;
        }
        // 防止英文名称重复
        roleExample.clear();
        roleExample.createCriteria().andRoleIdNotEqualTo(role.getRoleId()).andRoleEnNameEqualTo(role.getRoleEnName());
        count = roleMapper.countByExample(roleExample);// 查找相同英文名称的菜单数量
        if (count > 0) {
            returnResult.setMsg("英文名称重复，请重新填写!");
            return returnResult;
        }
        count = roleMapper.updateByPrimaryKey(role);
        if (count == 1) {
            returnResult.setSuccess(true);
            returnResult.setMsg("[" + role.getRoleCnName() + "] 角色信息已保存");
        } else {
            returnResult.setMsg("角色信息保存失败，请联系管理员!");
        }
        return returnResult;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @MethodLog(opera = "保存角色菜单权限")
    public Object saveRoleMenuAuths(String roleId, List<String> menuIds) {
        JqReturnJson returnResult = new JqReturnJson();// 构建返回结果，默认结果为false
        AuthorityExample authorityExample = new AuthorityExample();
        if (menuIds.size() > 0) {
            // 先清除所选角色在数据库中没有的权限
            authorityExample.createCriteria().andRoleIdEqualTo(roleId).andMenuIdNotIn(menuIds);
            authorityMapper.deleteByExample(authorityExample);
            // 取出所选角色在数据库中已有的权限，如果是新的菜单权限则插入
            authorityExample.clear();
            authorityExample.createCriteria().andRoleIdEqualTo(roleId);
            List<Authority> authorities = authorityMapper.selectByExample(authorityExample);
            for (String menuId : menuIds) {
                Authority authority = new Authority();
                authority.setMenuId(menuId);
                authority.setRoleId(roleId);
                if (!authorities.contains(authority)) {// 已经存在的权限跳过
                    // 添加默认操作
                    ActionExample actionExample = new ActionExample();
                    actionExample.createCriteria().andMenuIdEqualTo(menuId).andDefaultActionEqualTo(DefaultAction.Default.toString());
                    List<Action> defaultActions = actionMapper.selectByExample(actionExample);
                    StringBuilder actions = new StringBuilder();
                    for (Action action : defaultActions) {
                        actions.append(action.getPanelEnName());
                        actions.append("_");
                        actions.append(action.getActionEnName());
                        actions.append(":");
                        actions.append(ActionRange.ALL);
                        actions.append(",");
                    }
                    if (actions.length() > 0) {
                        authority.setActions(actions.substring(0, actions.length() - 1));
                    }
                    authorityMapper.insert(authority);
                }
            }
        } else {
            authorityExample.createCriteria().andRoleIdEqualTo(roleId);
            authorityMapper.deleteByExample(authorityExample);
        }
        returnResult.setSuccess(true);
        returnResult.setMsg("角色菜单权限已保存");
        return returnResult;
    }

    /**
     * @Title: saveRoleMenuActionAuths
     * @Description: TODO(保存角色菜单操作权限)
     * @param @param authority
     * @param @return
     * @throws 备注
     *             <p>
     *             已检查测试:Green
     *             <p>
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @MethodLog(opera = "保存角色菜单操作权限")
    public Object saveRoleMenuActionAuths(Authority authority) {
        JqReturnJson returnResult = new JqReturnJson();// 构建返回结果，默认结果为false
        int count = 0;
        AuthorityExample authorityExample = new AuthorityExample();
        authorityExample.createCriteria().andRoleIdEqualTo(authority.getRoleId()).andMenuIdEqualTo(authority.getMenuId());
        count = authorityMapper.countByExample(authorityExample);
        if(count > 0){
            count = authorityMapper.updateByPrimaryKey(authority);
        }else{
            count = authorityMapper.insert(authority);
        }
        if(count == 1){
            returnResult.setSuccess(true);
            returnResult.setMsg("角色操作权限已保存");
            return returnResult;
        } 
        returnResult.setMsg("角色操作权限保存失败");
        return returnResult;
    }

}

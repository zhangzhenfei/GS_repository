package com.glacier.permissions.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.glacier.basic.util.CollectionsUtil;
import com.glacier.basic.util.JackJson;
import com.glacier.basic.util.RandomGUID;
import com.glacier.jqueryui.util.JqGridReturn;
import com.glacier.jqueryui.util.JqPager;
import com.glacier.jqueryui.util.JqReturnJson;
import com.glacier.permission.dao.ActionMapper;
import com.glacier.permission.dao.AuthorityMapper;
import com.glacier.permission.entity.Action;
import com.glacier.permission.entity.ActionExample;
import com.glacier.permission.entity.ActionExample.Criteria;
import com.glacier.permission.entity.Authority;
import com.glacier.permission.entity.AuthorityKey;
import com.glacier.permissions.util.MethodLog;
import com.glacier.permissions.web.vo.permissions.AuthActionView;
import com.glacier.permissions.web.vo.permissions.AuthPanelView;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class ActionService {

    @Autowired
    private ActionMapper actionMapper;
    
    @Autowired
    private AuthorityMapper authorityMapper;

    /**
     * 
    * @Title: listAsGrid 
    * @Description: TODO(以组表格结构展示操作列表，操作中必须定义getGroup()方法) 
    * @param @param menuId 动作对应的菜单Id
    * @param @param pager 分页参数
    * @param @return    设定文件 
    * @return Object    返回类型 
    * @throws
     */
    public Object listAsGrid(String menuId,String panenId,JqPager pager) {
        JqGridReturn returnResult = new JqGridReturn();
        if(StringUtils.isNotBlank(menuId)){//当菜单对应的menuId有意义的时候，才会进行数据库查询
            ActionExample actionExample = new ActionExample();
            Criteria actionCriteria = actionExample.createCriteria();
            actionCriteria.andMenuIdEqualTo(menuId); 
            if(StringUtils.isNotBlank(panenId)){
                actionCriteria.andPanelIdEqualTo(panenId);
            }
            if (null != pager.getPage() && null != pager.getRows()) {// 设置排序信息
                actionExample.setLimitStart((pager.getPage() - 1) * pager.getRows());
                actionExample.setLimitEnd(pager.getRows());
            }
            if (StringUtils.isNotBlank(pager.getSort()) && StringUtils.isNotBlank(pager.getOrder())) {// 设置排序信息
                actionExample.setOrderByClause("temp_panel.order_num ASC," + pager.getOrderBy("temp_action_"));//必须外键inner join t_panel temp_panel
            }
            List<Action> actions = actionMapper.selectByExample(actionExample); // 查询所有操作列表
            int total = actionMapper.countByExample(actionExample); // 查询总页数
            returnResult.setRows(actions);
            returnResult.setTotal(total);
        }
        return returnResult;// 返回ExtGrid表
    }

    /**
     * 
     * @Title: addAction
     * @Description: TODO(增加操作)
     * @param @param action
     * @param @return 设定文件
     * @return Object 返回类型
     * @throws
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @MethodLog(opera="新增操作")
    public Object addAction(Action action) {
        JqReturnJson returnResult = new JqReturnJson();// 构建返回结果，默认结果为false
        ActionExample actionExample = new ActionExample();
        int count = 0;
        // 防止操作名称重复
        actionExample.createCriteria().andActionCnNameEqualTo(action.getActionCnName()).andMenuIdEqualTo(action.getMenuId()).andPanelIdEqualTo(action.getPanelId());
        count = actionMapper.countByExample(actionExample);// 查找相同中文名称的菜单数量
        if (count > 0) {
            returnResult.setMsg("操作名称重复，请重新填写!");
            return returnResult;
        }
        // 防止英文名称重复
        actionExample.clear();
        actionExample.createCriteria().andActionEnNameEqualTo(action.getActionEnName()).andMenuIdEqualTo(action.getMenuId()).andPanelIdEqualTo(action.getPanelId());
        count = actionMapper.countByExample(actionExample);// 查找相同英文名称的菜单数量
        if (count > 0) {
            returnResult.setMsg("操作名称重复，请重新填写!");
            return returnResult;
        }
        action.setActionId(RandomGUID.getRandomGUID());
        count = actionMapper.insert(action);
        if (count == 1) {
            returnResult.setSuccess(true);
            returnResult.setMsg("[" + action.getActionCnName() + "] 操作信息已保存");
        } else {
            returnResult.setMsg("操作信息保存失败，请联系管理员!");
        }
        return returnResult;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @MethodLog(opera="修改操作")
    public Object editAction(Action action) {
        JqReturnJson returnResult = new JqReturnJson();// 构建返回结果，默认结果为false
        ActionExample actionExample = new ActionExample();
        int count = 0;
        // 防止操作名称重复
        actionExample.createCriteria()
            .andActionIdNotEqualTo(action.getActionId()).andActionCnNameEqualTo(action.getActionCnName())
            .andMenuIdEqualTo(action.getMenuId()).andPanelIdEqualTo(action.getPanelId());
        count = actionMapper.countByExample(actionExample);// 查找相同中文名称的菜单数量
        if (count > 0) {
            returnResult.setMsg("操作名称重复，请重新填写!");
            return returnResult;
        }
        // 防止英文名称重复
        actionExample.clear();
        actionExample
            .createCriteria()
            .andActionIdNotEqualTo(action.getActionId()).andActionEnNameEqualTo(action.getActionEnName())
            .andMenuIdEqualTo(action.getMenuId()).andPanelIdEqualTo(action.getPanelId());
        count = actionMapper.countByExample(actionExample);// 查找相同英文名称的菜单数量
        if (count > 0) {
            returnResult.setMsg("操作名称重复，请重新填写!");
            return returnResult;
        }
        count = actionMapper.updateByPrimaryKey(action);
        if (count == 1) {
            returnResult.setSuccess(true);
            returnResult.setMsg("[" + action.getActionCnName() + "] 操作信息已保存");
        } else {
            returnResult.setMsg("操作信息保存失败，请联系管理员!");
        }
        return returnResult;
    }
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @MethodLog(opera="删除操作")
    public Object delActions(List<String> actionIds,List<String> actionCnNames){
        JqReturnJson returnResult = new JqReturnJson();// 构建返回结果，默认结果为false
        int count = 0;
        if(actionIds.size() > 0){
            ActionExample actionExample = new ActionExample();
            actionExample.createCriteria().andActionIdIn(actionIds);
            //方便操作日志记录
            count = actionMapper.deleteByExample(actionExample);
            if (count > 0) {
                returnResult.setSuccess(true);
                returnResult.setMsg("成功删除了[ "+ CollectionsUtil.convertToString(actionCnNames,",") +" ]操作!");
            }else{
                returnResult.setMsg("删除失败，请联系管理员!");
            }
        }
        return returnResult;
    }
    
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public Object getPAAuthByCondition(String menuId,String roleId){
        //查找菜单下的操作，并根据roder_num排序
        ActionExample actionExample = new ActionExample();
        actionExample.createCriteria().andMenuIdEqualTo(menuId);
        actionExample.setOrderByClause("temp_action_order_num");
        List<Action> actions = actionMapper.selectByExample(actionExample);
        
        Map<String,AuthPanelView> panelFlag = new HashMap<String,AuthPanelView>();
        
        
        for (Action action : actions) {
            AuthPanelView authPanelView;
            
            AuthActionView authActionView = new AuthActionView();
            authActionView.setAction(action.getActionEnName());
            authActionView.setActionName(action.getActionCnName());
            authActionView.setDefaultAuth(action.getDefaultAction().getValue());
            authActionView.setHasAuthSet(action.getAuthRange().getValue());
            // 查找角色菜单权限操作集合
            AuthorityKey authorityKey = new com.glacier.permission.entity.AuthorityKey();
            authorityKey.setMenuId(menuId);
            authorityKey.setRoleId(roleId);
            String[] ownActions = null;
            Authority roleAuth = authorityMapper.selectByPrimaryKey(authorityKey);
            if (null != roleAuth && StringUtils.isNotBlank(roleAuth.getActions())) {
                ownActions = roleAuth.getActions().split(",");
            }
            
            boolean checked = false;
            String authRange = "ALL";
            if (null != ownActions && ownActions.length > 0) {
                for (String ownAction : ownActions) {
                    // 对action进行分割，避免权限范围对其造成的影响
                    String [] authStr = ownAction.split(":");
                    if ((action.getPanelEnName()+"_"+action.getActionEnName()).equals(authStr[0])) {
                        checked = true;
                        if(authStr.length > 1){
                            authRange = authStr[1];
                        }
                        
                    }
                }
            }
            if (checked) {
                authActionView.setOwnAuth(true); // 权限验证通过
            }
            
            authActionView.setAuthSet(authRange);
            
            if(panelFlag.containsKey(action.getGroup())){
                authPanelView = panelFlag.get(action.getGroup());
                authPanelView.getPanelAuthData().add(authActionView);
            }else{
                authPanelView = new AuthPanelView();
                authPanelView.setPanelCnName(action.getPanelCnName());
                authPanelView.setPanelEnName(action.getPanelEnName());
                authPanelView.getPanelAuthData().add(authActionView);
                panelFlag.put(action.getGroup(),authPanelView);
            }
            
        }
        
        return JackJson.fromObjectToJson(panelFlag.values());
    }
}

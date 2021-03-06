package cn.zqtao.monster.service.authority;

import cn.zqtao.monster.model.pojo.business.LayuiXTree;

import java.util.List;

public interface AuthorityService {


    /**
     * 根据roleId查找资源树集合
     *
     * @param roleId
     * @return
     */
    List<LayuiXTree> findResourceTreeByRoleId(long roleId);

    /**
     * 初始化管理员账号
     *
     * @param username
     * @param password
     * @param email
     */
    void initMasterAccount(String username, String password, String email);

    /**
     * 删除相关id的菜单以及它的子菜单
     *
     * @param menuId
     */
    void deleteMenu(Long menuId);

    /**
     * 用户注册
     *
     * @param nickname
     * @param pass
     * @param username
     */
    void userRegistration(String nickname, String pass, String username);
}

package com.hx.config;/*
 *//*
 *@作者:张立恒
 *@时间:2018/9/30 11:21
 *@功能:身份校验核心类
 */



import com.hx.pwcontrol.system.SysMenu;
import com.hx.pwcontrol.system.SysRole;
import com.hx.pwcontrol.system.SysUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class MyShiroRealm extends AuthorizingRealm {
    /*进行角色的添加和权限的添加。

authorizationInfo.addRole(role.getRole());

authorizationInfo.addStringPermission(p.getPermission());

当然也可以添加集合：

authorizationInfo.setRoles(roles);

authorizationInfo.setStringPermissions(stringPermissions);*/
    @Autowired
    private UserInfoService userInfoService;
    /**
     * 此方法调用  hasRole,hasPermission的时候才会进行回调.
     *
     * 权限信息.(授权):
     * 1、如果用户正常退出，缓存自动清空；
     * 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * （需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，
     * 调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     * @param
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser userInfo=(SysUser)principalCollection.getPrimaryPrincipal();
        for(SysRole role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRoleName());
            for(SysMenu p:role.getMenuList()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }
    /**
     *
     * 功能描述: 用来进行身份验证,验证用户名密码是否正确
     *
     * @param: 
     * @return: 
     * @auther: 张立恒
     * @date: 2018/9/30 11:59
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户的输入的账号.
        String UserKey = (String)authenticationToken.getPrincipal();
        SysUser userInfo = userInfoService.findByUserKey(UserKey);
        if(userInfo == null){
            return null;
        }
        //加密验证
        /*SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );*/
        //明文
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                getName()  //realm name
        );
        return authenticationInfo;
    }

}

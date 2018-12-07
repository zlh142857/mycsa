package com.hx.config;/*
 *//*
 *@作者:张立恒
 *@时间:2018/9/30 11:21
 *@功能:身份校验核心类
 */



import com.hx.SysPermission;
import com.hx.SysRole;
import com.hx.UserInfo;
import com.hx.feignService.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
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
        UserInfo userInfo=(UserInfo)principalCollection.getPrimaryPrincipal();
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        //权限单个添加;
        // 或者按下面这样添加
        //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
        //authorizationInfo.addRole("admin");
        //添加权限
        //authorizationInfo.addStringPermission("userInfo:query");
        ///在认证成功之后返回.
        //设置角色信息.
        //支持 Set集合,
        //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
       /* List<SysRole> roleList=userInfo.getRoleList();
        for (SysRole role : roleList) {
            authorizationInfo.addStringPermissions(role.getPermissions());
        }*/
        for(SysRole role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(SysPermission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        //authorizationInfo.setStringPermissions(getStringPermissions(userInfo.getRoleList()));
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
        String username = (String)authenticationToken.getPrincipal();
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userInfo = userInfoService.findByUsername(username);
        if(userInfo == null){
            return null;
        }
        /*
         * 获取权限信息:这里没有进行实现，
         * 请自行根据UserInfo,Role,Permission进行实现；
         * 获取之后可以在前端for循环显示所有链接;
         */
        //userInfo.setPermissions(userService.findPermissions(user));
        //账号判断;
        //加密方式;
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        //明文: 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
       /* SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
             userInfo, //用户名
             userInfo.getPassword(), //密码
             getName()  //realm name
        );*/
        return authenticationInfo;
    }

    /**
     * 将权限对象中的权限code取出.
     * @param permissions
     * @return
     * */
    /*public Set<String> getStringPermissions(Set<SysPermission> permissions){
        Set<String> stringPermissions = new HashSet<String>();
        if(permissions != null){
            for(SysPermission p : permissions) {
            stringPermissions.add(p.getPermission());
            }
        }
        return stringPermissions;
    }*/


}

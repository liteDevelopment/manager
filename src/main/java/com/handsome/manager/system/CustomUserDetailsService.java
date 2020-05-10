package com.handsome.manager.system;

import com.handsome.manager.ao.UserAccountAO;
import com.handsome.manager.model.Role;
import com.handsome.manager.model.UserRole;
import com.handsome.manager.service.AccountService;
import com.handsome.manager.service.RoleService;
import com.handsome.manager.service.UserRoleService;
import com.handsome.manager.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zhanglihui
 * @date 2020-05-03 18:01
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Resource
    private UserService userService;

    @Resource
    private AccountService accountService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 通过账号查询
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        UserAccountAO userAccountData = accountService.getUserAccountData(username);

        if (null == userAccountData || null == userAccountData.getUserId()) {
            throw new UsernameNotFoundException("用户不存在");
        }

        // 添加权限
        List<UserRole> userRoles = userRoleService.listByUserId(String.valueOf(userAccountData.getUserId()));
        for (UserRole userRole : userRoles) {
            Role role = roleService.selectById(userRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        // 返回UserDetails实现类
        return new org.springframework.security.core.userdetails.User(userAccountData.getName(), userAccountData.getPassword(), authorities);
    }
}

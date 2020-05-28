package com.handsome.manager.system;

import com.handsome.manager.ao.CurrentUser;
import com.handsome.manager.ao.UserAO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class AuthHeaper {

    public static List<String> getAuthList() {
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        if (!CollectionUtils.isEmpty(auths)) {
            List<String> authList = new ArrayList<String>();
            for (GrantedAuthority auth : auths) {
                authList.add(auth.getAuthority());
            }
            return authList;
        } else {
            return new ArrayList<>();
        }
    }

    public static CurrentUser getCurrentUser() {
        CurrentUser myUserDetails = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return myUserDetails;
    }
}

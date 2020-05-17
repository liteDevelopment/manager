package com.handsome.manager.ao;

import lombok.Data;

/**
 * @author zhanglihui
 * @date 2020-05-10 23:42
 */
@Data
public class UserAccountAO {
    private Long userId;
    private String name;
    private String phone;
    private String account;
    private String password;
    private Long roleId;
}

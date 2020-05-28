package com.handsome.manager.ao;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class UserAO {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String name;
    private String phone;
    private String account;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long type;
}

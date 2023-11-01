package org.example.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(title = "用户修改密码相关信息")
public class UserPassword {
    @Schema(title = "用户名，必需")
    private String username;
    @Schema(title = "用户密码，必需")
    private String password;
    @Schema(title = "用户修改后的密码，必需")
    private String rpassword;
}

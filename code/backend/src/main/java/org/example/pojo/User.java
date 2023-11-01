package org.example.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Builder;

@Schema(title = "用户相关信息")
@Data
@Builder
public class User {
    @Schema(title = "用户id，不需要传")
    private Integer id;
    @Schema(title = "用户名，必需")
    private String username;
    @Schema(title = "用户昵称，必需")
    private String name;
    @Schema(title = "用户密码，必需")
    private String password;
    @Schema(title = "用户工作单位，非必须")
    @TableField("workUnit")
    private String workUnit;
    @Schema(title = "用户邮箱，非必须")
    private String email;
    @Schema(title = "用户电话，非必须")
    private String phone;
    @Schema(title = "用户头像url，非必须")
    private String avatar;

}

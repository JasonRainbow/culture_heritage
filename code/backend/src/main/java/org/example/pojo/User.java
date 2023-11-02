package org.example.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Builder;

@Schema(title = "用户相关信息")
@Data
@Builder
public class User {
    @Schema(title = "用户id，不需要传")
    @TableId(type = IdType.AUTO)
    private Integer id;
    @Schema(title = "用户名")
    private String username;
    @Schema(title = "用户昵称")
    private String name;
    @Schema(title = "用户密码")
    private String password;
    @Schema(title = "用户工作单位")
    @TableField("workUnit")
    private String workUnit;
    @Schema(title = "用户邮箱")
    private String email;
    @Schema(title = "用户电话")
    private String phone;
    @Schema(title = "用户头像url")
    private String avatar;

}

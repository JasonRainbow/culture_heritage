<template>
  <el-form ref="form" :model="user" :rules="rules" label-width="80px">
    <el-row>
      <el-col :span="15" :xs="24">
        <el-form-item label="用户昵称" prop="nickname">
          <el-input id="name" v-model="user.nickname" maxlength="30" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="15" :xs="24">
        <el-form-item label="手机号码" prop="phone">
          <el-input id="phone" v-model="user.phone" maxlength="11" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="15" :xs="24">
        <el-form-item label="邮箱" prop="email">
          <el-input id="email" v-model="user.email" maxlength="50" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="15" :xs="24">
        <el-form-item label="工作单位" prop="workUnit">
          <el-input id="workUnit" v-model="user.workUnit" maxlength="50" />
        </el-form-item>
      </el-col>
    </el-row>

<!--    <el-form-item label="性别">
      <el-radio-group v-model="admin.name">
        <el-radio label="0">男</el-radio>
        <el-radio label="1">女</el-radio>
      </el-radio-group>
    </el-form-item>-->
    <el-form-item>
      <el-button type="primary" size="mini" @click="submit">保存</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import {userUpdate} from "../../../api/userAPI";
import {updateLocalUserInfo} from "../../../utils/util";

export default {
  props: {
    user: {
      type: Object
    }
  },
  data() {
    return {
      // 表单校验
      rules: {
        nickname: [
          { required: true, message: "用户昵称不能为空", trigger: "blur" }
        ],
        email: [
          { required: true, message: "邮箱地址不能为空", trigger: "blur" },
          {
            type: "email",
            message: "请输入正确的邮箱地址",
            trigger: ["blur", "change"]
          }
        ],
        phone: [
          { required: true, message: "手机号码不能为空", trigger: "blur" },
          {
            pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
            message: "请输入正确的手机号码",
            trigger: "blur"
          }
        ]
      }
    };
  },
  methods: {
    submit() { // 提交管理员信息的修改
      this.$refs["form"].validate(valid => {
        if (valid) {
          // 要修改的信息
          const updateInfo = {
            id: this.user.id,
            name: this.user.nickname,
            phone: this.user.phone,
            email: this.user.email,
            workUnit: this.user.workUnit
          }
          userUpdate(updateInfo).then(res => {
            if (res.code === "0") {
              this.$message.success("修改用户个人信息成功");
              updateLocalUserInfo()
            } else {
              this.$message.success("修改用户个人信息失败");
            }
          });
        }
      });
    },
  }
};
</script>

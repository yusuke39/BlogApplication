<template>
  <div class="login-box">
    <el-input placeholder="メールアドレス" v-model="email" id="email" class="input-email" clearable></el-input>
    <el-input placeholder="パスワード" v-model="password" id="password" class="input-password" show-password></el-input>
    <el-button type="success" class="login-button">ログイン</el-button>
    <el-row>
      <el-button type="warning" class="new-register-button">新規会員登録</el-button>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'sample',
  data () {
    return {
      email: '',
      password: ''
    }
  }
}
</script>

<style scoped>
.login-box {
  width: 500px;
  margin: 200px auto;
}

.input-email {
  width : 450px;
  margin-bottom: 50px;
}

.input-password {
  width : 450px;
  margin-bottom: 50px;
}

.login-button{
  width: 300px;
  margin-bottom: 30px;
}

.new-register-button {
  width: 300px;
}
</style>

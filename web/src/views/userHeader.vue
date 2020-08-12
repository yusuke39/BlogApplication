<template>
  <div class="user-header">
    <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
    <router-link to="/mainTop">
      <h1 class="main-logo">BLOG APP</h1>
    </router-link>
    <form>
      <el-input
        class="user-header-serch"
        placeholder="ブログ検索"
        v-model="input">
        <i slot="prefix" class="el-input__icon el-icon-search"></i>
      </el-input>
    </form>
    <router-link to="/userRegister" class="user-register-button header-button">新規会員登録</router-link>
    <router-link to="/adminTop" class="mypage-button header-button">マイページ</router-link>
    <router-link to="/adminLogin" class="mypage-button header-button">ログイン</router-link>
  </div>
</template>

<script>
export default {
  data () {
    return {
      input: ''
    }
  }
}
</script>

<style scoped>

  .user-header{
    height: 70px;
    background-color: #55C500;
    display: flex;
  }

  .main-logo{
    color: #ffffff;
    margin-top: 10px;
    margin-left: 50px;
  }

  .user-header-serch{
    width: 400px;
    margin-top: 15px;
    margin-left: 50px;
  }

  .header-button{
    border: solid 2px;
    border-radius: 20px;
    text-align: center;
    width: 120px;
    height: 30px;
    text-decoration: none;
    color: #ffffff;
    margin-top: 20px;
    margin-left: 20px;
  }

  .user-register-button{
    margin-right: 5px;
    margin-left: 300px;
  }

  a {
    text-decoration: none;
  }
</style>

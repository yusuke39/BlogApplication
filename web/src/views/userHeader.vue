<template>
  <div class="user-header">
    <h1 class="main-logo">BLOG APP</h1>
    <form>
      <el-input
        class="user-header-serch"
        placeholder="ブログ検索"
        v-model="input4">
        <i slot="prefix" class="el-input__icon el-icon-search"></i>
      </el-input>
    </form>
    <router-link to="/registerUser" class="user-register-button header-button">新規会員登録</router-link>
    <router-link to="/myPage" class="mypage-button header-button">マイページ</router-link>
  </div>
</template>

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
  }

  .user-register-button{
    margin-right: 30px;
    margin-left: 300px;
  }
</style>

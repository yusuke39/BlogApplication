<template>
  <div class="user-header">
    <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
    <h1 class="main-logo">BLOG APP</h1>
    <el-dropdown class="header-dorop-down">
      <span class="el-dropdown-link">
       メニュー<i class="el-icon-arrow-down el-icon--right"></i>
      </span>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item>
          <router-link to="/adminTop" class="drop-menu">管理者トップ画面</router-link>
        </el-dropdown-item>
        <el-dropdown-item>
          <router-link to="/goodArticles" class="drop-menu">いいねした記事</router-link>
        </el-dropdown-item>
        <el-dropdown-item>
          <router-link to="/saveArticles" class="drop-menu">保存した記事</router-link>
        </el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
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

  .el-dropdown-link {
    cursor: pointer;
    color: #ffffff;
    font-size: 15px;
    font-weight: bold;
  }

  .el-icon-arrow-down {
    font-size: 15px;
    font-weight: bold;
  }

  .header-dorop-down{
    margin-top: 30px;
    margin-left: 50px;
  }

  .drop-menu{
    text-decoration: none;
    color: #524F4F;
  }
</style>

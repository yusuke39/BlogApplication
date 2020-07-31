<template>
  <div class="user-header">
    <h1 class="main-logo">BLOG APP</h1>
    <el-dropdown class="header-dorop-down">
      <span class="el-dropdown-link">
       メニュー<i class="el-icon-arrow-down el-icon--right"></i>
      </span>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item>
          <router-link to="/goodArtcleList" class="drop-menu">いいねした記事</router-link>
        </el-dropdown-item>
        <el-dropdown-item>
          <router-link to="/saveArticleList" class="drop-menu">保存した記事</router-link>
        </el-dropdown-item>
        <el-dropdown-item>
          <router-link to="/articlesGraph" class="drop-menu">グラフ</router-link>
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

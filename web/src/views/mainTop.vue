<template>
<div>
  <user-header></user-header>
  <el-carousel :interval="5000" arrow="always" class="main-images">
    <el-carousel-item v-for="item in 4" :key="item">
      <h3></h3>
    </el-carousel-item>
  </el-carousel>
  <div class="blog-card-wrarpper">
    <div class="blog-card">
      <div class="blog-img-wrapper">
        <img src="../assets/Bruins.jpg" class="blog-card-img">
      </div>
      <span class="blog-card-name">平野祐介</span>
      <div>
      </div>
    </div>
    <div  class="blog-card">
    </div>
    <div class="blog-card">
    </div>
    <div class="blog-card">
    </div>
  </div>
  <div class="blog-card-wrarpper">
    <div class="blog-card">
    </div>
    <div  class="blog-card">
    </div>
    <div class="blog-card">
    </div>
    <div class="blog-card">
    </div>
  </div>
</div>
</template>

<script>
import UserHeader from './userHeader'
export default {
  components: {
    UserHeader
  },
  template: '<user-header>'
}
</script>

<style scoped>
  .main-images{
    margin-bottom: 50px;
  }

  .el-carousel__item:nth-child(3) {
    background-image: url('../assets/lineblog.jpg');
    background-size:100% auto;/*この場合は高さが自動設定*/
  }

  .el-carousel__item:nth-child(4) {
    background-image: url('../assets/line.jpg');
    background-size:auto 100%;/*この場合は幅が自動設定*/
  }

  .el-carousel__item:nth-child(5) {
    background-image: url('../assets/Bruins.jpg');
    background-size:auto 100%;/*この場合は幅が自動設定*/
  }

  .el-carousel__item:nth-child(6) {
    background-image: url('../assets/tec.jpg');
    background-size:auto 100%;/*この場合は幅が自動設定*/
  }

  .blog-card-wrarpper{
    display: flex;
    width: 1000px;
    margin: 0 auto;
    margin-bottom: 40px;
  }

  .blog-card{
    width: 255px;
    height: 300px;
    border: solid 2px;
    margin: auto;
    margin-right: 30px;
  }

  .blog-img-wrapper{
    height: 70%;
  }

  .blog-card-img{
    width: 100%;
    height: 100%;
  }

  .blog-card-name {
    font-size: 30px;
  }
</style>

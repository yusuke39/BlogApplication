<template>
<div>
  <user-header></user-header>
  <el-carousel :interval="5000" arrow="always" class="main-images">
    <el-carousel-item v-for="item in 4" :key="item">
      <h3></h3>
    </el-carousel-item>
  </el-carousel>
  <div class="main-wrapper">
    <div v-for="(users, index) in userBlogInfo" :key="index" class="blog">
      <span v-for="(user, index) in users"  :key="index" class="blog-cards">
        <div class="blog-card-wrarpper">
          <el-card :body-style="{ padding: '0px' }"  class="blog-card">
            <router-link to="/blog">
              <div class="blog-img-wrapper">
                <img v-if="user.blogImg == null" src="../assets/defaulBlogMainImg.gif" class="blog-card-img">
                <img v-if="user.blogImg != null" :src="user.blogImg" class="blog-card-img">
              </div>
              <div class="blog-inside-card">
                <div class="blog-card-name">{{ user.blogName }}</div>
                <div class="inside">
                  <img v-if="user.userImg == null" src="../assets/default.png" class="blog-card-img-mini">
                  <img v-if="user.userImg != null" :src="user.userImg" class="blog-card-img-mini">
                  <div class="">
                    <p class="blog-title">{{ user.userName }}</p>
                    <p class="blog-create-date">{{ user.createDate}}</p>
                  </div>
                </div>
              </div>
            </router-link>
          </el-card>
        </div>
      </span>
    </div>
  </div>
  <div class="main-pagination">
    <el-pagination
      background
      layout="prev, pager, next"
      :total="1000">
    </el-pagination>
  </div>
</div>
</template>

<script>
import UserHeader from './userHeader'
import axios from 'axios'
export default {
  data () {
    return {
      userBlogInfo: '',
      userName: '',
      blogMainImg: '',
      userIconImg: '',
      blogName: '',
      createDate: ''
    }
  },
  components: {
    UserHeader
  },
  mounted () {
    axios
      .get('http://localhost:8080/user/getAllUser')
      .then(response => {
        this.userBlogInfo = response.data
      })
      .catch(error => {
        console.log(error)
      })
  },
  template: '<user-header>'
}
</script>

<style scoped>
  .blog {
    display: flex;
  }

  .blog-cards{
    width: 300px;
  }

  .main-images {
    margin-bottom: 50px;
  }

  .el-carousel__item:nth-child(3) {
    /* background-image: url('../assets/lineblog.jpg');
    background-size:100% auto; */
    background-color: turquoise;
  }

  .el-carousel__item:nth-child(4) {
    /* background-image: url('../assets/line.jpg');
    background-size:auto 100%; */
    background-color: greenyellow;
  }

  .el-carousel__item:nth-child(5) {
    /* background-image: url('../assets/Bruins.jpg');
    background-size:auto 100%; */
    background-color: coral;
  }

  .el-carousel__item:nth-child(6) {
    /* background-image: url('../assets/image1.jpg');
    background-size:auto 100%; */
    background-color: orange;
  }

  .main-wrapper {
    margin-bottom: 50px;
    margin-right: 100px;
    margin-left: 100px;
  }

  .blog-card-wrarpper  {
    /* display: flex; */
    width: 1000px;
    margin: 0 auto;
    margin-bottom: 40px;
    display: flex;
  }

  .blog-card {
    width: 255px;
    height: 300px;
    margin-left: 30px;
  }

  .blog-img-wrapper {
    height: 200px;
  }

  .blog-inside-card {
    width: 200px;
    height: 85px;
    margin: auto;
  }

  .inside{
    width: 200px;
    height: 40px;
    display: flex;
  }

  .blog-card-img {
    width: 100%;
    height: 100%;
  }

  .blog-card-name {
    font-size: 25px;
    font-weight: bold;
  }

  .blog-card-img-mini {
    width: 40px;
    height: 40px;
  }

  .blog-title {
    font-size: 12px;
    margin-left: 20px;
  }

  .blog-create-date {
    font-size: 10px;
    color: #5F5B5B;
    margin-left: 20px;
  }

  .mini-blog-wrapper {
    width: 150px;
    margin-left: 10px;
  }

  .main-pagination{
    text-align: center;
    margin-bottom: 100px;
  }

  a {
    text-decoration: none;
    color: black;
  }
</style>

<template>
  <div>
    <admin-header></admin-header>
    <el-card :body-style="{ padding: '0px' }"  class="good-news-wrapper">
      <span class="ball">●</span>
      <span class="sentence">いいねした記事</span>
      <hr class="line">
      <div class="article-box">
        <router-link to="/articleDetail">
          <div class="blog-detail-box">
            <div class="blog-title">記事タイトル</div>
            <i class="far fa-heart"></i>
            <span>2</span>
            <span class="create-date">2020/8/8</span>
          </div>
        </router-link>
        <hr class="article-line">
        <router-link to="/articleDetail">
          <div class="blog-detail-box">
            <div class="blog-title">記事タイトル</div>
            <i class="far fa-heart"></i>
            <span>2</span>
            <span class="create-date">2020/8/8</span>
          </div>
        </router-link>
        <hr class="article-line">
        <router-link to="/articleDetail">
          <div class="blog-detail-box">
            <div class="blog-title">記事タイトル</div>
            <i class="far fa-heart"></i>
            <span>2</span>
            <span class="create-date">2020/8/8</span>
          </div>
        </router-link>
        <hr class="article-line">
        <router-link to="/articleDetail">
          <div class="blog-detail-box">
            <div class="blog-title">記事タイトル</div>
            <i class="far fa-heart"></i>
            <span>2</span>
            <span class="create-date">2020/8/8</span>
          </div>
        </router-link>
        <hr class="article-line">
        <router-link to="/articleDetail">
          <div class="blog-detail-box">
            <div class="blog-title">記事タイトル</div>
            <i class="far fa-heart"></i>
            <span>2</span>
            <span class="create-date">2020/8/8</span>
          </div>
        </router-link>
        <hr class="article-line">
        <router-link to="/articleDetail">
          <div class="blog-detail-box">
            <div class="blog-title">記事タイトル</div>
            <i class="far fa-heart"></i>
            <span>2</span>
            <span class="create-date">2020/8/8</span>
          </div>
        </router-link>
        <hr class="article-line">
        <router-link to="/articleDetail">
          <div class="blog-detail-box">
            <div class="blog-title">記事タイトル</div>
            <i class="far fa-heart"></i>
            <span>2</span>
            <span class="create-date">2020/8/8</span>
          </div>
        </router-link>
        <hr class="article-line">
        <router-link to="/articleDetail">
          <div class="blog-detail-box">
            <div class="blog-title">記事タイトル</div>
            <i class="far fa-heart"></i>
            <span>2</span>
            <span class="create-date">2020/8/8</span>
          </div>
        </router-link>
        <hr class="article-line">
        <router-link to="/articleDetail">
          <div class="blog-detail-box">
            <div class="blog-title">記事タイトル</div>
            <i class="far fa-heart"></i>
            <span>2</span>
            <span class="create-date">2020/8/8</span>
          </div>
        </router-link>
        <hr class="article-line">
        <router-link to="/articleDetail">
          <div class="blog-detail-box">
            <div class="blog-title">記事タイトル</div>
            <i class="far fa-heart"></i>
            <span>2</span>
            <span class="create-date">2020/8/8</span>
          </div>
        </router-link>
        <hr class="article-line">
        <el-pagination
          class="good-news-pagination"
          background
          layout="prev, pager, next"
          :total="1000">
        </el-pagination>
      </div>
    </el-card>
  </div>
</template>

<script>
import AdminHeader from './adminHeader'
export default {
  components: {
    AdminHeader
  },
  template: '<admin-header>'
}
</script>

<style scoped>
  .good-news-wrapper {
    width: 700px;
    height: auto;
    margin: 50px auto 100px;
    padding: 50px 0px 0px 0px;
  }

  .line {
    margin-top: 20px;
  }

  .ball {
    color: #55C500;
    margin-top: 30px;
    margin-left: 10px;
  }

  .sentence {
    color: #5F5B5B;
    margin-left: 5px;
    font-weight: bold;
    font-size: 20px;
  }

  .article-box {
    width: 600px;
    height: auto;
    margin-top: 50px;
    margin-left: 50px;
  }

  .blog-title {
    color: #5F5B5B;
    font-size: 25px;
    font-weight: bold;
  }

  .blog-line {
    margin-bottom: 50px;
  }

  .fa-heart {
  color: red;
  }

  .create-date {
  margin-left: 400px;
  }

  a {
    text-decoration: none;
    color: #5F5B5B;
  }

  .article-line {
    margin-bottom: 50px;
  }

  .good-news-pagination {
    margin-left: 60px;
    margin-bottom: 50px;
  }
</style>

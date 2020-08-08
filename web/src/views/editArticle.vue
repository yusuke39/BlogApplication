<template>
<div>
  <admin-header></admin-header>
    <div class="blog-wrapper">
      <div class="blog-contents-wrapper">
        <el-switch
          class="release-switch"
          v-model="releaseValue"
          active-text="公開"
          inactive-text="非公開">
        </el-switch>
        <el-input class="blog-title" v-model="blogTitle"></el-input>
        <p class="blog-create-time">2020/8/15 20:00:00</p>
        <img src="../assets/Bruins.jpg" class="blog-content-img">
        <pre class="blog-content">
          ブログの内容がここに入りますよーーー
          ブログの内容がここに入りますよーーー

          ブログの内容がここに入りますよーーー
          ブログの内容がここに入りますよーーー

          ブログの内容がここに入りますよーーー

          ブログの内容がここに入りますよーーー
        </pre>
        <i class="far fa-heart heart-icon"></i>
        <i class="far fa-bookmark bookmark-icon"></i>
        <hr class="blog-line">
      </div>
      <div class="button-wrapper">
        <el-button type="success" class="edit-button">編集完了</el-button>
        <el-button type="danger" class="delete-button">記事削除</el-button>
      </div>
    </div>
</div>
</template>

<script>
import AdminHeader from './adminHeader'
export default {
  data () {
    return {
      blogTitle: 'ブログタイトル',
      releaseValue: true
    }
  },
  components: {
    AdminHeader
  },
  template: '<admin-header>'
}
</script>

<style>

 .blog-title {
   width: 400px;
 }

 .release-switch {
   position: absolute;
   top: 120px;
   left: 1000px
 }

 .blog-wrapper {
   margin-left: 500px;
   margin-top: 50px;
 }

 .blog-create-time {
   margin-bottom: 50px;
   color: #5F5B5B;
 }

 .blog-content-img {
   width: 400px;
   height: 400px;
   margin-bottom: 30px;
 }

 .blog-content {
   color: #5F5B5B;
 }

  .heart-icon {
   font-size: 20px;
   margin-left: 35px;
  }

  .bookmark-icon {
    font-size: 20px;
    margin-left: 20px;
  }

  .blog-line {
    margin-top: 30px;
    margin-bottom: 30px;
    width: 430px;
  }

  .button-wrapper {
    margin-bottom: 80px;
    margin-left: 20px;
  }

  .edit-button {
    width: 150px;
    margin-right: 50px;
    color: #ffffff;
  }

  .delete-button {
    width: 150px;
    color: #ffffff;
  }
</style>

<template>
  <div>
    <UserHeader></UserHeader>
    <div class="blog-main-img">
    </div>
    <hr>
    <div class="blog-wrapper">
      <div class="blog-contents-wrapper">
        <BlogContents></BlogContents>
        <div class="iconButton-wrapper">
          <GoodArticleButton></GoodArticleButton>
          <SaveArticleButton></SaveArticleButton>
          <CommentButton></CommentButton>
        </div>
        <hr class="blog-line">
      </div>
      <div class="blog-contents-wrapper">
        <BlogContents></BlogContents>
        <div class="iconButton-wrapper">
          <GoodArticleButton></GoodArticleButton>
          <SaveArticleButton></SaveArticleButton>
          <CommentButton></CommentButton>
        </div>
        <hr class="blog-line">
      </div>
      <el-pagination
        class="blog-pagination"
        background
        layout="prev, pager, next"
        :total="1000">
      </el-pagination>
      <BlogUserIcon></BlogUserIcon>
    </div>
  </div>
</template>

<script>
import UserHeader from './userHeader'
import GoodArticleButton from '../components/GoodArticleButton'
import SaveArticleButton from '../components/SaveArticleButton'
import CommentButton from '../components/CommentButton'
import BlogContents from '../components/BlogContents'
import BlogUserIcon from '../components/BlogUserIcon'
export default {
  data () {
    return {
      count: 0,
      isActive: false
    }
  },
  methods: {
    clickHeart () {
      if (this.isActive) {
        this.count = this.count - 1
        this.isActive = false
      } else {
        this.count = this.count + 1
        this.isActive = true
      }
    }
  },
  components: {
    UserHeader,
    GoodArticleButton,
    SaveArticleButton,
    CommentButton,
    BlogContents,
    BlogUserIcon
  }
}
</script>

<style>

  .blog-main-img {
    width: 100%;
    height: 380px;
    background-color: aquamarine;
    margin-bottom: 50px;
  }

  .blog-contents-wrapper {
    width: 500px;
    height: 100%;
    margin: auto;
    margin-top: 30px;
  }

  .iconButton-wrapper {
    display: flex;
  }

  .blog-pagination {
    margin-top: 50px;
    margin-bottom: 100px;
    margin-left: 500px;
  }

  a {
    text-decoration: none;
    color: #55C500;
  }
</style>

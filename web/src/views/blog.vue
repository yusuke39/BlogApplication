<template>
  <div>
    <user-header></user-header>
    <div class="blog-main-img">
    </div>
    <hr>
    <div class="blog-wrapper">
      <div class="blog-contents-wrapper">
        <blog-contents></blog-contents>
        <div class="iconButton-wrapper">
          <good-article-button></good-article-button>
          <save-article-button></save-article-button>
          <comment-button></comment-button>
        </div>
        <hr class="blog-line">
      </div>
      <div class="blog-contents-wrapper">
        <blog-contents></blog-contents>
        <div class="iconButton-wrapper">
          <good-article-button></good-article-button>
          <save-article-button></save-article-button>
          <comment-button></comment-button>
        </div>
        <hr class="blog-line">
      </div>
      <el-pagination
        class="blog-pagination"
        background
        layout="prev, pager, next"
        :total="1000">
      </el-pagination>
      <blog-user-icon></blog-user-icon>
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
    'user-header': UserHeader,
    'good-article-button': GoodArticleButton,
    'save-article-button': SaveArticleButton,
    'comment-button': CommentButton,
    'blog-contents': BlogContents,
    'blog-user-icon': BlogUserIcon
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

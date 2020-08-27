<template>
  <div>
    <UserHeader></UserHeader>
    <div class="blog-main-img">
    </div>
    <hr>
    <div class="blog-wrapper">
      <div class="blog-contents-wrapper">
        <h2>ブログ記事タイトル</h2>
        <p class="blog-create-time">2020/8/15 20:00:00</p>
        <img src="../assets/Bruins.jpg" class="blog-content-img">
        <pre class="blog-content">
          ブログの内容がここに入りますよーーー
          ブログの内容がここに入りますよーーー

          ブログの内容がここに入りますよーーー
          ブログの内容がここに入りますよーーー

          ブログの内容がここに入りますよーーー

          ブログの内容がここに入りますよーーー
          <div class="tag-box">
            <i class="fas fa-tag"></i>
            <div class="tags">
              <router-link to="/tagArticles" class="tag-word">イヌ好き</router-link>
              <router-link to="/tagArticles" class="tag-word">ゴールデン</router-link>
            </div>
          </div>
        </pre>
        <div class="iconButton-wrapper">
          <GoodArticleButton></GoodArticleButton>
          <SaveArticleButton></SaveArticleButton>
          <CommentButton></CommentButton>
        </div>
        <hr class="blog-line">
      </div>
          <div class="blog-contents-wrapper">
        <h2>ブログ記事タイトル</h2>
        <p class="blog-create-time">2020/8/15 20:00:00</p>
        <img src="../assets/logo.png" class="blog-content-img">
        <pre class="blog-content">
          ブログの内容がここに入りますよーーー
          ブログの内容がここに入りますよーーー

          ブログの内容がここに入りますよーーー
          ブログの内容がここに入りますよーーー

          ブログの内容がここに入りますよーーー

          ブログの内容がここに入りますよーーー
          <div class="tag-box">
            <i class="fas fa-tag"></i>
            <div class="tags">
              <router-link to="/tagArticles" class="tag-word">イヌ好き</router-link>
              <router-link to="/tagArticles" class="tag-word">ゴールデン</router-link>
            </div>
          </div>
        </pre>
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
      <div class="blog-icon-wrapper">
        <img src="../assets/Bruins.jpg" class="blog-icon">
        <div class="blog-name">平野祐介</div>
        <pre class="blog-icon-sentence">
          ヒラノのブログです。
          ホッケーが好きです。
        </pre>
      </div>
    </div>
  </div>
</template>

<script>
import UserHeader from './userHeader'
import GoodArticleButton from '../components/GoodArticleButton'
import SaveArticleButton from '../components/SaveArticleButton'
import CommentButton from '../components/CommentButton'
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
    CommentButton
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

  .blog-create-time {
    color: #5F5B5B;
    margin-bottom: 30px;
  }

  .blog-content-img {
    width: 300px;
    height: 300px;
    margin-bottom: 20px;
  }

  .blog-line {
    margin-top: 30px;
    margin-bottom: 30px;
  }

  .blog-pagination {
    margin-top: 50px;
    margin-bottom: 100px;
    margin-left: 500px;
  }

  .blog-icon {
    width: 200px;
    height: 200px;
    border-radius: 100%;
  }

  .blog-name {
    font-size: 30px;
    margin-left: 45px;
    color: #5F5B5B;
    margin-bottom: 10px;
  }

  .blog-icon-sentence {
     color: #5F5B5B;
     text-align: center;
  }

  .blog-icon-wrapper {
    position: absolute;
    top: 600px;
    left: 1050px;
  }

  .fa-tag {
    margin-top: 5px;
    color: #5F5B5B;
  }

  .tag-box {
    margin-top: 20px;
    margin-left: 40px;
    display: flex;
  }

  .tags {
    display: flex;
  }

  .tag-word {
    margin-left: 10px;
  }

  .iconButton-wrapper {
    display: flex;
  }

  a {
    text-decoration: none;
    color: #55C500;
  }
</style>

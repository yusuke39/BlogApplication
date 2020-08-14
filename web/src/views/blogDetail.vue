<template>
  <div>
    <UserHeader></UserHeader>
      <div class="blog-wrapper">
        <div class="blogdetail-contents-wrapper">
          <h2>ブログ記事タイトル</h2>
          <p class="blog-create-time">2020/8/15 20:00:00</p>
          <img src="../assets/Bruins.jpg" class="blogdetail-content-img">
          <pre class="blog-content">
            ブログの内容がここに入りますよーーーブログの内容がここに入りますよーーー
            ブログの内容がここに入りますよーーー

            ブログの内容がここに入りますよーーーブログの内容がここに入りますよーーー
            ブログの内容がここに入りますよーーー

            ブログの内容がここに入りますよーーーブログの内容がここに入りますよーーー

            ブログの内容がここに入りますよーーーブログの内容がここに入りますよーーー
            <div class="tag-box">
              <i class="fas fa-tag"></i>
              <div class="tags">
                <router-link to="/tagArticles" class="tag-word">イヌ好き</router-link>
                <router-link to="/tagArticles" class="tag-word">ゴールデン</router-link>
              </div>
            </div>
          </pre>
          <i
            class="far fa-heart"
            @click="clickHeart"
            :class="{ hearticonclor : isActive }"
            ></i>
            <span class="count">{{ count }}</span>
          <i class="far fa-comment"></i>
          <span class="count">10</span>
          <i class="far fa-bookmark"></i>
          <hr class="blog-line">
          <form>
            <el-input
              class="comment-input"
              type="textarea"
              autosize
              placeholder="コメントを入力してください"
              v-model="comment">
          </el-input>
          </form>
          <p class="comment-list">コメント一覧</p>
          <div class="comment-box">
            <span>1</span>.
            <router-link to="/blog" class="comment-name">れおれお</router-link>
            <span class="comment-date">2018/8/15</span>
            <div class="comment">
              <pre>
              こんばんは,犬が可愛いですね。
              私は猫派です😆
              あーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
              あーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
              </pre>
            </div>
            <hr>
          </div>
          <div class="comment-box">
            <span>2</span>.
            <router-link to="/blog" class="comment-name">れおれお</router-link>
            <span class="comment-date">2018/8/15</span>
            <div class="comment">
              <pre>
              こんばんは,犬が可愛いですね。
              私は猫派です😆
              あーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
              あーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
              </pre>
            </div>
            <hr>
          </div>
        </div>
        <div class="commentpage-icon-wrapper">
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
export default {
  data () {
    return {
      count: 0,
      isActive: false,
      comment: ''
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
    UserHeader
  }
}
</script>

<style>
   .blogdetail-contents-wrapper {
    width: 800px;
    height: 100%;
    margin: auto;
    margin-top: 30px;
  }

  .blog-create-time {
    color: #5F5B5B;
    margin-bottom: 30px;
  }

  .blogdetail-content-img {
    width: 500px;
    height: 400px;
    margin-bottom: 20px;
  }

  .blog-line {
    margin-top: 30px;
    margin-bottom: 30px;
  }

   .blog-icon {
    width: 200px;
    height: 200px;
    border-radius: 100%;
  }

  .fa-heart {
    font-size: 20px;
    margin-left: 35px;
    color: #5F5B5B;
  }

  .fa-bookmark {
    font-size: 20px;
    margin-left: 20px;
    color: #5F5B5B;
  }

  .fa-comment {
    font-size: 20px;
    margin-left: 20px;
    color: #5F5B5B;
  }

  .count {
    color: #5F5B5B;
  }

  .hearticonclor {
    color: red;
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

  .comment-input {
    margin-bottom: 70px;
  }

  .comment-list {
    font-size: 20px;
    font-weight: bold;
    margin-bottom: 50px;
  }

  .comment-box {
    margin-bottom: 50px;
  }

  .comment-name {
    margin-right: 40px;
    color: #5F5B5B;
  }

  .comment-date {
    color: #5F5B5B;
  }

  .comment {
    color: #5F5B5B;
    margin-left: -40px;
    margin-top: 20px
  }

  .commentpage-icon-wrapper {
    position: absolute;
    top: 200px;
    left: 1050px;
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

  a {
    text-decoration: none;
    color: #55C500;
  }
</style>
